#!/bin/bash

# Clear the screen to ensure a clean, beautiful report layout
clear

echo "======================================================="
echo "               SYSTEM INFORMATION REPORT                "
echo "========================================================"

# 1. Fetch and display the current username
echo "Current Username       : $(whoami)"

# 2. Fetch and display the current date and time
echo "Current Date & Time    : $(date '+%Y-%m-%d %H:%M:%S %Z')"

# 3. Fetch and display the machine's Hostname
echo "Hostname               : $(hostname)"

# 4. Fetch and display the Current Working Directory
echo "Current Directory      : $(pwd)"

# 5. Fetch and display System Uptime (simplified summary)
# Using 'awk' cleans up the text to extract just the running duration
echo "System Uptime          : $(uptime -p)"

echo "--------------------------------------------------------"
echo "               DISK SPACE AVAILABILITY                  "
echo "--------------------------------------------------------"

# 6. Fetch total available disk space across standard file systems
# -h prints sizes in human-readable formats (GB/MB)
# --total adds a handy summary row at the very bottom
df -h --type=ext4 --type=vfat --type=xfs --total 2>/dev/null || df -h

echo "========================================================"=
