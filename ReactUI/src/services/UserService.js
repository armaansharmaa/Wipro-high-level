import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8080/api/person';
const UPLOAD_HEADER= {
    headers: {'Access-Control-Allow-Origin': '*',
    'Content-Type': 'multipart/form-data'
    }
};
const HEADER= {
    headers: {'Access-Control-Allow-Origin': '*'
    }
};
//axios.get('https://a.4cdn.org/' + board + '/threads.json', config)
//    .then(function (response) {
//        console.log(response.data);
//});
class UserService {

    getUsers() {
        return axios.get(USERS_REST_API_URL,HEADER);
    }
    getUserById(employeeId){
        return axios.get(USERS_REST_API_URL + '/' + employeeId, HEADER);
    }
    getFiles(){
        return axios.get(USERS_REST_API_URL + '/uploadedFiles'  , HEADER);
    }
     upload(file){
     console.log(file);
     console.log(UPLOAD_HEADER)
     var formData = new FormData();
     formData.append("file", file);
     console.log(formData);
         return axios.post(USERS_REST_API_URL + '/upload', formData,UPLOAD_HEADER);
//         .then(function () {
//                                                                                        console.log('SUCCESS!!');
//                                                                                      })
//                                                                                      .catch(function () {
//                                                                                        console.log('FAILURE!!');
//                                                                                      });
     }
}

export const uploadExcel = (file) => async dispatch => {
    if (file.entries().next().value[1] !== null) {
        const response = await axios.post(USERS_REST_API_URL + `/api/person/upload`, file, {
            onUploadProgress:progressEvent => {
                console.log("Uploading : " + ((progressEvent.loaded / progressEvent.total) * 100).toString() + "%")
            }
        });
        dispatch({
            type: "UPLOAD_EXCEL",
            payload: response.data
        });
    }
};

export default new UserService();