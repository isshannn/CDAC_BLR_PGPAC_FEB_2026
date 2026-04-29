// productTable.js
const mongoose = require('mongoose');

// Define the schema (the structure of your "table")
const productSchema = new mongoose.Schema({
    ProductName: {
        type: String,
        required: [true, 'Product name is required'],
        trim: true
    },
    Cost: {
        type: Number,
        required: [true, 'Cost is required'],
        min: 0
    },
    ExpiryDate: {
        type: Date,
        required: false // Optional, as not all products expire
    },
    StockCount: {
        type: Number,
        required: [true, 'Stock count is required'],
        min: 0,
        default: 0
    }
}, {
    timestamps: true // Automatically adds createdAt and updatedAt fields
});

// Export the model
const Product = mongoose.model('Product', productSchema);
module.exports = Product;