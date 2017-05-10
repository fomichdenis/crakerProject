import React, { Component } from 'react'
import { connect } from 'react-redux';

import * as actions from '../redux/actions/UsersActions.js'

class SignUp extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: '',
            password: '',
            sex: '',
            sketch: ''
        }
        this.handleChange = this.handleChange.bind(this);
        this.signUp = this.signUp.bind(this);
    }

    handleChange(evt) {
        this.setState({
            [evt.target.name]: evt.target.value
        });
    }

    signUp() {
        this.props.toSignUp(this.state)
    }

    render() {
        return (
            <div id="form">
                <input name="login" type="text" className="form-control" onChange={this.handleChange} placeholder="login" />
                <h4>{this.state.login}</h4>
                <input name="password" type="text" className="form-control" onChange={this.handleChange} placeholder="password" />
                <h4>{this.state.password}</h4>
                <label className="radio-inline"><input name="sex" type="radio" onChange={this.handleChange} />Male</label>
                <label className="radio-inline"><input name="sex" type="radio" onChange={this.handleChange} />Female</label>
                <input name="sketch" type="text" className="form-control" onChange={this.handleChange} placeholder="sketch"/>
                <h4>{this.state.sketch}</h4>
                <input type="submit" className="btn btn-lg btn-default btn-block" />
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
        toSignUp: (data) => {
            dispatch(actions.logIn(data))
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(SignUp);