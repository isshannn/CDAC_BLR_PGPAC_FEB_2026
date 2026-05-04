const mongoose = require('mongoose');

const connectDB = async()=> {
    try{
        const connectDetails = await mongoose.connect("mongodb://localhost:27017/")
        console.log(`MongoDB connected on PORT ${connectDetails.connection.port} on ${connectDetails.connection.host}`);
    }
    catch(err){
        console.log("Error in connecting MongoDB :: " + err);
    }
}

// connectDB();
module.exports = connectDB;