import React, { Component } from 'react';
import Request from '../api/RequesterAPI'


class BookForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false,

            authorname: undefined,
            authorsurname: undefined,
            deathyear: undefined,
            information: undefined
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
            authorname: this.state.authorname,
            authorsurname: this.state.authorsurname,
            deathyear: this.state.deathyear,
            information: this.state.information
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
                            <input name="authorname" type="text" className="form-control" placeholder="authorname" />
                            <input name="authorsurname" type="text" className="form-control" placeholder="authorsurname" />
                            <input name="deathyear" type="number" className="form-control" placeholder="deathyear" />
                            <textarea name="information" type="text" className="form-control" placeholder="information" />
                        </div>
                        : null
                }
            </div>
        );
    }
}

export default BookForm;