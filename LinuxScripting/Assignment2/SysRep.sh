#!/bin/bash

# Define the output report fle path
report_file="SystemReport.txt"

# Code block inside curly braces groups all outputs to be redirected together into the file
{
    echo "========================================================"
    echo "               SYSTEM MAINTENANCE REPORT                "
    echo "========================================================"
    
    # 1. Display the current user
    echo "Current User         : $(whoami)"
    
    # 2. Display the current date and time
    echo "Date & Time Generated: $(date '+%Y-%m-%d %H:%M:%S %Z')"
    echo "--------------------------------------------------------"
    
    # 3. Display all logged-in users
    echo "--- LOGGED-IN USERS ---"
    who
    echo "--------------------------------------------------------"
    
    # 4. Display memory usage
    # -m displays memory in Megabytes for clean human readability
    echo "--- MEMORY USAGE ---"
    free -m
    echo "--------------------------------------------------------"
    
    # 5. Display disk usage
    # -h makes sizes human-readable (e.g. GB, MB)
    echo "--- DISK SPACE USAGE ---"
    df -h /
    echo "========================================================"
} > "$report_file"

# 6. Display a confirmation message after the report has been generated
if [ $? -eq 0 ]; then
    echo "Success: System Maintenance Report generated successfully!"
    echo "The complete log has been saved to: '$report_file'"
else
    echo "Error: Failed to safely compile the maintenance log data."
fi
