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


        // case types.INITIALIZE_AUTH:
        //     return {...state, loading: true, initialized: false}
        //
        // case types.INITIALIZE_AUTH_FAIL:
        //     return {...state, loading: false, initialized: false}
        //
        // case types.INITIALIZE_AUTH_SUCCESS:
        //     return {...state,
        //         loading: false,
        //         initialized: true,
        //         currentUserId: (action.user == undefined) ? undefined : action.user.id,
        //         usersMap: (action.user == undefined) ? state.usersMap : state.usersMap.set(action.user.id, action.user)
        //     }
        //
        //
        // case types.UPDATE_USER:
        //     return startLoading(state, action);
        // case types.UPDATE_USER_FAIL:
        //     return stopLoading(state, action);
        // case types.UPDATE_USER_SUCCESS:
        //     return {
        //         ...state,
        //         loading: false,
        //         usersMap: state.usersMap.set(action.user.id, action.user)
        //     }
        //
        //
        // case types.LOAD_USERS:
        //     return startLoading(state, action)
        //
        // case types.LOAD_USERS_FAIL:
        //     return stopLoading(state, action)
        //
        // case types.LOAD_USERS_SUCCESS:
        //     return {
        //         ...state,
        //         usersMap: state.usersMap.merge(action.users.reduce((res, u) => {return res.set(u.id, u)}, Map())),
        //         linksMap: state.linksMap.merge(action.links.reduce((res, u) => {return res.set(u.id, u)}, Map())),
        //         loading: false
        //     }
        //
        //
        //
        // case types.LOAD_USER_LINKS:
        //     return startLoading(state, action);
        //
        // case types.LOAD_USER_LINKS_FAIL:
        //     return stopLoading(state, action);
        //
        // case types.LOAD_USER_LINKS_SUCCESS:
        //     return {
        //         ...state,
        //         loading: false,
        //         error: undefined,
        //         usersMap: state.usersMap.merge(action.users.reduce((res, u) => {return res.set(u.id, u)}, Map())),
        //         linksMap: state.linksMap.merge(action.links.reduce((res, u) => {return res.set(u.id, u)}, Map())),
        //     }
        //
        // case types.CREATE_USER_LINK:
        //     return startLoading(state, action);
        // case types.CREATE_USER_LINK_FAIL:
        //     return stopLoading(state, action);
        // case types.CREATE_USER_LINK_SUCCESS:
        //     return {
        //         ...state,
        //         loading: false,
        //         linksMap: state.linksMap.set(action.link.id, action.link)
        //     }
        //
        // case types.UPDATE_USER_LINK:
        //     return startLoading(state, action);
        // case types.UPDATE_USER_LINK_FAIL:
        //     return stopLoading(state, action);
        // case types.UPDATE_USER_LINK_SUCCESS:
        //     return {
        //         ...state,
        //         loading: false,
        //         linksMap: state.linksMap.set(action.link.id, action.link)
        //     }
        //
        // case types.DELETE_USER_LINK:
        //     return startLoading(state, action);
        // case types.DELETE_USER_LINK_FAIL:
        //     return stopLoading(state, action);
        // case types.DELETE_USER_LINK_SUCCESS:
        //     return {
        //         ...state,
        //         loading: false,
        //         linksMap: state.linksMap.delete(action.id)
        //     }


        default:
            return state;

    }

}

export default usersReducer;