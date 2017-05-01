import React, { Component } from 'react';

import NavBar from './components/NavBar'


class App extends Component {

    render() {
        return (
            <div className="container">
                <NavBar />
                <div className="container-fluid">
                    {this.props.children}
                </div>
            </div>
        );
    }
}
export default App;
