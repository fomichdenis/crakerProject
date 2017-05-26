import React, { Component } from 'react';

import Request from '../api/RequesterAPI.js'
import SideInfo from '../components/SideInfo.js'

import { Link } from 'react-router';

class AuthorPage extends Component {

    constructor(props) {
        super(props);
        this.state = { author: [], books: []};
        Request.send("GET", `/webresources/authors/find?id=${this.props.params.id}`).then(r => this.setState({ author: r }));
        Request.send("GET", `/webresources/books/findbyauthor?id=${this.props.params.id}`).then(r => this.setState({ books: r }));
    }


    viewBook(book) {
        return (
            <tr key={book.bookid}>
                <td className="col-md-1">
                    <Link to={`/book/${book.bookid}`}>
                        <img id='photo'
                             src={`assets/img/books/${book.bookid}.jpg`}
                             onError={(evt)=>{evt.target.src='assets/img/ghost.jpg'}} />
                    </Link>
                </td>
                <td className="col-md-2"><Link to={`/book/${book.bookid}`}>{book.bookname}</Link></td>
                <td className="col-md-2">{this.state.author.authorname + ' ' + this.state.author.authorsurname}</td>
                <td className="col-md-1">{book.date}</td>
                <td className="col-md-2">{book.genre}</td>
                <td className="col-md-3">{book.annotation}</td>
            </tr>
        )
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-3">
                    <SideInfo photoSrc={`assets/img/authors/${this.state.author.authorid}.jpg`}>
                        <b>{this.state.author.authorname + ' ' + this.state.author.authorsurname}</b><br />
                        {this.state.author.yearbirthday + ' - ' + this.state.author.deathyear}<br />
                    </SideInfo>
                </div>
                <div className="col-md-9">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <div className="row">
                                <div className="col-md-8">
                                    {/*info*/}
                                    <h3>{this.state.author.authorname + ' ' + this.state.author.authorsurname}</h3><br />
                                    <b>Годы жизни: </b>{this.state.author.yearbirthday + ' - ' + (this.state.author.deathyear ?
                                            this.state.author.deathyear : "...")}<br />
                                    <b>Биография: </b><br />
                                    {this.state.author.information}
                                </div>
                                <div className="col-md-4">
                                    {/*statistics*/}
                                    <h3>Статистика </h3><br />
                                    <b>Написано книг: </b><br /><br />
                                    <b>Лучшие книги: </b><br /><br />
                                    <b>Рейтинг: </b><br />
                                    <div className="progress">
                                        <div className="progress-bar progress-bar-success" style={{width: '80%'}}>
                                            80%
                                        </div>
                                        <div className="progress-bar progress-bar-danger" style={{width: '20%'}}>
                                            20%
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
                                <th className="col-md-1">Фото</th>
                                <th className="col-md-2">Название</th>
                                <th className="col-md-2">Автор</th>
                                <th className="col-md-1">Год</th>
                                <th className="col-md-2">Жанр</th>
                                <th className="col-md-3">Описание</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.books ?
                                    this.state.books.map((book) => this.viewBook(book)) : null
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
}
export default AuthorPage;
