import React, { Component } from 'react';

import { connect } from 'react-redux';
import SideInfo from '../components/SideInfo';
import AuthorForm from '../components/AuthorForm';
import BookForm from '../components/BookForm';

import Request from '../api/RequesterAPI.js';

import { Link, hashHistory } from 'react-router';
import * as actions from '../redux/actions/UsersActions.js'

class UserPage extends Component {

    constructor(props) {
        super(props);
        this.state = { userBooks: [] };

        if (this.props.user) {
            Request.send("GET", `/webresources/records/all?id=${this.props.user.userid}`)
                .then(r => this.setState({ userBooks: r }));
            this.props.loadBooks(this.props.user.userid)
        }
    }

    viewBook(book) {
        return (
			<tr id={book[0].bookid} key={book[0].bookid}>
                <td className="col-md-1">
                    <Link to={`/book/${book[0].bookid}`}>
                        <img id='photo'
                             src={`assets/img/books/${book[0].bookid}.jpg`}
                             onError={(evt)=>{evt.target.src='assets/img/ghost.jpg'}} />
                    </Link>
                </td>
                <td className="col-md-2"><Link to={`/book/${book[0].bookid}`}>{book[0].bookname}</Link></td>
                <td className="col-md-2"><Link to={`/author/${book[0].authorid}`}>{book[1] + ' ' + book[2]}</Link></td>
                <td className="col-md-1">{book[0].date}</td>
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
                        <button className="btn btn-default btn-sm btn-block">Изменить</button>
                    </SideInfo>
                </div>
                <div className="col-md-10">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-8">
                                    {/*info*/}
                                    <h3>{this.props.user.username + ' ' + this.props.user.usersurname}</h3><br />
                                    <b>Логин: {this.props.user.login}</b><br />
                                    <b>Пол:</b> {this.props.user.sex===0 ? "муж" : "жен"}<br />
                                    <b>Обо мне:</b> {this.props.user.information}<br />
                                </div>
                                <div className="col-md-4">
                                    {/*statistics*/}
                                    <h3>Статистика</h3><br />
                                    <b>Прочитано книг:</b><br /><br />
                                    <b>Книг в процессе чнения:</b><br /><br />
                                    <b>Любимые книги:</b><br /><br />
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
                                    <th className="col-md-2">Название</th>
                                    <th className="col-md-2">Автор</th>
                                    <th className="col-md-1">Дата</th>
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
const mapDispatchToProps = (dispatch) => {
    return {
        loadBooks: (userId) => {
            dispatch(actions.loadBooks(userId))
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(UserPage);
