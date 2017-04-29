import React, { Component } from 'react';

import Request from '../api/RequesterAPI.js'
import { connect } from 'react-redux';
import SideInfo from '../components/SideInfo.js'

import { Redirect, Link } from 'react-router-dom';

class UserPage extends Component {

    constructor(props) {
        super(props);
        this.state = { userBooks: []};
        Request.get("GET", "books").then(r => this.setState({ userBooks: r }));
    }


    viewBook(book) {
        return (
			<tr key={book.bookId}>
                <td className="col-md-2"><Link to={`/book/${book.bookId}`}>{book.bookName}</Link></td>
				<td className="col-md-2">{book.bookAutor}</td>
				<td className="col-md-1">{book.bookPublYear}</td>
				<td className="col-md-1">{book.bookSeries}</td>
				<td className="col-md-1">{book.bookSerNum}</td>
				<td className="col-md-1">{book.bookGenre}</td>
				<td className="col-md-4 comment">{book.bookAnnot}</td>
			</tr>
        )
    }

	render() {
        if (!this.props.user)
            return <Redirect to="/login" />

		return (
            <div className="row">
                <div className="col-md-2">
                    <SideInfo photoSrc="../assets/img/usersImg/user1.jpg">
                        <b>login: {this.props.user.userLogin}</b><br />
                        <b>name: {this.props.user.userName}</b><br />
                        sex: {this.props.user.userSex}<br />
                        about me: {this.props.user.userSketch}
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

                    {/*books*/}
                    <div className="panel panel-default scrolling-table">
                        <table className="table table-hover">
                            <thead>
                            <tr className="info">
                                <th className="col-md-2">Название</th>
                                <th className="col-md-2">Автор</th>
                                <th className="col-md-1">Год</th>
                                <th className="col-md-1">Цикл</th>
                                <th className="col-md-1">№</th>
                                <th className="col-md-1">Жанр</th>
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
