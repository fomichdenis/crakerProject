import React, { Component } from 'react';

import Request from '../api/RequesterAPI.js'
import SideInfo from '../components/SideInfo.js'

import { Link } from 'react-router';

class AuthorPage extends Component {

    constructor(props) {
        super(props);
        this.state = { author: [], books: []};
        Request.get("GET", `/webresources/authors/find?id=${this.props.params.id}`).then(r => this.setState({ author: r }));
        Request.get("GET", `/webresources/books/findbyauthor?id=${this.props.params.id}`).then(r => this.setState({ books: r }));
    }


    viewBook(book) {
        return (
            <tr key={book.bookid}>
                <td className="col-md-2"><Link to={`/book/${book.bookid}`}>{book.bookname}</Link></td>
                <td className="col-md-2"><Link to={`/author/${book.authorid}`}>{book.authorid}</Link></td>
                <td className="col-md-1">{book.date}</td>
                <td className="col-md-1">{book.series}</td>
                <td className="col-md-1">{book.seriesnumber}</td>
                <td className="col-md-1">{book.genre}</td>
                <td className="col-md-4">{book.annotation}</td>
            </tr>
        )
    }

    render() {
        return (
            <div className="row">
                <div className="col-md-2">
                    <SideInfo photoSrc="../assets/img/usersImg/user1.jpg">
                        <b>name: {this.state.author.authorname}</b><br />
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
