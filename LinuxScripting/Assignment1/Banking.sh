#!/bin/bash

# 1. Read the Account Holder details
echo "Enter Account Holder Name:"
read s_name

echo "Enter Account Number:"
read acc_num

echo "Enter Current Balance:"
read balance

# Loop to continually display the menu until the user exits (optional, but standard for menus)
while true
do
    echo ""
    echo "1. Deposit"
    echo "2. Withdraw"
    echo "3. Balance"
    echo ""
    
    echo -n "Enter Choice : "
    read choice

    case $choice in
        1)
            echo -n "Enter Amount : "
            read amount
            # Perform deposit arithmetic
            balance=$(( balance + amount ))
            echo "Updated Balance : $balance"
            break # Exit loop after displaying output as per sample
            ;;
        2)
            echo -n "Enter Amount : "
            read amount
            # Validate if there are sufficient funds before withdrawing
            if (( amount <= balance )); then
                balance=$(( balance - amount ))
                echo "Updated Balance : $balance"
            else
                echo "Error: Insufficient balance. Current Balance: $balance"
            fi
            break
            ;;
        3)
            echo "Current Balance : $balance"
            break
            ;;
        *)
            echo "Invalid Choice! Please enter 1, 2, or 3."
            ;;
    esac
dones
