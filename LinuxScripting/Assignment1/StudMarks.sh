#!/bin/bash
echo "Enter Student Name"
read s_name
declare -a sub_marks
for i in {1..5}
do
	echo "Enter Marks in subject $i = "
	read sub_marks[$i]
done
total=0
for i in ${sub_marks[@]}
do
	total=$((total+i)) 
done
echo "Total Marks : $total/500"
avg=$((total/5))
echo "Average Marks : $avg"
if ((avg>=90))
then 
	echo "Grade A"
elif ((avg>=70))
then
	echo "Grade B"
elif ((avg>=60))
then	
	echo "Grade C"
else
	echo "Fail"
fi
