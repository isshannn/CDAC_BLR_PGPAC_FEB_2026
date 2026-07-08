#!/bin/bash
echo "Enter Employee ID :"
read emp_id
echo "Enter Employee Name :"
read emp_name
echo "Enter Basic Salary :"
read ba
hra=$((ba/5))
da=$((ba/10))
echo "HRA : $hra"
echo "DA : $da"
