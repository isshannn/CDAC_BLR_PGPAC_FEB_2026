const mongoose = require('mongoose');
const TableSchema = new mongoose.Schema({
    ProductName : {type : String, required : true},
    Cost : {type : Number , required : true},
    ExpiryDate : {type : Date, required : true},
    StockCount : { type : Number, required : true},
    // Image : { type :  Image, required : false}
});

module.exports = mongoose.model('Product',TableSchema);