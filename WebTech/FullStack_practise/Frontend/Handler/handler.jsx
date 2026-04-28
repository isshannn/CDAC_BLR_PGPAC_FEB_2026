import React, {useState, useEffect} from "react";
import axios from 'axios';

const ProductManager = () => {
    //  State Definations
    const [product, setProducts] = useState([]);
    const [formData,setFormData] = useState({
        ProductName: '', Cost: '', ExpiryDate: '', StockCount: ''});
    const [errors, setErrors] = useState({});
    const [editId, setEditId] = useState(null);

    // Side Effects
    useEffect(() => { fetchStudents(); }, []);

    // CRUD Functions
    const fetchProducts = async () => {
        const res = await axios.get("http://localhost:5000/api/product");
        setStudents(res.data);
    }

    // Fix this as per Product Table
    const validate = () => {
        let tempErrors = {};
        const nameRegex = /^[A-Za-z\s]+$/;
        // Apply RegEx for Address as required [cite: 17]
        const addressRegex = /^[a-zA-Z0-9\s,.'-]{3,}$/; 

        if (!formData.name || formData.name.length < 3 || !nameRegex.test(formData.name)) 
            tempErrors.name = "Name must be 3+ chars and alphabets only.";
        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) 
            tempErrors.email = "Invalid email format.";
        if (!formData.course) tempErrors.course = "Course is required.";
        if (!addressRegex.test(formData.address)) tempErrors.address = "Invalid address format.";
        if (!formData.mobile) tempErrors.mobile = "Mobile is required.";
        if (!formData.dob) tempErrors.dob = "DOB is required.";

        setErrors(tempErrors);
        return Object.keys(tempErrors).length === 0;
    };

    const handleSave = async () => {
        if (!validate()) return;
        if (editId) {
            await axios.put(`http://localhost:5000/api/product/${editId}`, formData);
        } else {
            await axios.post('http://localhost:5000/api/product', formData);
        }
        
        // Reset state 
        setFormData({ name: '', email: '', course: '', address: '', mobile: '', dob: '' });
        setEditId(null);
        fetchStudents();
    };

    const handleDelete = async (id) => {
        await axios.delete(`http://localhost:5000/api/product/${id}`);
        fetchStudents();
    };

    // Render Webpage
    return 
}