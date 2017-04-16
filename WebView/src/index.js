import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import List from './List';
import Book from './Book';
import User from './User';
import Author from './Author';
import './index.css';
global.jQuery = require('jquery');
require('bootstrap');
import 'bootstrap/dist/css/bootstrap.css';
import { Router, Route, IndexRoute, hashHistory } from 'react-router';

ReactDOM.render(
  <Router history={hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={App} />
    </Route>
    <Route path="/user/(:userId)/list" component={List} />
    <Route path="/book/(:bookId)" component={Book} />
    <Route path="/user/(:userId)" component={User} />
    <Route path="/author/(:authorId)" component={Author} />
  </Router>,
  document.getElementById('root')
);
