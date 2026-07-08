#!/bin/bash

echo "Enter Directory Name"
read dir

if [ -d $dir ]
then 
	(
	echo "Directory Report generated on $(date)"
	echo "Number of files in the directory $(ls $dir | wc -w)"
	echo "Files inside the directory"
	ls $dir
	) > DirectoryReport.txt
	echo "Report Created Sucessfully"
	cat DirectoryReport.txt
else
	echo "Directory doesnt exist"
fi

