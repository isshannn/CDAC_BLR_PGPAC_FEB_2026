// On WSL install mongoDB and start the service with the command
//      sudo systemctl start mongod
// WITHOUT RUNNING THE ABOVE COMMAND MONGODB WONT CONNECT ON WSL
// Check the service 
//      sudo systemctl status mongod

const mongoose = require('mongoose');

const connectDB = async () => {
    try {
        // Replace with your actual MongoDB connection string in a real app
        // typically stored in a .env file as process.env.MONGO_URI
        await mongoose.connect('mongodb://127.0.0.1:27017/product_manager');
        console.log(`MongoDB Connected`);
    } catch (err) {
        console.error(`Error connecting to MongoDB: ${err.message}` + "\n IMPORTANT if you are running on wsl refer to comment on connection.js");
        process.exit(1); // Exit process with failure
    }
};

// connectDB();
module.exports = connectDB;