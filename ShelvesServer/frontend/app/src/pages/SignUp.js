import React, { Component } from 'react'
import { connect } from 'react-redux';
import { Redirect } from 'react-router-dom'

import * as actions from '../redux/actions/UsersActions.js'

class SignUp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
            sex: undefined,
            sketch: ''
        }
        this.handleChange = this.handleChange.bind(this);
        this.signUp = this.signUp.bind(this);
    }

    handleChange() {
        this.setState({
            [target.name]: target.value
        });
    }

    signUp() {
        this.props.toSignUp(this.state)
    }

    render() {
        return (
            <form onSubmit={this.signUp}>
                <input name="login" type="text" className="form-control" value={this.state.value} onChange={this.handleChange} placeholder="login"/>
                <input name="password" type="text" className="form-control" value={this.state.value} onChange={this.handleChange} placeholder="password"/>
                <select name="sex" value={this.state.value} onChange={this.handleChange}>
                    <option value="0">Woman</option>
                    <option value="1">Man</option>
                </select>
                <input name="sketch" type="text" className="form-control" value={this.state.value} onChange={this.handleChange} placeholder="sketch"/>
                <input type="submit" className="btn btn-lg btn-default btn-block" />
            </form>
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
        toSignUp: (data) => {
            dispatch(actions.logIn(data))
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(SignUp);