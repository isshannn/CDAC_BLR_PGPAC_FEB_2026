// App.jsx
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
  // New state to track if we are editing an existing product
  const [editingId, setEditingId] = useState(null); 

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

  const handleInputChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  // Populate form with existing product data when Edit is clicked
  const handleEdit = (product) => {
    setEditingId(product._id);
    setFormData({
      ProductName: product.ProductName,
      Cost: product.Cost,
      // Format date correctly for the HTML date input field 
      ExpiryDate: product.ExpiryDate ? product.ExpiryDate.split('T')[0] : '',
      StockCount: product.StockCount
    });
  };

  // Handle both CREATE and UPDATE operations
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingId) {
        // UPDATE: Send a PUT request if we are editing an existing item
        await axios.put(`${API_URL}/${editingId}`, formData);
        setEditingId(null); // Reset the editing state
      } else {
        // CREATE: Send a POST request if it's a completely new product
        await axios.post(API_URL, formData);
      }
      
      // Reset form and refresh the product list
      setFormData({ ProductName: '', Cost: '', ExpiryDate: '', StockCount: '' });
      fetchProducts(); 
    } catch (error) {
      console.error('Error saving product:', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      fetchProducts();
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Product Management System</h1>

      {/* CREATE / UPDATE FORM */}
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
        {/* Dynamically change button text based on state */}
        <button type="submit">{editingId ? 'Update Product' : 'Add Product'}</button>
        
        {/* Cancel button to exit edit mode easily */}
        {editingId && (
          <button 
            type="button" 
            onClick={() => {
              setEditingId(null);
              setFormData({ ProductName: '', Cost: '', ExpiryDate: '', StockCount: '' });
            }}
          >
            Cancel
          </button>
        )}
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
                {/* NEW: Edit Button */}
                <button 
                  onClick={() => handleEdit(product)} 
                  style={{ color: 'blue', marginRight: '10px' }}
                >
                  Edit
                </button>
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