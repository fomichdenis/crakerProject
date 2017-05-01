import React, { Component } from 'react';

import { Link } from 'react-router';
import Request from '../api/RequesterAPI.js'


class SearchPage extends Component {

    constructor(props) {
        super(props);
        this.state = { books: undefined };
        Request.get("GET", "/webresources/books/findrange?from=0&to=2").then(r => this.setState({ books: r }));
    }


    viewBook(book) {
        return (
            <tr key={book.bookid}>
                <td className="col-md-2"><Link to={`/book/${book.bookid}`}>{book.bookname}</Link></td>
                <td className="col-md-2">{book.autorid}</td>
                <td className="col-md-1">{book.date}</td>
                <td className="col-md-1">{book.series}</td>
                <td className="col-md-1">{book.seriesnumber}</td>
                <td className="col-md-1">{book.genre}</td>
                <td className="col-md-4 comment">{book.annotation}</td>
            </tr>
        )
    }

    renderPage() {

    }

    render() {
        return (
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
        )
    }
}

export default SearchPage;
