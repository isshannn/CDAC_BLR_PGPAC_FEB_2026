#!/bin/bash

# 1. Validate that a project name argument ws provided
if [ -z "$1" ]; then
    echo "Error: Please provide a project name as a command-line argument."
    echo "Usage: $0 <project_name>"
    exit 1
fi

project_name="$1"

echo "Generating project directory workspace for: $project_name..."
echo "--------------------------------------------------------"

# 2. Create the parent project directory and its subdirectories
# Using the -p flag ensures nested structures are safely created in one line
mkdir -p "$project_name/Source"
mkdir -p "$project_name/Header"
mkdir -p "$project_name/Input"
mkdir -p "$project_name/Output"
mkdir -p "$project_name/Documentation"

# 3. Create an empty file named README.txt inside the main project directory
touch "$project_name/README.txt"

echo "Project environment successfully built!"
echo ""
echo "--------------------------------------------------------"
echo "               COMPLETE DIRECTORY STRUCTURE             "
echo "--------------------------------------------------------"

# 4. Display the complete directory structure layout
# Attempts to use the native 'tree' utility; loops over a text alternative if tree isn't installed
if command -v tree &> /dev/null; then
    tree "$project_name"
else
    echo "$project_name/"
    find "$project_name" -print | sed -e 's;[^/]*/;|____;g;s;____|; |;g'
fi
echo "--------------------------------------------------------"
