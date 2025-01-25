# Data Structures Performance Analysis Documentation

This directory contains documentation and analysis of performance characteristics for various Java data structure implementations.

## Contents

| File                       | Description                                                |
| -------------------------- | ---------------------------------------------------------- |
| checking-for-outliers.md   | Analysis of performance outliers across multiple test runs |
| phase-1-data-collection.md | Raw performance data from initial test runs                |
| phase-1.5-average-times.md | Computed average performance times across operations       |
| phase-2-analysis.md        | Detailed analysis of performance patterns and tradeoffs    |
| phase-3-outside-sources.md | References and citations for analysis research             |
| searches-doubled.md        | Impact analysis of increasing search operations            |
| searches-halved.md         | Impact analysis of decreasing search operations            |

## Key Findings

1. Search Performance:

   - HashSet, LinkedHashSet and TreeSet performed best for searching
   - HashMap, HashTable and TreeMap performed worst due to key-value structure

2. Operation-Specific Leaders:

   - Adding: LinkedList, Vector, ArrayList
   - Removing: LinkedHashSet, LinkedHashMap, HashMap
   - Sorting: LinkedHashSet, HashMap, LinkedHashMap

3. Overall Performance:
   - Best: HashSet, LinkedHashSet, TreeSet
   - Worst: HashMap, HashTable, TreeMap

## References

- Java API Documentation
- GeeksForGeeks: LinkedHashSet Implementation
- Java67: TreeMap vs TreeSet Analysis
- DZone: ArrayList vs LinkedList vs Vector Performance
