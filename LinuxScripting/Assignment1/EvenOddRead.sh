#!/bin/bash
echo "Input number"
read num
if (( num % 2 == 0 ))
then
	echo "Even number"
elif [ $num == 0 ]
then
	echo "0 : Neither even nor odd"
else
	echo "Odd number"
fi

