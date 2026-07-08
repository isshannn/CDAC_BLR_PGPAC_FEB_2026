#!/bin/bash

# 1. Read Product Details from User
echo "Enter Product Name:"
read prod_nam

echo "Enter Quantity:"
read quantity

echo "Enter Price per Item:"
read price

# 2. Calculate Total Amount
total_amount=$(( quantity * price ))

# 3. Calculate GST (18%) using integer optimization
# (Multiplying by 18 then dividing by 100 bypasses the floating-point limitation)
gst=$(( (total_amount * 18) / 100 ))

# 4. Calculate Final Amount
final_amount=$(( total_amount + gst ))

# 5. Display the Generated Bill
echo "-----------------------------------"
echo "          SHOPPING BILL            "
echo "-----------------------------------"
echo "Product Name   : $prod_name"
echo "Quantity       : $quantity"
echo "Price per Item : ₹$price"
echo "-----------------------------------"
echo "Total Amount   : ₹$total_amount"
echo "GST (18%)      : ₹$gst"
echo "-----------------------------------"
echo "Final Amount   : ₹$final_amount"
echo "-----------------------------------"e
