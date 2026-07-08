#!/bin/bash

# 1. Read an Integer
echo -n "Enter an integer: "
read num

# Validate that the input is a valid integer (handles negative signs as well)
if ! [[ "$num" =~ ^-?[0-9]+$ ]]; then
    echo "Error: '$num' is not a valid integer."
    exit 1
fi

echo "-----------------------------------"
echo "         RESULTS SUMMARY           "
echo "-----------------------------------"
echo "Input Number : $num"

# 2. Check whether it is Positive, Negative, or Zero
if (( num > 0 )); then
    echo "Sign        : Positive"
elif (( num < 0 )); then
    echo "Sign         : Negative"
else
    echo "Sign         : Zero"
fi

# 3. Check whether it is Even or Odd
# (Modulo math is evaluated inside arithmetic double parentheses)
if (( num % 2 == 0 )); then
    echo "Parity       : Even"
else
    echo "Parity       : Odd"
fi

# 4. Calculate Square and Cube
square=$(( num * num ))
cube=$(( num * num * num ))

# 5. Display Calculations
echo "Square       : $square"
echo "Cube         : $cube"
echo "-----------------------------------" 
