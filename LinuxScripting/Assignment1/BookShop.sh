#!/bin/bash
echo "Enter Book Name"
read name
echo "Enter Book Price"
read price
if ((price >= 1000))
then	
	dis=$((price / 5))
elif ((price >= 500))
then 
	dis=$((price / 10))
else
	dis=$((price / 20))
fi
echo "Discount amt : $dis"
echo "Price after Discount : $((price - dis))"
