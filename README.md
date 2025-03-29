# Entity Resolution

## Overview

This project solves the problem of **entity resolution** — finding and grouping duplicate records that refer to the same company. The input data contains organizations with 75 attributes each, and the goal is to detect duplicates and organize them into groups.

---

## Solution Explanation

### 1. Cleaning the Input

The raw file (`input.csv`) might include broken rows due to newlines inside fields. To fix this (`CsvCleaner.java`):
- Reads the file line by line.
- Joins lines together until a valid row with exactly 75 fields is formed.
- Writes only valid rows to `cleaned_input.csv`.

### 2. Parsing and Filtering

We read the cleaned file (`cleaned_input.csv`) and:
- Skip the header.
- Validate that each row has exactly 75 columns.
- Ignore rows with empty company names.

### 3. Detecting Duplicates

`CompanyResolver` is a class designed to compare companies. Each company has many fields, and we compare all text fields using a similarity metric (Jaro-Winkler). This helps detect companies that are written slightly differently but are actually the same (typos, extra spaces, etc.).

For every pair of companies:
- We compare non-empty fields.
- Compute a similarity score for each.
- Calculate the average score across fields.
- If the average is above 0.85, they are marked as duplicates.

### 4. Grouping Duplicates

Once duplicates are detected, we model them as a graph. Each node is a company, and each edge connects two similar companies.

We then use DFS (Depth-First Search) to find connected components in the graph. Each connected group is assigned a `group_id`. All companies in the same group are considered duplicates.

### 5. Generating the Output

Finally, we write the results to `output.csv`, but only for groups that have at least 2 companies — in other words, only duplicates.

Each output row includes:
- Internal ID (index in list)
- Company name
- Group ID
- Legal name
- Website domain
- Primary email

---

## Output Files

- `cleaned_input.csv`: The cleaned and valid version of the original data.
- `output.csv`: The list of duplicate companies, grouped by `group_id`.

---

## Project Structure

- `Main.java` – Reads files, runs logic, and writes results.
- `CsvCleaner.java` – Cleans and validates the input file.
- `Company.java` – Model class for each company (75 fields).
- `CompanyResolver.java` – Contains the logic for comparing and grouping duplicates.
- `Utils.java` – Helper functions like text normalization and similarity checking.

---

## Documentation
- https://www.geeksforgeeks.org/jaro-and-jaro-winkler-similarity/
- https://www.quantexa.com/resources/entity-resolution-guide/
- https://stackoverflow.com/questions/
