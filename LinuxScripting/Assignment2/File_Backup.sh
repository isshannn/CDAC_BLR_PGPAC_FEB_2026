#!/bin/bash

# 1. Check whether both required command-line arguments are provided
if [ -z"$1" ] || [ -z "$2" ]; then
    echo "Error: Missing arguments."
    echo "Usage: $0 <source_filename> <destination_directory>"
    exit 1
fi

# Assign arguments to meaningful variable names
source_file="$1"
destination_dir="$2"

echo "Initiating backup utility..."
echo "------------------------------------------------"

# 2. Check whether the source file exists (-f checks if it exists and is a regular file)
if [ -f "$source_file" ]; then
    
    # Check if the destination directory exists; if not, create it safely
    if [ ! -d "$destination_dir" ]; then
        echo "Destination directory does not exist. Creating it now..."
        mkdir -p "$destination_dir"
    fi

    # 3. If it exists, copy it to the destination directory
    cp "$source_file" "$destination_dir/"
    
    # 4. Display a success message after copying
    if [ $? -eq 0 ]; then
        echo "Success: Backup completed! '$(basename "$source_file")' has been copied to '$destination_dir/'."
    else
        echo "Error: Something went wrong during the copy process."
    fi

else
    # 5. Otherwise, display an appropriate error message
    echo "Error: Source file '$source_file' does not exist. Backup failed."
    exit 2
fi

echo "------------------------------------------------" 
