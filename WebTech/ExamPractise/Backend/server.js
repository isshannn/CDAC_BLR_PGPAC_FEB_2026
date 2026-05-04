const express = require('express');
const cors = require('cors');

const connectDB = require('./connection');
const apiRoutes = require('./apiRoutes');

const app = express();
const PORT = 5000;

// MiddleWare
app.use(cors());            // Allows React frontend to communicate with the backend 
app.use(express.json());    // Allows Parsing of JSON data in the request body

// Connect to Database
connectDB();

// Mount the api routes
app.use('/api',apiRoutes);

// Start the backend Server
try{
    app.listen(PORT, ()=>{
        console.log(`Backend Server running on port ${PORT}`);
    });
}
catch(err){
    console.log(`Backend Server Mount Error :: ${err}`);
}