# Depth-First Search Implementation

This project implements a Depth-First Search (DFS) algorithm using an adjacency list representation of a Graph Object. The implementation includes functionality to measure algorithm performance by counting operations and testing graphs with varying densities.

## Overview

The Depth-First Search (DFS) algorithm explores a graph by going as deep as possible along each branch before backtracking. This implementation uses:

- Adjacency list representation for the graph
- Vertex coloring (WHITE, GRAY, BLACK) to track exploration status
- Discovery and finish times for each vertex
- Operation counting to analyze algorithm performance

## Classes

### Driver

Contains the main implementation with:

- `DFS()` - Main DFS algorithm implementation
- `DFSVisit()` - Helper method for DFS traversal
- `tester()` - Method to run performance tests
- Inner classes:
  - `Graph` - Represents the graph structure using adjacency matrix
  - `Vertex` - Represents a vertex in the graph

## Algorithm Details

The DFS implementation uses three colors to track vertex states:

- WHITE: Unvisited vertex
- GRAY: Vertex being explored
- BLACK: Finished vertex

Additional vertex attributes:

- `pi`: Parent vertex in DFS tree
- `d`: Discovery time
- `f`: Finish time
- `adjV`: Array of adjacent vertices

## Time Complexity

- Time Complexity: O(V + E)
  - V = number of vertices
  - E = number of edges

The implementation includes operation counting to verify this complexity empirically.

## Testing

The program includes comprehensive testing functionality:

- Tests different graph sizes (5, 50, 500 vertices)
- Tests both sparse (0.2 density) and dense (0.8 density) graphs
- Measures average operation counts and compares to theoretical complexity
- Calculates ratio between expected and actual operations

## Usage

To run the tests:

```java
java algorithms.graph.dfs.Driver
```

The output shows:

- Graph representation
- Number of vertices and edges
- Operation counts
- Performance metrics for different graph sizes and densities

## Implementation Notes

- Uses standard DFS coloring scheme
- Tracks parent pointers for DFS tree construction
- Maintains discovery/finish times
- Supports both sparse and dense graphs
- Provides detailed performance metrics
