#!/bin/bash

# 1. Validate that a directory argument was provided
if [ -z"$1" ]; then
    echo "Error: Please provide a directory name as a command-line argument."
    echo "Usage: $0 <directory_name>"
    exit 1
fi

target_dir="$1"

# 2. Check if the directory does not exist or is not a directory
if [ ! -d "$target_dir" ]; then
    echo "Error: Directory '$target_dir' does not exist."
    exit 2
fi

echo "========================================================"
echo "               DIRECTORY ANALYZER REPORT                "
echo "========================================================"
echo "Target Directory      : $target_dir"

# 3. Calculate total number of files
# -type f finds files only, wc -l counts the total lines/items
file_count=$(find "$target_dir" -type f | wc -l)
echo "Total Number of Files : $file_count"

# 4. Calculate total number of subdirectories
# -type d finds directories, minus 1 to exclude the parent directory itself
dir_count=$(find "$target_dir" -type d | wc -l)
subdir_count=$(( dir_count - 1 ))
echo "Total Subdirectories  : $subdir_count"

# 5. Calculate total size of the directory
# du -sh provides a clean summary in a human-readable format (e.g., 4.0K, 12M, 2G)
dir_size=$(du -sh "$target_dir" | awk '{print $1}')
echo "Total Size            : $dir_size"

echo "--------------------------------------------------------"
echo "               FILES PRESENT IN DIRECTORY               "
echo "--------------------------------------------------------"

# 6. Display names of all files present in the directory
# -maxdepth 1 can be added if you only want top-level files; omitting it lists all files recursively
if [ "$file_count" -eq 0 ]; then
    echo "(No files found in this directory)"
else
    find "$target_dir" -type f -printf "%P\n" | sort
fi

echo "========================================================" 
