import React, { Component } from 'react';

import { connect } from 'react-redux';
import SideInfo from '../components/SideInfo.js'

import Request from '../api/RequesterAPI.js'

import { Link, hashHistory } from 'react-router';

class UserPage extends Component {

    constructor(props) {
        super(props);
        this.state = { userBooks: [], open: false, newBook: {bookid: '', progress: '', rate: '', status: '', text: ''}};

        if (this.props.user) {
            Request.get("GET", `/webresources/records/findbyuser?id=${this.props.user.userid}`).then(r => this.setState({ userBooks: r }))
        }

        this.handleChange = this.handleChange.bind(this);
        this.addBook = this.addBook.bind(this);
    }

    handleChange(evt) {
        this.setState({
            [evt.target.name]: evt.target.value
        });
    }

    addBook(evt) {
        this.setState({ open: !this.state.open })
        if (this.state.open === true) {
            Request.put("POST", "/webresources/records", this.state.newBook)
        }
    }


    viewBook(book) {
        return (
			<tr key={book.bookid}>
                <td className="col-md-2"><Link to={`/book/${book.bookid}`}>{book.bookid}</Link></td>
                {/*<td className="col-md-2"><Link to={`/author/${book.authorid}`}>{book.authorid}</Link></td>*/}
                <td className="col-md-1">{book.progress}</td>
                <td className="col-md-1">{book.rate}</td>
                <td className="col-md-1">{book.status}</td>
                <td className="col-md-1">{book.text}</td>
			</tr>
        )
    }

	render() {
        if (!this.props.user)
            hashHistory.push('/login');

		return (
            <div className="row">
                <div className="col-md-2">
                    <SideInfo photoSrc="../assets/img/usersImg/user1.jpg">
                        <b>login: {this.props.user.login}</b><br />
                        <b>name: {this.props.user.username}</b><br />
                        sex: {this.props.user.sex}<br />
                        about me: {this.props.user.information}<br />
                    </SideInfo>
                </div>
                <div className="col-md-10">
                    {/*statistics*/}
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-6">
                                    statistics
                                </div>
                                <div className="col-md-6">
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: 70}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-warning progress-bar-striped" style={{width: 50}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: 30}}>
                                            <span className="sr-only" />
                                        </div>
                                    </div>
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: 70}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-warning progress-bar-striped" style={{width: 50}}>
                                            <span className="sr-only" />
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: 30}}>
                                            <span className="sr-only" />
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    {/*new book*/}
                    <div className="panel panel-default">
                    <button name="close" className="btn btn-lg btn-default btn-block" onClick={this.addBook}>add</button>
                    {this.state.open === true ?
                        <div>
                            <input name="bookid" type="text" className="form-control" placeholder="bookId"
                            onChange={this.handleChange} />
                            <input name="progress" type="text" className="form-control" placeholder="progress"
                            onChange={this.handleChange} />
                            <input name="rate" type="text" className="form-control" placeholder="rating"
                            onChange={this.handleChange} />
                            <input name="status" type="text" className="form-control" placeholder="status"
                            onChange={this.handleChange} />
                            <input name="text" type="text" className="form-control" placeholder="opinion"
                            onChange={this.handleChange} />
                        </div>
                        : null
                    }
                    </div>


                    {/*books*/}
                    <div className="panel panel-default scrolling-table">
                        <table className="table table-hover">
                            <thead>
                                <tr className="info">
                                    <th className="col-md-2">Название</th>
                                    <th className="col-md-2">Прогресс</th>
                                    <th className="col-md-1">Рейтинг</th>
                                    <th className="col-md-2">Статус</th>
                                    <th className="col-md-4">Описание</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.userBooks ?
                                this.state.userBooks.map((book) => this.viewBook(book)) : null
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
		)
	}
}

const mapStateToProps = function(state) {
    return {
        user: state.userState.user
    };
}
export default connect(mapStateToProps)(UserPage);
