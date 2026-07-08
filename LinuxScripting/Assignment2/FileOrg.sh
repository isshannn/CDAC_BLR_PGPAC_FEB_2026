#!/bin/bash

# 1. Read Main String and Substring from the user
echo "Ente Main String:"
read main_str

echo "Enter Substring to search:"
read sub_str

echo "========================================================"
echo "               STRING ANALYSIS REPORT                   "
echo "========================================================"

# 2. Check whether the main string is empty or not
if [ -z "$main_str" ]; then
    echo "Main String Status  : Empty"
else
    echo "Main String Status  : Not Empty"
fi

# 3. Display the length of the main string
# ${#variable} returns the total character count of a string natively in Bash
string_length=${#main_str}
echo "Main String Length  : $string_length characters"

# 4. Check whether the substring is present inside the main string
# Uses wildcard matching inside double brackets [[ ... ]]
if [[ "$main_str" == *"$sub_str"* ]]; then
    echo "Search Result       : Success! '$sub_str' is present."
else
    echo "Search Result       : Failed. '$sub_str' was not found."
fi

echo "========================================================"
