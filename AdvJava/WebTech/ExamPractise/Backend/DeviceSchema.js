const mongoose = require('mongoose');
const { timeStamp } = require('node:console');
const { type } = require('node:os');

const DeviceSchema = new mongoose.Schema({
            DeviceName : { type : String},
            DateOfPurchase  : {type : Date},
            DeviceSlNo : {type : String},
            StockCount : {type : Number}
            }, {timeStamp: true}
        );
module.exports = mongoose.model('Device',DeviceSchema)
