import * as types from '../ActionTypes.js'
import { Map } from 'immutable';

const initialState = {
    loading: false,
    user: undefined,
    linksMap: Map(),
    error: undefined
}

const startLoading = (state, action) => {
    return { ...state, loading: true, error: undefined}
}

const stopLoading = (state, action) => {
    return { ...state, loading: false, error: action.error}
}


const usersReducer =  (state = initialState, action = {}) => {

    switch (action.type) {

        case types.LOGIN:
            return startLoading(state, action);

        case types.LOGIN_SUCCESS:
            return {
                ...state,
                user: action.user,
                loading: false
            };

        case types.LOGIN_FAIL:
            return stopLoading(state, action);


        case types.SIGNUP:
            return startLoading(state, action)

        case types.SIGNUP_FAIL:
            return stopLoading(state, action)

        case types.SIGNUP_SUCCESS:
            return {
                ...state,
                user: action.user,
                loading: false
            }

        case  types.LOGOUT:
            return {...state,
                user: undefined}

        default:
            return state;

    }

}

export default usersReducer;