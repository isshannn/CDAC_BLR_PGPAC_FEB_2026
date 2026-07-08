#!/bin/bash
echo "Input a number to be reversed"
read num
num_rev=0;
while ((num > 0)) 
	do
		digit=$(( num % 10 )) 
		num_rev=$(((num_rev * 10)+digit)) 
		num=$((num / 10))
done 
echo "reversed number : $num_rev"

