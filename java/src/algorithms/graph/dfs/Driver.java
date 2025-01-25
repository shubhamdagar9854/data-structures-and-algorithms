package algorithms.graph.dfs;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Random;

/**
 * CSC320 Project #4: Depth-First Search Program
 * This program implements a Depth-First Search using an adjacency list
 * representation of a Graph Object. A DFS() and dfsVistit() method are created
 * to implement the Depth-First Search. Counters are added to this program to
 * count the number of operations performed. Tests are ran on dif. sized graphs
 * with varying densities to show the efficiency of DFS.
 * 
 * @author Bjorn Melin
 *         4/16/19
 */

public class Driver {
    /**
     * Graph class - represents a graph using an adjacency matrix
     */
    private static class Graph {
        private boolean[][] adjacencyMatrix;
        private int vertices;
        private int edges;
        private Random rand;

        /**
         * Constructor that creates a graph with n vertices and probability p of edges
         * 
         * @param n number of vertices
         * @param p probability of edges between vertices (0-1)
         */
        public Graph(int n, double p) {
            vertices = n;
            edges = 0;
            rand = new Random();
            adjacencyMatrix = new boolean[n][n];

            // Create edges based on probability
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (rand.nextDouble() < p) {
                        adjacencyMatrix[i][j] = true;
                        adjacencyMatrix[j][i] = true;
                        edges++;
                    }
                }
            }
        }

        /**
         * Get adjacencies of a vertex
         * 
         * @param vertex index of vertex
         * @return LinkedList of adjacent vertices
         */
        public LinkedList<Integer> getAdjacenciesOfVertex(int vertex) {
            LinkedList<Integer> adjacencies = new LinkedList<>();
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i]) {
                    adjacencies.add(i);
                }
            }
            return adjacencies;
        }

        /**
         * Get number of vertices in the graph
         * 
         * @return number of vertices
         */
        public int numberOfVertices() {
            return vertices;
        }

        /**
         * Get number of edges in the graph
         * 
         * @return number of edges
         */
        public int numberOfEdges() {
            return edges;
        }

        /**
         * String representation of the graph
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    sb.append(adjacencyMatrix[i][j] ? "1 " : "0 ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    /**
     * Implements the bulk of this program by testing a Depth First Search
     * on the Graph Class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * The initial test for a Graph Object which was included in the
         * project description on moodle
         */
        Graph g = new Graph(4, 0.6);
        System.out.println("The graph is");
        System.out.println(g.toString());
        System.out.println("It had " + g.numberOfVertices() + " vertices and "
                + g.numberOfEdges() + " edges.");
        System.out.println("\n\n");

        /**
         * Runs the tester for implementing a DFS on graphs of sizes (vertices)
         * 5, 10, 100, 1000, with varying values for probability switching b/w
         * 0.2 and 0.8 to test on sparse and dense graphs, respectively.
         * The result tells you the average number of edges for all of the
         * tests ran and the average number of operations performed.
         */
        tester(5, 0.2, 5);
        tester(5, 0.8, 5);
        tester(5, 0.8, 5);
        tester(5, 0.2, 50);
        tester(5, 0.8, 50);
        tester(5, 0.2, 500);
        tester(5, 0.8, 500);
        // tester(5, 0.2, 5000);
        // tester(5, 0.8, 5000);
    }

    /**
     * Method which runs the bulk of this program. Takes in inputs for the
     * number of tests to run on the graph of the size and probability inputted.
     * Keeping track of the number of operations which the DFS took.
     * 
     * @param numTests      int denoting the number of tests (DFS's) to be ran on a
     *                      graph of the specified structure.
     * @param prob          double denoting the density of the desired graph to
     *                      test.
     * @param numOfVertices int denoting the number of vertices to be added
     *                      to the graph.
     */
    public static void tester(int numTests, double prob, int numOfVertices) {
        /**
         * creates an array which stores the sum of all operations made by
         * running the algorithm and edges of the graphs.
         * countEdgeSum[0] = opCount, countEdgeSum[1] = edges
         */
        int[] countEdgeSum = new int[2];

        /**
         * for loop which creates a new graph and array of vertices, and keeps
         * track of the number of edges in each graph along with the number of
         * ops taken for running a DFS on the graph
         */
        for (int i = 0; i < numTests; i++) {
            Graph temp = new Graph(numOfVertices, prob);
            Vertex[] vertArr = new Vertex[temp.numberOfVertices()];
            /**
             * for each vertex in the graph (stored now in the vertArr), this
             * loop will create a new Vertex which is place into the array
             * at its corresponding index and then will create a LinkedList of
             * the adjacent vertices for each vertex, thus implementing the
             * adjacency list (see Vertex Class below for structure)
             */
            for (int j = 0; j < temp.numberOfVertices(); j++) {
                Vertex v = new Vertex(temp.getAdjacenciesOfVertex(j));
                vertArr[j] = v;
            }

            // creates a new array which store the number of edges of the Graph
            // and the operation count taken when performing a DSF on it
            int[] countEdge = new int[2];
            countEdge[0] = 0; // stores time
            countEdge[1] = 0; // stores op count

            // Calls DFS with inputs of the array of adjacency lists (vertArr)
            // and the countEdge array which will be incremented through the call
            DFS(vertArr, countEdge);

            // adds the operation counts
            countEdgeSum[0] += countEdge[1];
            // adds the edge counts
            countEdgeSum[1] += temp.numberOfEdges();

            // Prints off the array of adjacency lists and their attributes
            // for testing to see that my implementation is correctly functioning.
            int counter = 0;
            for (Vertex v : vertArr) {
                System.out.println("Vertex " + counter + ":\t" + v.toString());
                counter++;
            }
            System.out.println("\n");
        }

        double avEdges = (countEdgeSum[1] / numTests);
        double avOps = (countEdgeSum[0] / numTests);
        // computes the what the expected num of ops would be at O(V + E) time
        double expected = numOfVertices + (countEdgeSum[1] / numTests);
        // ratio b/w the expected number of ops taken vs. the real number of
        // ops taken for DFS
        double ratio = avOps / expected;

        // used to only display 3 decimal accuracy in output print
        DecimalFormat numberFormat = new DecimalFormat("#.000");
        System.out.println("############### TESTING A " + numOfVertices +
                " VERTEX GRAPH WITH " + prob + " DENSITY"
                + " ###############\n\tEdge Count Average:\t\t"
                + "Average Operation Count:\t\t"
                + "Ratio B/w Expected Vs. Actual Operations:\n\t\t"
                + avEdges + "\t\t\t\t" + avOps + "\t\t\t\t\t\t"
                + numberFormat.format(ratio));
        System.out.println("\n\n");
    }

    /**
     * Depth-First Search Method.
     * Performs a DFS on a Graph Object.
     * 
     * @param vertArr Vertex[] denoting an array of vertices in the Graph
     * @param opTime  int[] used to store the time taken at index 0 and op
     *                count at index 1
     */
    public static void DFS(Vertex vertArr[], int opTime[]) {
        /**
         * loop which paints all vertices in the graph WHITE and initializes
         * their pi attributes to NIL
         */
        for (Vertex u : vertArr) {
            u.color = "WHITE";
            opTime[1] += 1; // increment operation counter
            u.pi = -1; // pi is set to -1 to denote NIL value
            opTime[1] += 1; // increment operation counter
        }
        // We do not have to initialize time = 0 b/c it is already set to 0
        // in the input opTime array

        /**
         * loop which checks each vertex in the graphs array of vertices in turn
         * and, when a vertex is found, it is visited by calling DFSVisit
         */
        for (int i = 0; i < vertArr.length; i++) {
            opTime[1] += 1; // increment operation counter
            /**
             * if the vertices color is WHITE, then we visit it, every call to
             * DFSVisit makes vertex vertArr[i] the root of a new tree in the
             * DF forest, when DFSVisit returns, every vertex in vertArr has
             * been assigned a discovery time and finish time
             */
            if ("WHITE".equals(vertArr[i].color)) {
                DFSVisit(vertArr, i, opTime);
                opTime[1] += 1; // increment operation counter
            }
        }
    }

    /**
     * DFS Visit method
     * 
     * @param vertArr Vertex[] denoting an array of vertices in the Graph
     * @param index   int denoting the index to look at in the vertArr
     * @param opTime  int[] which is used to store the operations and the time
     *                in the algorithm
     */
    public static void DFSVisit(Vertex vertArr[], int index, int[] opTime) {
        // white vertex u has just been discovered, increment time
        opTime[0] += 1;
        opTime[1] += 1; // increment operation counter
        vertArr[index].d = opTime[0];
        opTime[1] += 1; // increment operation counter
        vertArr[index].color = "GRAY";
        opTime[1] += 1; // increment operation counter

        // explore edge (u,v)
        for (int i = 0; i < vertArr[index].adjV.length; i++) {
            opTime[1] += 1; // increment operation counter
            if ("WHITE".equals(vertArr[vertArr[index].adjV[i]].color)) {
                vertArr[vertArr[index].adjV[i]].pi = index;
                opTime[1] += 1; // increment operation counter
                DFSVisit(vertArr, vertArr[index].adjV[i], opTime);
                opTime[1] += 1; // increment operation counter
            }
        }
        opTime[1] += 1; // increment operation counter
        vertArr[index].color = "BLACK"; // blacken u, it is finished
        opTime[0] += 1; // increment time
        opTime[1] += 1; // increment operation counter
        vertArr[index].f = opTime[0];
    }

    /**
     * Vertex Object - represents a vertex in the graph
     */
    public static class Vertex {
        String color; // color of the vertex
        int pi; // source vertex index
        int d; // the time in which the vertex was discovered
        int f; // time which each vertex is finished
        int adjV[]; // contains all adjacent vertices for a vertex

        /**
         * Parameter Constructor for Vertex
         * 
         * @param adjs LinkedList denoting the adjacent vertices of a
         *             given index
         */
        @SuppressWarnings("unchecked")
        public Vertex(LinkedList adjs) {
            // Create and fill the adjacentVertices array
            adjV = new int[adjs.size()];
            for (int i = 0; i < adjs.size(); i++) {
                adjV[i] = (int) adjs.get(i);
            }
        }

        /**
         * toString method for a Vertex
         * 
         * @return String denoting each variable value of a Vertex
         */
        @Override
        public String toString() {
            return "Vertex{" + "color=" + color + ", pi=" + pi + ", d=" + d
                    + ", finish=" + f + ", adjV=" + arrTS(adjV) + '}';
        }

        /**
         * toString method for the adjV array
         * 
         * @param array : int[] denoting the array of vertices
         * @return String denoting the array as a String
         */
        public String arrTS(int array[]) {
            String output = "[";
            for (int i = 0; i < array.length; i++) {
                output += array[i];
                if (i != array.length - 1) {
                    output += ",";
                }
            }
            return output + "]";
        }
    }
}