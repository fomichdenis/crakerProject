import React, { Component } from 'react';

import { connect } from 'react-redux';
import SideInfo from '../components/SideInfo';
import AuthorForm from '../components/AuthorForm';
import BookForm from '../components/BookForm';

import Request from '../api/RequesterAPI.js';

import { Link, hashHistory } from 'react-router';

class UserPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userBooks: [],
        };

        if (this.props.user) {
            Request.send("GET", `/webresources/records/all?id=${this.props.user.userid}`)
                .then(r => this.setState({ userBooks: r }))
        }
    }

    viewBook(book) {
        return (
			<tr key={book[0].bookid}>
                <td className="col-md-1">
                    <Link to={`/book/${book[0].bookid}`}>
                        <img id='photo'
                             src={`assets/img/books/${book[0].bookid}.jpg`}
                             onError={(evt)=>{evt.target.src='assets/img/ghost.jpg'}} />
                    </Link>
                </td>
                <td className="col-md-1"><Link to={`/book/${book[0].bookid}`}>{book[0].bookname}</Link></td>
                <td className="col-md-1"><Link to={`/author/${book[0].authorid}`}>{book[1] + ' ' + book[2]}</Link></td>
                <td className="col-md-1">{book[0].date}</td>
                <td className="col-md-1">{book[0].series}</td>
                <td className="col-md-1">{book[0].seriesnumber}</td>
                <td className="col-md-1">{book[0].genre}</td>
                <td className="col-md-1">{book[3].progress}</td>
                <td className="col-md-1">{book[3].rate}</td>
                <td className="col-md-3">{book[3].text}</td>
			</tr>
        )
    }

	render() {
        if (!this.props.user)
            hashHistory.push('/login');

		return (
            <div className="row">
                <div className="col-md-2">
                    <SideInfo photoSrc={`assets/img/users/${this.props.user.userid}.jpg`}>
                        <b>логин: {this.props.user.login}</b><br />
                        <b>имя: {this.props.user.username}</b><br />
                        <b>пол:</b> {
                            this.props.user.sex===0 ?
                                "муж" : "жен"
                        }<br />
                        <b>обо мне:</b> {this.props.user.information}<br />
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

                    <div className="row">
                        <div className="col-md-6">
                            {/*new book*/}
                            <BookForm />
                        </div>
                        <div className="col-md-6">
                            {/*new author*/}
                            <AuthorForm />
                        </div>
                    </div>

                    {/*books*/}
                    <div className="panel panel-default scrolling-table">
                        <table className="table table-hover">
                            <thead>
                                <tr className="info">
                                    <th className="col-md-1">Фото</th>
                                    <th className="col-md-1">Название</th>
                                    <th className="col-md-1">Автор</th>
                                    <th className="col-md-1">Дата</th>
                                    <th className="col-md-1">Серия</th>
                                    <th className="col-md-1">№</th>
                                    <th className="col-md-1">Жанр</th>
                                    <th className="col-md-1">Прогресс</th>
                                    <th className="col-md-1">Оценка</th>
                                    <th className="col-md-3">Впечатление</th>
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

const mapStateToProps = function(store) {
    return {
        user: store.userState.user
    };
}
export default connect(mapStateToProps)(UserPage);
