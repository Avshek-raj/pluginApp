var exec = require('cordova/exec');

exports.insert = function (arg0, success, error) {
    exec(success, error, 'sqlite', 'insert', arg0);

};

exports.update = function (arg0, success, error) {
    exec(success, error, 'sqlite', 'update', arg0);
};

exports.delete = function (arg0, success, error) {
    exec(success, error, 'sqlite', 'delete', arg0);
};

exports.getData = function (arg0, success, error) {
    exec(success, error, 'sqlite', 'getData', arg0);
};

exports.getDataCount = function (arg0, success, error) {
    exec(success, error, 'sqlite', 'getDataCount', arg0);
};