#!/bin/bash
echo "Enter Customer Name"
read name
echo "Enter Units consumed"
read units
if (( units <= 100 ))
then
	# Slab 1: First 100 units at ₹2 per unit
	bill=$(( units * 2 ))
else
	# Calculate the cost for the first 100 units (100 * ₹2 = ₹200)
    	bill=$(( 100 * 2 ))
    
    	if (( units <= 200 ))
	then
        	# Slab 2: Next 100 units at ₹3 per unit
        	remaining_units=$(( units - 100 ))
        	bill=$(( bill + (remaining_units * 3) ))
    	else
        	# Calculate the cost for the next 100 units (100 * ₹3 = ₹300)
        	bill=$(( bill + (100 * 3) ))
        
       		# Slab 3: Above 200 units at ₹5 per unit
        	remaining_units=$(( units - 200 ))
        	bill=$(( bill + (remaining_units * 5) ))
    		fi
fi
echo "Total Units Consumed : $units"
echo "Total Electricity Bill: $bill"
