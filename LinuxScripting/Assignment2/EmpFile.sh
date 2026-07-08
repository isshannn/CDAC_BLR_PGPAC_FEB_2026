#!/bin/bash

# 1. Validate that an employee file argument was provided
if [ -z "$1" ]; then
    echo "Errr: Please provide an employee file name as a command-line argument."
    echo "Usage: $0 <employee_file>"
    exit 1
fi

target_file="$1"

# 2. Check whether the file exists and is a regular file
if [ ! -f "$target_file" ]; then
    echo "Error: Employee file '$target_file' does not exist."
    exit 2
fi

echo "========================================================"
echo "               EMPLOYEE FILE ANALYSIS REPORT            "
echo "========================================================"
echo "Target File            : $target_file"
echo "--------------------------------------------------------"

# 3. Display the first employee record (using head)
echo "--- First Employee Record ---"
head -n 1 "$target_file"
echo ""

# 4. Display the last employee record (using tail)
echo "--- Last Employee Record ---"
tail -n 1 "$target_file"
echo ""

# 5. Display the total number of employee records
# awk extracts only the raw line count from the wc output
total_records=$(wc -l < "$target_file" | awk '{print $1}')
echo "Total Employee Records : $total_records"
echo "--------------------------------------------------------"

# 6. Create a backup file named employee_backup.txt
echo "Creating system backup..."
cp "$target_file" "employee_backup.txt"

if [ $? -eq 0 ]; then
    echo "Success: Backup file 'employee_backup.txt' created successfully."
else
    echo "Error: Failed to create the backup file."
fi

echo "========================================================"
