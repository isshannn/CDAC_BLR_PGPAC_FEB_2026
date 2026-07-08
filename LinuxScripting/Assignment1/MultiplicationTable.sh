#!/bin/bash
echo "Enter Number"
read num
echo "Multiplication Table"
for i in {1..10}
do
	echo " $num * $i = $((num * i))"
done
