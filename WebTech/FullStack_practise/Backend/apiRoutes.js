const express = require('express');
const cors = require('cors');
const connectDB = require('./connection.js');
const Product = require('./productTable.js');
const app = express();
connectDB();
app.use(cors());
app.use(express.json());

// Create
app.post('api/product',async(req,res) => {
    try{
        const newProduct = new Product(req.body);
        const product = await newProduct.save();
        res.json(product);
    }
    catch(err){ res.status(500).send("Server Error :: " + err); }
});

//READ
app.get('api/product',async(req,res) =>{
    try{
        const product = await Product.find();
        res.json(product)
    }
    catch(err){ res.status(500).send("Server Error :: " + err); }
}); 

// UPDATE
app.put('api/product/:id',async(req,res) => {
    try{
        const product = await Product.findByIdAndUpdate(req.params.id, req.body, res.json);
        res.json(product);
    }
    catch(err){ res.status(500).send("Server Error :: " + err); }
});

// DELETE
app.delete('api/product/:id',async(req,res) => {
    try{
        await(Product.findByIdAndDelete(req.params.id));
        res.json({msg : 'Student Deleted'});
    }
    catch(err){ res.status(500).send("Server Error :: " + err); }
})

app.listen(5000, () => console.log('Server started on port 5000'));