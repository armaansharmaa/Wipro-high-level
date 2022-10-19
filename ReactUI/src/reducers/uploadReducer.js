import {UPLOAD_EXCEL} from "../actions/types";

const initialState = {
    excel: null
};

export default function (state = initialState,action) {
    switch(action.type) {
        case UPLOAD_EXCEL:
            return {
                ...state,
                image: action.payload
            };
        default:
            return state;
    }
}