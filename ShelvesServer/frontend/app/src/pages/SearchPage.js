import React, { Component } from 'react';

import { Link } from 'react-router';
import Request from '../api/RequesterAPI.js'


class SearchPage extends Component {

    constructor(props) {
        super(props);
        this.state = { books: [] };
        Request.send("GET", "/webresources/books/all").then(r => this.setState({ books: r }));
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
                <td className="col-md-2"><Link to={`/book/${book[0].bookid}`}>{book[0].bookname}</Link></td>
                <td className="col-md-2"><Link to={`/author/${book[0].authorid}`}>{book[1] + ' ' + book[2]}</Link></td>
                <td className="col-md-1">{book[0].date}</td>
                <td className="col-md-1">{book[0].series}</td>
                <td className="col-md-1">{book[0].seriesnumber}</td>
                <td className="col-md-1">{book[0].genre}</td>
                <td className="col-md-3">{book[0].annotation}</td>
            </tr>
        )
    }

    render() {
        return (
            <div className="panel panel-default scrolling-table">
                <table className="table table-hover">
                    <thead>
                    <tr className="info">
                        <th className="col-md-1">Фото</th>
                        <th className="col-md-2">Название</th>
                        <th className="col-md-2">Автор</th>
                        <th className="col-md-1">Год</th>
                        <th className="col-md-1">Цикл</th>
                        <th className="col-md-1">№</th>
                        <th className="col-md-1">Жанр</th>
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
        )
    }
}

export default SearchPage;
