import React, { Component } from 'react';
import Request from '../api/RequesterAPI'


class BookForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false,

            bookname: undefined,
            authorname: undefined,
            authorsurname: undefined,
            date: undefined,
            genre: undefined,
            annotation: undefined

    }

        this.handleChange = this.handleChange.bind(this);
        this.add = this.add.bind(this);
    }

    handleChange(evt) {
        this.setState({
            [evt.target.name]: evt.target.value
        });
    }

    add(evt) {
        this.setState({ open: !this.state.open })
        let newBook = {
            bookname: this.state.boookname,
            date: this.state.date,
            genre: this.state.genre,
            annotation: this.state.annotation
        }
        let author = {
            authorname: this.state.authorname,
            authorsurname: this.state.authorsurname
        }
        if (this.state.open === true) {
            Request.send("POST", "/webresources/books/create", newBook)
        }
    }

    render() {
        return (
            <div className="panel panel-default">
                <button type="submit" name="close" className="btn btn-lg btn-default btn-block" onClick={this.add}>Добавить книгу</button>
                {
                    this.state.open === true ?
                        <div onChange={this.handleChange}>
                            <input name="bookname" type="text" className="form-control" placeholder="название" />
                            <input name="authorname" type="text" className="form-control" placeholder="имя автора" />
                            <input name="authorsurname" type="text" className="form-control" placeholder="фамилия автора" />
                            <input name="date" type="number" className="form-control" placeholder="дата создания" />
                            <input name="genre" type="text" className="form-control" placeholder="жанр" />
                            <textarea name="annotation" type="text" className="form-control" placeholder="описание" />
                        </div>
                        : null
                }
            </div>
        );
    }
}

export default BookForm;