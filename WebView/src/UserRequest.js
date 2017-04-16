//export default class User{
//  data() {
//    let result = new Promise(function(resolve, reject) {
//      let xhr = new HMLHttpRequest();
//      xhr.open('GET', 'http://localhost');
//      xhr.onreadystatechange = function() {
//        if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
//          let raw = xhr.responseText;
//          let objectified = JSON.parse(raw);
//          resolve(objectified);
//        };
//      };
//      xhr.send();
//    });
//    return result;
//  }
//}
