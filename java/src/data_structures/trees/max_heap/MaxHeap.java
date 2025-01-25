package data_structures.trees.max_heap;

import java.util.ArrayList;

/**
 * Node based Max Heap
 * 
 * @author bjornmelin
 */
public class MaxHeap implements Heap {

    private ArrayList<Node> myNodes = new ArrayList();
    private Node root;

    /**
     * Class for Nodes in Heap
     */
    private class Node {
        Cargo data; // Stores data contained in each node
        Node left; // Left in tree
        Node right; // right in tree

        public Node(Cargo info) {
            data = info;
            left = null;
            right = null;
        }
    }

    /**
     * Default Constructor for MaxHeap
     */
    public MaxHeap() {
        root = null;
        // Insert null at position 0 to make the math work
        myNodes.add(root);
    }

    /**
     * Performs an INORDER, PREORDER and POSTORDER traversal of the Heap
     * 
     * @return a String which contains the output of the 3 traversals
     */
    public String toString() {
        // Heap Status""
        String output = "\nHEAP STATUS:\n";
        output += "\nInorder traversal of the Heap:\n\t";
        output += inorder(root);
        output += "\n\nPreorder traversal of the Heap:\n\t";
        output += preorder(root);
        output += "\n\nPostorder traversal of the Heap:\n\t";
        output += postorder(root);
        return output;
    }

    /**
     * Adds an entry to the heap
     * 
     * @param entry Cargo to add to the Heap
     */
    @Override
    public void add(Cargo entry) {
        Node newNode = new Node(entry);
        int newIndex = myNodes.size();
        int parentIndex = myNodes.size() / 2; // Parent index is always n/2

        myNodes.add(newNode);
        // set pointers
        if (parentIndex != 0) // If parent index is not root
        {
            if (myNodes.get(parentIndex).left == null)
                myNodes.get(parentIndex).left = newNode;
            else
                myNodes.get(parentIndex).right = newNode;
        } else {
            root = newNode;
        }

        // Bubble up!
        while ((parentIndex > 0) && (entry.compareTo(myNodes.get(parentIndex).data) > 0)) // entry is bigger than parent
                                                                                          // so move up
        {
            myNodes.get(newIndex).data = myNodes.get(parentIndex).data;
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        myNodes.get(newIndex).data = entry;
    }

    /**
     * Removes the current Root of the heap
     * 
     * @return the Cargo which was at the root of the heap
     */
    @Override
    public Cargo removeRoot() {

        int listSize = myNodes.size(); // keeps track of the heap size
        int lastIndex = (myNodes.size() - 1);
        int parentIndex = lastIndex / 2;
        Node last = myNodes.get(lastIndex);
        Node parentNode = myNodes.get(parentIndex);

        // Save target data
        if (listSize == 1) {
            // if the tree is empty, don't remove anything
            return null;
        }

        root.data = last.data;
        last.data = root.data;

        if (parentNode == null) // If there is no parent node, sets the root to null
        {
            myNodes.remove(last);
            last.data = null;
        } else if (parentNode.left == last) {
            parentNode.left = null;
        } else {
            parentNode.right = null;
        }
        myNodes.remove(last); // removes the last node added to the heap
        listSize--; // Decreased the size of the heap b/c removed a node

        bubbleDownRoot(root); // Recursively calls on bubbleDownRoot method to sink the new root to its proper
                              // position

        return root.data;
    }

    /**
     * Recursive method called on in remove root method to sink the new root to
     * correct position in Heap
     * 
     * @param curr Node currently looking at in Heap
     */
    public void bubbleDownRoot(Node curr) {
        if (curr.left == null) // If curr.left is null, we know there are no children b/c you add left - right
        {
            return;
        }
        // Bubble down!
        // set up curr for location: taken care of with recursive method
        // check if has kids and if either is bigger, if bigger, swap with biggest kid
        int bubblyGuy = 0;

        if (curr.left.data.compareTo(curr.data) > 0) {
            bubblyGuy = -1; // bubble down to the left
        }
        if (curr.right != null) {
            if (curr.right.data.compareTo(curr.left.data) > 0) {
                if (curr.right.data.compareTo(curr.data) > 0) {
                    bubblyGuy = 1; // bubble down to the right
                }
            }
        } else {
            // No kids, don't need to bubble down
            bubblyGuy = 0;
        }

        if (bubblyGuy > 0) // Swaps to the right
        {
            Cargo temp = curr.data;
            curr.data = curr.right.data;
            curr.right.data = temp;
            bubbleDownRoot(curr.right);
        } else if (bubblyGuy < 0) // Swaps to the left
        {
            Cargo temp = curr.data;
            curr.data = curr.left.data;
            curr.left.data = temp;
            bubbleDownRoot(curr.left);
        }
    }

    /**
     * Determines if a given target is in the heap or not
     * 
     * @param target Cargo to look for in the heap
     * @return true if target Cargo was in the heap, false otherwise
     */
    @Override
    public boolean contains(Cargo target) {
        return search(target, root);
    }

    /**
     * Recursively search for target given
     * 
     * @param target data to look for
     * @param curr   node currently examining
     * @return return true if found, false otherwise
     */
    private boolean search(Cargo target, Node curr) {
        // Check if the node exists
        if (curr == null)
            return false;

        // Check if node has target
        else if (curr.data.compareTo(target) == 0)
            return true;

        return search(target, curr.right) || search(target, curr.left);
    }

    /**
     * In-order traversal of heap
     * 
     * @param curr Node currently looking at
     * @return String denoting in-order traversal of heap
     */
    public String inorder(Node curr) {
        // LMR Left, Middle, Right
        String output = "";
        // Verify we are not null
        if (curr == null)
            return output;

        // Left
        output = output + inorder(curr.left);

        // Middle
        output = output + "" + curr.data + "\t";

        // Right
        output = output + inorder(curr.right);

        return output;
    }

    /**
     * Pre-order traversal of Heap
     * 
     * @param curr Node currently looking at
     * @return String denoting pre-order traversal of Heap
     */
    public String preorder(Node curr) {
        // MLR Middle, Left, Right
        String output = "";
        // Verify we are not null
        if (curr == null)
            return output;

        // Middle
        output = output + "" + curr.data + "\t";

        // Left
        output = output + preorder(curr.left);

        // Right
        output = output + preorder(curr.right);

        return output;
    }

    /**
     * Post-order traversal of Heap
     * 
     * @param curr Node currently looking at
     * @return String denoting post-order traversal of Heap
     */
    public String postorder(Node curr) {
        // LRM Left, Right, Middle
        String output = "";
        // Verify we are not null
        if (curr == null)
            return output;

        // Left
        output = output + postorder(curr.left);

        // Right
        output = output + postorder(curr.right);

        // Middle
        output = output + "" + curr.data + "\t";

        return output;
    }
}