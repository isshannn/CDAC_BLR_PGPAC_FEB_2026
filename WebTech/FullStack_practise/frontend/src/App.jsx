// App.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const API_URL = 'http://localhost:5000/api/products';

function App() {
  const [products, setProducts] = useState([]);
  const [formData, setFormData] = useState({
    ProductName: '',
    Cost: '',
    ExpiryDate: '',
    StockCount: ''
  });

  // Fetch products when the component loads
  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(API_URL);
      setProducts(response.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  // Handle input changes in the form
  const handleInputChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  // CREATE: Add a new product
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post(API_URL, formData);
      setFormData({ ProductName: '', Cost: '', ExpiryDate: '', StockCount: '' }); // Reset form
      fetchProducts(); // Refresh the list
    } catch (error) {
      console.error('Error adding product:', error);
    }
  };

  // DELETE: Remove a product
  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      fetchProducts(); // Refresh the list
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Product Management System</h1>

      {/* CREATE FORM */}
      <form onSubmit={handleSubmit} style={{ marginBottom: '30px', display: 'flex', gap: '10px' }}>
        <input 
          type="text" name="ProductName" placeholder="Product Name" 
          value={formData.ProductName} onChange={handleInputChange} required 
        />
        <input 
          type="number" name="Cost" placeholder="Cost" 
          value={formData.Cost} onChange={handleInputChange} required 
        />
        <input 
          type="date" name="ExpiryDate" 
          value={formData.ExpiryDate} onChange={handleInputChange} 
        />
        <input 
          type="number" name="StockCount" placeholder="Stock Count" 
          value={formData.StockCount} onChange={handleInputChange} required 
        />
        <button type="submit">Add Product</button>
      </form>

      {/* READ: DISPLAY PRODUCTS */}
      <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr style={{ backgroundColor: '#f2f2f2' }}>
            <th>Product Name</th>
            <th>Cost</th>
            <th>Expiry Date</th>
            <th>Stock Count</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product._id}>
              <td>{product.ProductName}</td>
              <td>${product.Cost}</td>
              <td>{product.ExpiryDate ? new Date(product.ExpiryDate).toLocaleDateString() : 'N/A'}</td>
              <td>{product.StockCount}</td>
              <td>
                <button onClick={() => handleDelete(product._id)} style={{ color: 'red' }}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;