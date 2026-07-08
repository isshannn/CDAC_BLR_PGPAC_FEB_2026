#!/bin/bash

# 1. Validat that a file name argument was passed to the script
if [ -z "$1" ]; then
    echo "Error: Please provide a text file name as a command-line argument."
    echo "Usage: $0 <filename>"
    exit 1
fi

target_file="$1"

# 2. Check whether the file exists and is a regular file
if [ ! -f "$target_file" ]; then
    echo "Error: File '$target_file' does not exist or is not a valid file."
    exit 2
fi

echo "========================================================"
echo "                 TEXT FILE ANALYSIS REPORT              "
echo "========================================================"
echo "Target File: $target_file"
echo "--------------------------------------------------------"

# 3. Calculate metrics using standard 'wc' (word count) options
# awk is used to pull just the numerical output, stripping away the filename
line_count=$(wc -l < "$target_file" | awk '{print $1}')
word_count=$(wc -w < "$target_file" | awk '{print $1}')
char_count=$(wc -m < "$target_file" | awk '{print $1}')

echo "Number of Lines      : $line_count"
echo "Number of Words      : $word_count"
echo "Number of Characters : $char_count"
echo "--------------------------------------------------------"

# 4. Display the first five lines using 'head'
echo "--- FIRST FIVE LINES ---"
head -n 5 "$target_file"
echo ""

# 5. Display the last five lines using 'tail'
echo "--- LAST FIVE LINES ---"
tail -n 5 "$target_file"
echo "========================================================"e
