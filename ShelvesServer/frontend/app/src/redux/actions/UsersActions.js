import * as types from '../ActionTypes'
import Request from '../../api/RequesterAPI';

//LOGIN
let startLoggingIn = () => {
    return {
        type: types.LOGIN
    }
}
let onLoggedIn = (user) => {
    return {
        type: types.LOGIN_SUCCESS,
        user: user
    }
}
let onLoginFailed = (error) => {
    return {
        type: types.LOGIN_FAIL,
        error: error
    }
}


//thunk
export function logIn(login, password){
    return (dispatch, getState) => {
        dispatch(startLoggingIn())
        return Request.findUser(login, password).then(
            user => dispatch(onLoggedIn(user)),
            error => dispatch(onLoginFailed(error))
        )
    }
}

//BOOKS LOADING
let startBooksLoading = () => {
    return {
        type: types.LOAD_BOOKS
    }
}
let booksLoadingSuccess = (books) => {
    return {
        type: types.BOOKS_SUCCESS,
        books: books
    }
}
let booksLoadingFail = (error) => {
    return {
        type: types.BOOKS_FAIL,
        error: error
    }
}
export function loadBooks(userId){
    return (dispatch, getState) => {
        dispatch(startBooksLoading())
        return Request.send("GET", `/webresources/records/findbyuser?id=${userId}`).then(
            books => dispatch(booksLoadingSuccess(books)),
            error => dispatch(booksLoadingFail(error))
        )
    }
}

//SIGNUP
let startSigningUp = () => {
    return {
        type: types.SIGNUP
    }
}
let onSignedUp = (user) => {
    return {
        type: types.SIGNUP_SUCCESS,
        user: user
    }
}
let onSignUpFail = (error) => {
    return {
        type: types.SIGNUP_FAIL,
        error: error
    }
}
//thunk
export function signUp(data){
    return (dispatch, getState) => {
        dispatch(startSigningUp())
        return Request.signUpUser(data).then(
            user => dispatch(onSignedUp(user)),
            error => dispatch(onSignUpFail(error))
        )
    }
}

//LOGOUT
export function logOut(){
    return {
        type: types.LOGOUT
    }
}