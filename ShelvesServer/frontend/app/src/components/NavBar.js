import React, { Component } from 'react';

import { connect } from 'react-redux';

import Request from '../api/RequesterAPI'
import { Link } from 'react-router';

import * as actions from '../redux/actions/UsersActions.js'


class NavBar extends Component {

    constructor(props) {
        super(props);
        this.state = { book: null };
        this.showBook = this.showBook.bind(this);
    }

    showBook() {
        Request.get("POST", "books", this.input.value).then(r => this.setState({ book: r }));
    }

    render() {
        return (
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <img id="brand" src="assets/img/shelves.jpg" alt="Shelves" />
                    </div>
                    <ul className="nav navbar-nav">
                        {this.props.user ? <li><Link to="/user">My Page</Link></li> : null}
                        <li><Link to="/">Books Search</Link></li>
                    </ul>
                    <div className="navbar-form navbar-right">
                        <div className="input-group">
                            <input type="text" className="form-control" placeholder="Search" ref={(input) => {this.input = input}} />
                            <span className="input-group-btn">
                                <button className="btn btn-default" type="button" onClick={this.showBook}>Go!</button>
                            </span>
                        </div>
                        {
                            this.props.user ?
                            <a className="btn btn-main" onClick={this.props.LogOut}><b>Log Out</b></a> : <Link to="/login" className="btn btn-main"><b>Log In</b></Link>
                        }
                    </div>
                </div>
            </nav>

        );
    }
}
const mapStateToProps = function(state) {
    return {
        user: (state.userState.user !== undefined)
    };
}
const mapDispatchToProps = (dispatch) => {
    return {
        LogOut: () => {
            dispatch(actions.logOut())
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(NavBar);