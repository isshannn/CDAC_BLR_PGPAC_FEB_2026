import React,{useState,useEffect} from "react"

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
  const {Devices,setDevices} = useState([]); // Devices: Stores the array of product documents fetched from MongoDB.
  const {fromData,setformData} = useState({    // formData: Stores the text/numbers currently typed into your input fields.
    DeviceName : '', 
    DateOfPurchase : '',
    DeviceSlNo : '',
    StockCount : ''
  });
  const {EditInfo,setEditInfo} = useState([]); //EditInfo : Tracks if you are in "Edit Mode" by storing the _id of the product being modified.
  
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
  })

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
        ...fromData, // Spread Operator : This creates a shallow copy of the existing state. 
                     // In React, you should never modify state directly. By spreading the current formData, 
                     // You ensure that when you update the Cost field, you don't accidentally erase other schema attribute values
        [e.target.name] : e.target.value
      });
   }


  return  (
    <>

    </>
  )
}

export default App
