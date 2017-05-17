import React from 'react';
import { render } from 'react-dom';

import { Router, Route, IndexRoute, hashHistory, Redirect } from 'react-router';

import { createStore, applyMiddleware, compose } from 'redux';
import { reducer } from './redux/reducers'
import { Provider } from 'react-redux';
import thunk from 'redux-thunk';

import App from './App';
import SearchPage from './pages/SearchPage';
import BookPage from './pages/BookPage';
import LogIn from './pages/LogIn'
import SignUp from './pages/SignUp';
import UserPage from './pages/UserPage';
import NotFound from './pages/NotFound';
import AuthorPage from './pages/AuthorPage';


const AppRouter = () => (
	<Router history={hashHistory}>
		<Route path="/" component={ App }>
			<IndexRoute component={ SearchPage } />

			<Route path="/book/:id" component={ BookPage } />
			<Route path="/author/:id" component={ AuthorPage } />

			<Route path="/login" component={ LogIn } />
			<Route path="/signup" component={ SignUp } />

			<Route path="/user" component={ UserPage } />

			<Route path='*' component={NotFound} />
		</Route>
	</Router>
)

const store = createStore(
    reducer,
    compose(applyMiddleware(thunk))
)

render(
	<Provider store={store}>
		<AppRouter/>
	</Provider>,
	document.getElementById('root')
);