import React,{useState,useEffect} from "react"
import axios from 'axios';
// import e from "cors"; (Unknown addition)

const API_URL = 'http://localhost:5000/api/Devices'
function App() {
  
  /*
    Hooks like useState and useEffect are the engine that makes your application interactive and data-driven. 
    While useState handles the memory of your app (what data is currently there), useEffect handles the actions that happen outside the normal rendering flow 
    (like talking to your database).

    In your code, you use useState to track three distinct types of information. Every time a state-setter function (like setProducts) is called,
     React "remembers" the new value and re-renders the UI to reflect the change.
  */

  // Initialize UseStates
  const [Devices,setDevices] = useState([]); // Devices: Stores the array of product documents fetched from MongoDB.
  const [formData,setformData] = useState({    // formData: Stores the text/numbers currently typed into your input fields.
    DeviceName : '', 
    DateOfPurchase : '',
    DeviceSlNo : '',
    StockCount : ''
  });

  const [EditInfo,setEditInfo] = useState(null); //EditInfo : Tracks if you are in "Edit Mode" by storing the _id of the product being modified.
  
  /* 
      The useEffect hook is used for side effects—actions that interact with things outside of React, such as your Express API
      The Action: The code inside the hook calls fetchProducts(), which uses axios to get data from your backend on port 5000.

      The "Initial Mount":  Because this is placed inside useEffect, the fetch call happens automatically as soon as the component is "mounted" 
                            (added to the screen). Without this, the table would stay empty until a user manually did something.

      The Dependency Array ([]): The empty brackets are critical.
                                  Running Once: They tell React to run this effect exactly once after the initial render.
                                  Preventing Loops: If you omitted the [], fetchProducts would update the state, which triggers a re-render, 
                                                    which triggers useEffect again, creating an infinite loop that could overwhelm your server or crash your browser.
  */

  // Initialise useEffects
  useEffect(()=>{
    fetchDevices();
  },[])

  const fetchDevices = async() => {
    try{
      const response = await axios.get(API_URL); // READ
      setDevices(response.data); 
    }
    catch(err){
      console.log(`Error fetching from database :: ${err}`);
    }
  };

  /* 
      Instead of writing a separate function for each input (one for ProductName, one for Cost, etc.), this single function handles all of them 
      using computed property names.
  */
  
  // Handler for edit hook
   const HandleInputChange = (e) => {  // handle state updates for every field in Device form
      setformData({
        ...formData, // Spread Operator : This creates a shallow copy of the existing state. 
                     // In React, you should never modify state directly. By spreading the current formData, 
                     // You ensure that when you update the Cost field, you don't accidentally erase other schema attribute values
        [e.target.name] : e.target.value
      });
   }
   
   const handleEdit = (Devices) => {
     setEditInfo(Devices._id);
     setformData({
       DeviceName : Devices.DeviceName,
       DateOfPurchase : Devices.DateOfPurchase ? Devices.DateOfPurchase.split('T')[0] : 'HandleEditNULL',
       DeviceSlNo : Devices.DeviceSlNo,
       StockCount : Devices.StockCount
     })  
   }
   
  // Handler for submit
  const HandleSubmit = async(e) =>{
    e.preventDefault(); 
    /* The preventDefault() method of the Event interface tells the user agent that the 
    event is being explicitly handled, so its default action, such as page scrolling, link navigation, 
    or pasting text, should not be taken */
    try{
      if(EditInfo){
        // Send a PUT request to API if we are editing an item
        await axios.put(`${API_URL}/:${EditInfo}`,formData);
        setEditInfo(null)  // Refreshes the editinfo to be passed for processing
      }
      else
        await axios.post(`${API_URL}`, formData)
      // Reset form and reset the device input fields 
      setformData({
        DeviceName : '',
        DateOfPurchase : '',
        DeviceSlNo : '',
        StockCount : ''
      });
      fetchDevices();
    }
    catch(err){
      console.log(`Error in frontend connectivity to backend :: ${err}`);
    }
  };

  // Handler for deletion request
  const handleDelete = async(id) => {
    try{
      await axios.delete(`${API_URL}/${id}`);
      fetchDevices(); // Because how else do you think you will refresh the db and heance the table
    }
    catch(err){
      console.log(`Error in deleteing (frontend) :: ${err}`);
    }
  }


  return  (
    <>
      <h1>CDAC Device Managment System</h1>
      <form onSubmit={HandleSubmit}>
        <input
          type="text"
          name="DeviceName"
          placeholder="Device Name"
          value={formData.DeviceName}
          onChange={HandleInputChange}
          />
        <input
          type="date"
          name="DateOfPurchase"
          value={formData.DateOfPurchase}
          onChange={HandleInputChange}
        />
        <input
          type="number"
          name="DeviceSlNo"
          placeholder="Serial Number"
          value={formData.DeviceSlNo}
          onChange={HandleInputChange}
        />
        <input
          type="number"
          name="StockCount"
          placeholder="StockCount"
          value={formData.StockCount}
          onChange={HandleInputChange}
        />
        <button type="submit">
          {EditInfo ? 'Update Product' : 'Add Product'}
        </button>
         { EditInfo && 
          <button 
            type="button"
            onClick={
              () => {
                setEditInfo(null);
                setformData({ 
                  DeviceName : '',
                  DateOfPurchase : '',
                  DeviceSlNo : '',
                  StockCount : ''
                })
              }
              }
          >Cancel
        </button>}
      </form>
      <table>
          <thead>
            <tr>
              <th>Device Name</th>
              <th>Date of Purchase</th>
              <th>Serial Number</th>
              <th>StockCount</th>
            </tr>
          </thead>
        <tbody>
          {Devices.map((Devices) => (
            <tr key={Devices._id}>
              <td>{Devices.DeviceName}</td>
              <td>{Devices.DateOfPurchase ? new Date(Devices.DateOfPurchase).toLocaleDateString() : 'N/A'}</td>
              <td>{Devices.DeviceSlNo}</td>
              <td>{Devices.StockCount}</td>
              <td>
                <button onClick={() => handleEdit(Devices)}>
                  Edit
                </button>
                <button onClick={() => handleDelete(Devices._id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  )
}

export default App
