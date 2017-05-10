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
        this.updateLogin = this.updateLogin.bind(this);
        this.updatePassword = this.updatePassword.bind(this);
        this.logIn = this.logIn.bind(this);
    }

    updateLogin(evt) {
        this.setState({login: evt.target.value});
    }
    updatePassword(evt) {
        this.setState({password: evt.target.value});
    }
    logIn() {
        this.props.toLogIn(this.state.login, this.state.password)
    }

    render() {
        // if (this.props.user) {
        //     hashHistory.push("/user")
        // }
        return (
            <div id="form">
                <input type="text" className="form-control" placeholder="login"
                       onChange={this.updateLogin} />
                <h4>{this.state.login}</h4>
                <input type="password" className="form-control" placeholder="password"
                       onChange={this.updatePassword} />
                <h4>{this.state.password}</h4>
                <button className="btn btn-lg btn-default btn-block"
                        onClick={this.logIn}>Log In</button>
                <Link to="/signup">registration</Link>
                <div>{this.props.error ? this.props.error.message : null}</div>
            </div>
        );
    }
}
const mapStateToProps = function(state) {
    return {
        user: state.userState.user,
        error: state.userState.error
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