// server.js
const express = require('express');
const cors = require('cors');
const connectDB = require('./connection');
const apiRoutes = require('./apiRoutes');

const app = express();
const PORT = 5000;

// Middleware
app.use(cors()); // Allows your React frontend to communicate with this backend
app.use(express.json()); // Allows parsing of JSON data in the request body

// Connect to Database
connectDB();

// Mount Routes
app.use('/api', apiRoutes);

// Start Server
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});