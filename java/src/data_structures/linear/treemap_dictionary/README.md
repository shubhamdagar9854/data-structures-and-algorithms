# TreeMap Dictionary Implementation

This package implements a company data management system using Java's TreeMap data structure. The implementation provides functionality to store and analyze company information from a CSV file.

## Features

- Load company data from CSV file into a TreeMap structure
- Look up companies by their stock symbol
- Find companies with cheapest/most expensive stock prices
- Calculate mean and median stock prices for specified sectors
- Calculate mean and median stock prices for specified industries

## Classes

### Company

Represents a company with the following properties:

- Symbol (stock symbol)
- Name (company name)
- Last Sale (stock price)
- Sector (business sector)
- Industry (specific industry)

### Driver

Contains the main program logic and user interface:

- CSV file parsing and data loading
- Interactive menu system
- Company lookup functionality
- Statistical analysis methods

## Data Structure

The implementation uses Java's TreeMap to store Company objects with their stock symbols as keys. This provides:

- O(log n) lookup time
- Natural ordering of keys
- Efficient iteration over sorted entries

## Usage

1. Place your company data CSV file in the project directory
2. Run the Driver class
3. Use the interactive menu to:
   - Look up companies by symbol
   - Find cheapest/most expensive stocks
   - Analyze sector statistics
   - Analyze industry statistics

## CSV File Format

The expected CSV format is:

```
Symbol,Name,LastSale,MarketCap,ADR TSO,IPOyear,Sector,Industry,Summary Quote
```

Only the Symbol, Name, LastSale, Sector, and Industry fields are used in this implementation.
