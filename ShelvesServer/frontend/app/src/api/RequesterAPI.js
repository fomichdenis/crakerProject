const Request = {

    send(requestType, request, data=null) {
        return new Promise(function(resolve, reject) {
            let xhr = new XMLHttpRequest();
            xhr.open(requestType, request);
            xhr.onload = function () {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    let raw = xhr.responseText;
                    let objectified = JSON.parse(raw);
                    resolve(objectified);
                } else {
                    let error = new Arror(this.statusText);
                    error.code = this.status;
                    reject(error);
                }
            };
            xhr.onerror = function() {
                reject(new Error("Network Error"))
            };
            xhr.send(JSON.stringify(data));
        });
    },



    findUser(login, password) {
        return new Promise(function (resolve, reject) {
            if (login === undefined || login.trim() === ''){
                reject(new Error("login is not defined"));
            }
            if (password === undefined || password.trim() === ''){
                reject(new Error("password is not defined"));
            }
            let xhr = new XMLHttpRequest();
            xhr.open("POST", "/webresources/users/finduser");
            xhr.onload = function() {
                if (xhr.status === 200) {
                    let raw = xhr.responseText;
                    let user = JSON.parse(raw);
                    if (user === null) {
                        reject(new Error("No such user"));
                    } else {
                    resolve(user);
                    }
                } else {
                    let error = new Arror(this.statusText);
                    error.code = this.status;
                    reject(error);
                }
            };
            xhr.onerror = function() {
                reject(new Error("Network Error"))
            };
            xhr.send(JSON.stringify([login, password]));
        });
    },

    signUpUser(data) {
        return new Promise(function (resolve, reject) {
            if (data.login === undefined || data.login.trim() === ''){
                reject(new Error("login is not defined"));
            }
            if (data.password === undefined || data.password.trim() === ''){
                reject(new Error("password is not defined"));
            }
            let xhr = new XMLHttpRequest();
            xhr.open("POST", "/webresources/users/create");
            xhr.onload = function() {
                if (xhr.status === 200) {
                    let raw = xhr.responseText;
                    let user = JSON.parse(raw);
                    resolve(user);
                } else {
                    let error = new Arror(this.statusText);
                    error.code = this.status;
                    reject(error);
                }
            };
            xhr.onerror = function() {
                reject(new Error("Network Error"))
            };
            xhr.send(JSON.stringify(data));
        });
    }
}

export default Request