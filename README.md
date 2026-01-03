# Personal Finance Tracker
A simple Java console app to track your income and expenses.

# Features
Add income and expense transactions with categories

View all transactions in a table

See a summary of total income, expenses, and balance

Fully local

# Getting Started
Clone the repo:

git clone https://github.com/claytoncooper018/FinanceTracker.git

cd FinanceTracker

Create the data folder (if it doesn’t exist):

mkdir data

# Run the program:
javac src/*.java -d out

java -cp out Main

# Data Files
data/transactions.csv – Your real transactions, stored locally (ignored by Git)

CSV format:

YYYY-MM-DD,Description,Category,Amount

2026-01-01,Salary,Income,3000.00

2026-01-02,Coffee,Food,-4.50

# Notes
Positive amounts → income

Negative amounts → expenses

.gitignore ensures your sensitive data stays private
