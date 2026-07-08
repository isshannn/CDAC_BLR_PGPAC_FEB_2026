#!/bin/bash

#echo "Enter Employee name"
#read emp_name
#echo "Enter Employee ID"
#read emp_id
echo "Enter Performance Score (Out of 100) :"
read score

if [ $score -ge 100 ]
then
	echo "invalid score"
fi
