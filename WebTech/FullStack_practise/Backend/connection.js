const mongoose = require('mongoose');

const connectDB = async () => {
    try {
        // Replace with your actual MongoDB connection string in a real app
        // typically stored in a .env file as process.env.MONGO_URI
        await mongoose.connect('mongodb://127.0.0.1:27017/product_manager');
        console.log(`MongoDB Connected`);
    } catch (err) {
        console.error(`Error connecting to MongoDB: ${err.message}`);
        process.exit(1); // Exit process with failure
    }
};

// connectDB();
module.exports = connectDB;