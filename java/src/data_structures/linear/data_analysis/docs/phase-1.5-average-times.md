# Data Structure Performance Metrics

## Average Operation Times (nanoseconds)

### Add Operation

| Data Structure | Average Time (ns) |
| -------------- | ----------------- |
| LinkedList     | 30,401,996        |
| ArrayList      | 41,673,901        |
| Vector         | 41,654,756        |
| HashMap        | 117,128,851       |
| LinkedHashMap  | 166,115,019       |
| HashSet        | 195,163,258       |
| HashTable      | 220,928,912       |
| LinkedHashSet  | 245,700,358       |
| TreeSet        | 379,838,869       |
| TreeMap        | 382,456,044       |

### Search Operation

| Data Structure | Average Time (ns) |
| -------------- | ----------------- |
| LinkedHashSet  | 5,416,722         |
| HashSet        | 8,131,886         |
| TreeSet        | 10,333,573        |
| ArrayList      | 11,208,022,206    |
| Vector         | 10,995,268,135    |
| LinkedList     | 24,349,667,604    |
| LinkedHashMap  | 44,203,140,949    |
| TreeMap        | 51,684,631,358    |
| HashTable      | 53,635,210,997    |
| HashMap        | 63,431,715,012    |

### Remove Operation

| Data Structure | Average Time (ns) |
| -------------- | ----------------- |
| LinkedHashSet  | 890,899           |
| LinkedHashMap  | 971,277           |
| HashMap        | 1,067,988         |
| HashSet        | 1,183,639         |
| HashTable      | 1,293,204         |
| TreeMap        | 2,044,405         |
| TreeSet        | 3,302,876         |
| ArrayList      | 1,400,361,887     |
| Vector         | 1,823,394,317     |
| LinkedList     | 4,628,990,688     |

### Sort Operation

| Data Structure | Average Time (ns) |
| -------------- | ----------------- |
| LinkedHashSet  | 52,430,608        |
| HashMap        | 56,031,398        |
| LinkedHashMap  | 58,280,621        |
| TreeSet        | 58,735,955        |
| HashSet        | 76,530,122        |
| TreeMap        | 117,331,651       |
| Vector         | 155,406,385       |
| HashTable      | 226,046,085       |
| LinkedList     | 225,637,584       |
| ArrayList      | 300,097,008       |

### Total Performance

| Data Structure | Average Total Time (ns) |
| -------------- | ----------------------- |
| HashSet        | 281,008,905             |
| LinkedHashSet  | 304,438,586             |
| TreeSet        | 452,211,273             |
| ArrayList      | 12,950,155,002          |
| Vector         | 13,015,723,592          |
| LinkedList     | 29,234,700,000          |
| LinkedHashMap  | 44,428,507,867          |
| TreeMap        | 52,186,463,458          |
| HashTable      | 54,083,479,198          |
| HashMap        | 63,605,934,195          |

## Analysis Notes

1. Performance metrics computed across multiple test runs
2. All times measured in nanoseconds for precision
3. Total time includes overhead between operations
4. Results validated through statistical analysis
5. Consistent test environment maintained across runs

The data demonstrates clear performance patterns:

- Hash-based sets excel at individual operations
- Tree structures balance operation costs
- Linear structures show operation-specific strengths
- Map implementations trade flexibility for performance
