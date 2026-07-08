#!/bin/bash

# 1. Validate that a file name argument was provided
if [ -z"$1" ]; then
    echo "Error: Please provide a file name as a command-line argument."
    echo "Usage: $0 <filename>"
    exit 1
fi

target_file="$1"

# 2. Check whether the file exists
if [ ! -f "$target_file" ]; then
    echo "Error: File '$target_file' does not exist."
    exit 2
fi

echo "========================================================"
echo "               FILE PERMISSIONS MODIFIER                "
echo "========================================================"
echo "Target File      : $target_file"

# 3. Display current file permissions
# 'stat' or 'ls -l' can be used. 'ls -l' provides a clean standard string view.
current_perms=$(ls -l "$target_file" | awk '{print $1}')
echo "Current Permissions: $current_perms"
echo "--------------------------------------------------------"

# 4. Display options menu
echo "Choose an action to perform:"
echo "1. Add Execute Permission (+x)"
echo "2. Remove Write Permission (-w)"
echo "3. Make File Read-Only (chmod 400)"
echo "--------------------------------------------------------"
echo -n "Enter Choice (1-3): "
read choice

case $choice in
    1)
        # Add execute permission
        chmod +x "$target_file"
        echo "Updating permissions..."
        ;;
    2)
        # Remove write permission
        chmod -w "$target_file"
        echo "Updating permissions..."
        ;;
    3)
        # Make file read-only for owner, remove all other permissions
        chmod 400 "$target_file"
        echo "Updating permissions..."
        ;;
    *)
        echo "Invalid Choice! No permissions modified."
        exit 3
        ;;
esac

# 5. Display confirmation and updated permissions
if [ $? -eq 0 ]; then
    echo "Success: File permissions updated successfully!"
    updated_perms=$(ls -l "$target_file" | awk '{print $1}')
    echo "New Permissions    : $updated_perms"
else
    echo "Error: Failed to modify file permissions."
fi
echo "========================================================" 
