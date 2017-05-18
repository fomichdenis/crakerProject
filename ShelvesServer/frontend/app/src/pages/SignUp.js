import React, { Component } from 'react'
import { connect } from 'react-redux';
import { Link, hashHistory } from 'react-router'

import * as actions from '../redux/actions/UsersActions.js'

class SignUp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
            username: '',
            usersurname: '',
            sex: '0',
            information: ''
        }
        this.handleChange = this.handleChange.bind(this);
        this.signUp = this.signUp.bind(this);
    }

    handleChange(evt) {
        this.setState({ [evt.target.name]: evt.target.value })
    }

    signUp() {
        this.props.toSignUp(this.state)
        if (!this.props.error) {
        }
    }

    render() {
        if (this.props.user) {
            hashHistory.push("/user")
        }
        return (
            <div id="form">
                <input name="login" type="text" className="form-control" onChange={this.handleChange} placeholder="логин" />
                <input name="password" type="password" className="form-control" onChange={this.handleChange} placeholder="пароль" />
                <input name="username" type="text" className="form-control" onChange={this.handleChange} placeholder="имя" />
                <input name="usersurname" type="text" className="form-control" onChange={this.handleChange} placeholder="фамилия" />
                <select className="form-control" name="sex" onChange={this.handleChange}>
                    <option value="0">муж</option>
                    <option value="1">жен</option>
                </select>
                <textarea name="information" type="text" className="form-control" onChange={this.handleChange} placeholder="обо мне"/>
                <button className="btn btn-lg btn-default btn-block" onClick={this.signUp}>Sign up</button>
                <Link to="/login">У меня есть аккаунт</Link>
                <div>{this.props.error ? this.props.error.message : null}</div>
            </div>
        );
    }
}
const mapStateToProps = function(store) {
    return {
        user: store.userState.user,
        error: store.userState.error
    };
}

const mapDispatchToProps = (dispatch) => {
    return {
        toSignUp: (data) => {
            dispatch(actions.signUp(data))
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(SignUp);