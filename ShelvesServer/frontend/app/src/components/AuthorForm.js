import React, { Component } from 'react';
import Request from '../api/RequesterAPI'


class AuthorForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false,

            authorname: undefined,
            authorsurname: undefined,
            yearbirthday: undefined,
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
        let newAuthor = {
            authorname: this.state.authorname,
            authorsurname: this.state.authorsurname,
            yearbirthday: this.state.yearbirthday,
            deathyear: this.state.deathyear,
            information: this.state.information
        }
        if (this.state.open === true) {
            Request.send("POST", "/webresources/authors/create", newAuthor)
        }
    }

    render() {
        return (
            <div className="panel panel-default">
                <button type="submit" name="close" className="btn btn-lg btn-default btn-block" onClick={this.add}>Добавить автора</button>
                {
                    this.state.open === true ?
                        <div onChange={this.handleChange}>
                            <input name="authorname" type="text" className="form-control" placeholder="имя" />
                            <input name="authorsurname" type="text" className="form-control" placeholder="фамилия" />
                            <input name="yearbirthday" type="number" className="form-control" placeholder="год рождения" />
                            <input name="deathyear" type="number" className="form-control" placeholder="год смерти" />
                            <textarea name="information" type="text" className="form-control" placeholder="биография" />
                        </div>
                        : null
                }
            </div>
        );
    }
}

export default AuthorForm;