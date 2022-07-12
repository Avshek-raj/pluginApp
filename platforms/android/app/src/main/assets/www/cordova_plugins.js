cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "avshek.sqlite.sqlite",
      "file": "plugins/avshek.sqlite/www/sqlite.js",
      "pluginId": "avshek.sqlite",
      "clobbers": [
        "cordova.plugins.sqlite"
      ]
    }
  ];
  module.exports.metadata = {
    "avshek.sqlite": "1.0.0"
  };
});