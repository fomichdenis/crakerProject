import React, { Component } from 'react';

import { connect } from 'react-redux';

import Request from '../api/RequesterAPI'
import { Link } from 'react-router';

import * as actions from '../redux/actions/UsersActions.js'


class NavBar extends Component {

    constructor(props) {
        super(props);
        this.state = { books: undefined, authors: undefined };

        this.find = this.find.bind(this);
        this.clear = this.clear.bind(this);
    }

    clear() {
        this.setState({ books: undefined, authors: undefined })
    }

    find(evt) {
        let data = evt.target.value;
        if (data !== undefined && data.trim() !== '') {
            Request.send("GET", `/webresources/search?data=${evt.target.value}`)
                .then(r => {
                    if (r.books !== undefined) {
                        this.setState({books: r.books})
                    } else this.setState({ books: undefined });
                    if (r.authors !== undefined) {
                        this.setState({authors: r.authors})
                    } else this.setState({ authors: undefined })
                })
        }
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
                            <input type="text" className="form-control dropdown-toggle" placeholder="Search" onChange={this.find} />
                        </div>
                        {(this.state.books || this.state.authors) ?
                            <ul id="search">
                                {this.state.books ?
                                    this.state.books.map(b => <li key={"b" + b[0]}><Link to={`/book/${b[0]}`} className="item">{b[1]}</Link></li>) : null}
                                {this.state.authors ?
                                    this.state.authors.map(a => <li key={"a" + a[0]}><Link to={`/author/${a[0]}`} className="item">{a[1] + ' ' + a[2]}</Link></li>) : null}
                            </ul>
                            : null}
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
const mapStateToProps = function(store) {
    return {
        user: (store.userState.user !== undefined)
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