import React, { Component } from 'react';

import SideInfo from '../components/SideInfo.js'

import { connect } from 'react-redux';
import Request from '../api/RequesterAPI'
import * as actions from '../redux/actions/UsersActions.js'

class BookPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            bookid: undefined,
            bookname: undefined,
            authorid: undefined,
            authorname: undefined,
            authorsurname: undefined,
            date: undefined,
            genre: undefined,
            annotation: undefined
        };
        Request.send("GET", `/webresources/books/find?id=${this.props.params.id}`)
            .then(r => {this.setState({
                bookid: r[0].bookid,
                bookname: r[0].bookname,
                authorid: r[0].authorid,
                authorname: r[1],
                authorsurname: r[2],
                date: r[0].date,
                genre: r[0].genre,
                annotation: r[0].annotation
            })});

        this.addBook = this.addBook.bind(this);
        this.remBook = this.remBook.bind(this);
    }

    addBook() {
        Request.send("POST", "/webresources/records/create", { bookid: this.state.bookid, userid: this.props.user.userid })
            .then(
                success => this.props.loadBooks(this.props.user.userid)
            )
    }

    remBook() {
        Request.send("POST", "/webresources/records/remove", { bookid: this.state.bookid, userid: this.props.user.userid })
            .then(
                success => this.props.loadBooks(this.props.user.userid)
            )
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <SideInfo photoSrc={`assets/img/books/${this.state.bookid}.jpg`}>
                        <b>{this.state.bookname}</b><br />
                        <b>({this.state.authorname + ' ' + this.state.authorsurname})</b><br />
                        {(this.props.user) ?
                            <div><br />
                                {this.props.books.includes(this.state.bookid) ?
                                    <button className="btn btn-danger btn-lg btn-block" onClick={this.remBook}>Удалить книгу</button> :
                                    <button className="btn btn-primary btn-lg btn-block" onClick={this.addBook}>Добавить книгу</button>}
                            </div>
                            :
                            null
                        }
                    </SideInfo>
                </div>

                <div className="col-md-9">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-8">
                                    {/*info*/}
                                    <h3>{this.state.bookname}</h3><br />
                                    <b>Автор: {this.state.authorname + ' ' + this.state.authorsurname}</b><br />
                                    <b>Год публикации: {this.state.date}</b><br />
                                    <b>Жанр: {this.state.genre}</b><br />
                                    <b>Описание:</b><br />
                                    {this.state.annotation}
                                </div>
                                <div className="col-md-4">
                                    {/*statistics*/}
                                    <h3>Статистика</h3><br />
                                    <b>Прочитало человек: </b><br /><br />
                                    <b>Читает человек: </b><br /><br />
                                    <b>Рейтинг: </b><br />
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: '70%'}}>
                                            70%
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: '30%'}}>
                                            30%
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps = function(store) {
    return {
        user: store.userState.user,
        books: store.userState.books
    };
}
const mapDispatchToProps = (dispatch) => {
    return {
        loadBooks: (userId) => {
            dispatch(actions.loadBooks(userId))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(BookPage);
