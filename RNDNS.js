'use strict';

const RNDNS = require('react-native').NativeModules.RNDNS;

module.exports = {
  lookup(hostname, callback) {
    RNDNS.lookup(hostname, callback);
  }
};
