import { combineReducers } from 'redux';

import UsersReducer from './UsersReducer.js';
import FileUploadReducer from './FileUploadReducer.js';

export const reducer = combineReducers({
    userState: UsersReducer,
    upload: FileUploadReducer
});