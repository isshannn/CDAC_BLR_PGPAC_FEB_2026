#!/bin/bash

# 1. Validat that a student name argument was passed to the script
if [ -z "$1" ]; then
    echo "Error: Please provide a student name as a command-line argument."
    echo "Usage: $0 <student_name>"
    exit 1
fi

# Assign the first argument to a clean variable name
student_name="$1"

echo "Creating workspace for student: $student_name..."
echo "------------------------------------------------"

# 2. Create the main student directory and subdirectories
# Using the -p (parents) flag creates nested structures all in one command safely
mkdir -p "$student_name/Assignments"
mkdir -p "$student_name/Notes"
mkdir -p "$student_name/Projects"

# 3. Create an empty file named README.txt inside the student's folder
touch "$student_name/README.txt"

echo "Workspace folders and files successfully created!"
echo ""
echo "------------------------------------------------"
echo "           COMPLETE DIRECTORY STRUCTURE         "
echo "------------------------------------------------"

# 4. Display the complete directory structure
# Attempts to use the professional 'tree' layout command; falls back to 'find' if not installed
if command -v tree &> /dev/null; then
    tree "$student_name"
else
    echo "$student_name/"
    find "$student_name" -print | sed -e 's;[^/]*/;|____;g;s;____|; |;g'
fi
echo "------------------------------------------------"e
