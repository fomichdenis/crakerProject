import React, { Component } from 'react'
import { connect } from 'react-redux';
import { Link, hashHistory } from 'react-router'

import * as actions from '../redux/actions/UsersActions.js'

class LogIn extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: ''
        }
        this.handleChange = this.handleChange.bind(this);
        this.logIn = this.logIn.bind(this);
    }

    handleChange(evt) {
        this.setState({ [evt.target.name]: evt.target.value })
    }
    logIn() {
        this.props.toLogIn(this.state.login, this.state.password)
    }

    render() {
        if (this.props.user) {
            hashHistory.push("/user")
        }
        return (
            <div id="form">
                <input name="login" type="text" className="form-control" placeholder="login"
                       onChange={this.handleChange} />
                <h4>{this.state.login}</h4>
                <input name="password" type="password" className="form-control" placeholder="password"
                       onChange={this.handleChange} />
                <h4>{this.state.password}</h4>
                <button className="btn btn-lg btn-default btn-block"
                        onClick={this.logIn}>Log In</button>
                <Link to="/signup">registration</Link>
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
        toLogIn: (login, password) => {
            dispatch(actions.logIn(login, password))
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(LogIn);