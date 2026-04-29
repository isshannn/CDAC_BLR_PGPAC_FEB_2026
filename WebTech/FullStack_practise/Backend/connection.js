const mongoose = require('mongoose');

const connectDB = async () => {
    try {
        // Replace with your actual MongoDB connection string in a real app
        // typically stored in a .env file as process.env.MONGO_URI
        const conn = await mongoose.connect('mongodb://127.0.0.1:27017/product_manager');
        console.log(`MongoDB Connected: ${conn.connection.host}`);
    } catch (error) {
        console.error(`Error connecting to MongoDB: ${error.message}`);
        process.exit(1); // Exit process with failure
    }
};

// connectDB();
module.exports = connectDB;