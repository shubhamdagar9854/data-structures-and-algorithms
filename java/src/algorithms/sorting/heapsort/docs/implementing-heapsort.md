# Implementing Heapsort

_By Bjorn Melin_  
_CSC320 Project #2_  
_February 21, 2019_

## Introduction

Heapsort is one of the main sorting algorithms that has been studied throughout the semester thus far. Unlike other unstable sorting algorithms like quicksort and selection sort, heapsort's running time will always be Θ(n lg n). In this study, a Java implementation of heapsort was created in which a static function was used to perform heapsort on a given array of integers of any size. Within the implementation, counters were added into each method used for heapsort with the purpose of counting the number of operations performed while sorting. The purpose of the study was to show whether or not the heapsort implementation created ran in Θ(n lg n) time as is expected by the heapsort algorithm.

## Methods

To show that the running time of the heapsort implementation created in this study was in fact Θ(n lg n), a set of static methods were created. Included in these methods were the HEAPSORT method itself along with its helper methods:

- BUILD-MAX-HEAP
- MAXHEAPIFY
- PARENT
- LEFT
- RIGHT

Once all of these methods had been created, counters were added into each method to count the operations or lines of code performed by the HEAPSORT algorithm. Counters were first added into the helper methods BUILD-MAXHEAP and MAX-HEAPIFY. Once the counters were correctly coded to increment by 1 after each operation performed by the method, the return type of the method was changed to an integer so that the operation count would be returned upon each run.

Next, a final counter was added to the HEAPSORT method which was incremented by:

1. The return values (counts) from the helper methods
2. Each line of code performed in the HEAPSORT method itself

Similar to the helper methods, the return type of HEAPSORT was also changed to an integer so that the total operation count of the algorithm would be returned each run.

Once the body of the algorithm had been created which would accomplish the goal of the study by counting the operations performed, a method called TEST-LOOPER was created. This method was used to run the bulk of the program. This method takes in input values for:

- The desired size of the array to be sorted
- The desired number of tests to perform

The method is structured so that for the desired number of tests, it will:

1. Create an array of random integers ranging from 1-100 (inclusive) of the desired array size using the method CREATE-RANDOMARRAY
2. Run heapsort on each array and add the return number of operations taken to a counter
3. Calculate the average operations by dividing the total by number of tests
4. Print:
   - Expected number of operations for the given input size
   - Actual average number of operations taken
   - Ratio between actual and expected operations

The main method simply calls TEST-LOOPER with different array sizes (10, 100, 1000, 10000, 100000, and 1000000) running 100 tests for each size.

## Results

Upon completion of running the program, output was shown for each array size tested. The results are summarized in the table below:

| Array Size | Expected Operations | Actual Operations | Ratio (Actual/Expected) |
| ---------- | ------------------: | ----------------: | ----------------------: |
| 10         |              33.219 |           194.000 |                   5.840 |
| 100        |             664.386 |         2,077.000 |                   3.126 |
| 1,000      |           9,965.784 |        20,936.000 |                   2.101 |
| 10,000     |         132,877.124 |       209,311.000 |                   1.575 |
| 100,000    |       1,660,964.047 |     2,089,763.000 |                   1.258 |
| 1,000,000  |      19,931,568.569 |    20,936,000.000 |                   1.051 |

By analyzing the ratios between the actual number of operations taken and the expected number of operations taken, we see that the implementation of heapsort created for this study did in fact run in Θ(n lg n) time. The larger the size of the arrays got, the lower the ratio became and the closer the run time got to exactly Θ(n lg n).

A ratio of 1 would mean that actual run time was exactly Θ(n lg n). Although the ratios are not exactly 1, the variations in ratios can be explained by the recurrence equation:

```
T(n) = c₁(n lg n) + c₂(n) + c₃(1)
```

From this equation, we see that when the value of n is low, the second term in the recurrence equation will actually have a large impact on the total running time for the algorithm. As the value of n grows, the second and third terms become meaningless since (n lg n) is so much larger than just n itself. Thus, explaining why the ratio between the actual operation count and expected operation count gets close to 1 as n increases.

Constants also play a role in the running time for the algorithm. The constants c₁, c₂, and c₃ will not always be the same each run. Thus, they are a determining factor in the total time the algorithm takes to run and they help to explain any variations in run times between each run of the program. At a certain value of n, such as one billion, we could expect the ratio between actual and expected operations to drop below 1. This is because the helper methods for heapsort do not always take the worst-case times to run and thus on average the number of operations and running time for heapsort can possibly be less than expected.

## Conclusion

In conclusion, the statistics gathered through running heapsort show that the implementation created for this study does in fact run in Θ(n lg n) time. Through sorting arrays of various sizes containing integers ranging from 1-100 (inclusive) and computing ratios between actual and expected operations, the results clearly demonstrate the algorithm's complexity.

The results show us that there is some variation from exactly Θ(n lg n) for the running times which are explained by:

1. The impact of constant terms
2. Lower significant run time values on the actual total running time

When these terms are factored in, the results display clearly that this implementation of heapsort runs in Θ(n lg n) time.
