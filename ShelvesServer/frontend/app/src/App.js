import React, { Component, PropTypes } from 'react';

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


import UserPage from './pages/UserPage';
import NavBar from './components/NavBar'
import LogIn from './pages/LogIn'
import BookPage from './pages/BookPage';
import SearchPage from './pages/SearchPage';
import SignUp from './pages/SignUp';

const bookPage = ({ match }) => (
    <div>
        <BookPage id={match.params.id}/>
    </div>
)

class App extends Component {



    render() {
        return (
            <Router>
                <div className="container">
                    <NavBar />
                    <div className="container-fluid">
                        <Route exact path="/" component={ SearchPage } />
                        <Route path="/user" component={ UserPage } />
                        <Route path="/login" component={ LogIn } />
                        <Route path="/book/:id" component={ bookPage } />
                        <Route path="/signup" component={ SignUp } />
                    </div>
                </div>
            </Router>
        );
    }
}
export default App;
