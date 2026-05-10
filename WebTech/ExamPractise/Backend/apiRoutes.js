const express = require('express');
const cors = require('cors');
const Device = require('./DeviceSchema');
const { default: mongoose } = require('mongoose');

const Router = express.Router();

// Create the schema
Router.post('/Devices',async(req,res)=>{
    try{
        const DeviceSchema = await Device.create(req.body);
        res.json(DeviceSchema);
    }
    catch(err){
        console.log(`API ERROR (POST) :: ${err}`)
    }
});

// Read Table data in the database
Router.get('/Devices',async(req,res)=>{
    try{
        const SchemaData = await Device.find();
        res.json(SchemaData);
    }
    catch(err){
        console.log(`API ERROR (GET) :: ${err}`)
    }
});

// Update data by param on the existing table data
Router.put('/Devices/:id',async(req,res)=>{
    try{
        const UpdateData = await Device.findByIdAndUpdate(req.params.id,req.body);
        res.json(UpdateData);
    }
    catch(err){
        console.log(`API ERROR (PUT) :: ${err}`)
    }
});

// Delete data by param on the existing table data
Router.delete('/Devices/:id',async(req,res)=>{
    try{
        const DeleteData = await Device.findByIdAndDelete(req.params.id,req.body);
        res.json(DeleteData);
    }
    catch(err){
        console.log(`API ERROR (delete) :: ${err}`)
    }
}) 

module.exports = Router;