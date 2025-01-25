package data_structures.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Tree Object
 * 
 * @author bjornmelin
 */
public class BST {

    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int input) {
            data = input;
            left = null;
            right = null;
        }
    }

    public BST() {
        root = null;
    }

    public void add(int entry) {
        // No duplicates!
        // Let's try and go to where we'd want to add the entry
        // If we find the entry, stop!

        // Package data into node
        Node newNode = new Node(entry);

        if (root == null) {
            root = newNode; // Since nothing listed, redirect root to point to the same thing newnode is
                            // pointing to
            return;
        }
        // We have to find where to put the data if root is not null!
        add(newNode, root);
    }

    /**
     * Recursive method called on in add method
     * 
     * @param newNode Node being added
     * @param curr    Current node we are at
     */
    private void add(Node newNode, Node curr) {
        // Check node
        if (curr.data == newNode.data) {
            return; // NO DUPLICATES ALLOWED!!!!!
        } else if (curr.data < newNode.data) {
            // Go to the right
            if (curr.right == null)
                curr.right = newNode;
            else // Not an open space
                add(newNode, curr.right);
        } else // curr.data > newNode.data
        {
            // Go to the left
            if (curr.left == null) {
                curr.left = newNode;
            } else // Not at an open space yet so we have to move
            {
                add(newNode, curr.left);
            }
        }
    }

    public String toString() {
        String output = "Inorder traversal of the BST:\n";
        output += inorder(root) + "\n\n" + "Inorder traversal of BST ArrayList: \n" + inorderArray() + "\n\n\n\n\n";
        output += "Preorder traversal of the BST:\n";
        output += preorder(root) + "\n\n" + "Preorder traversal of BST ArrayList: \n" + midpoints(inorderArray());
        output += "\n\n=================================================================================================================="
                + "\n\n\n";
        return output;
    }

    public String inorder(Node curr) {
        // LMR Left, Middle, Right
        String output = "";
        // Verify we are not null
        if (curr == null)
            return output;

        // Left
        output = output + inorder(curr.left);

        // Middle
        output = output + "\t" + curr.data + "\t";

        // Right
        output = output + inorder(curr.right);

        return output;
    }

    /**
     * recursive method called upon to do an in-order traversal and store each value
     * of a BST into an ArrayList
     * 
     * @param curr       Node we are currently looking at
     * @param finalArray final ArrayList of in-order BST values
     */
    public void inorderArray(Node curr, ArrayList<Integer> finalArray) {
        // LMR Left, Middle, Right
        if (curr == null) {
            return;
        }
        inorderArray(curr.left, finalArray);
        finalArray.add(curr.data);
        inorderArray(curr.right, finalArray);
    }

    /**
     * Calls on the method above to create an in-order ArrayList of BST values
     * 
     * @return ArrayList of BST values in-order
     */
    public ArrayList<Integer> inorderArray() {
        ArrayList<Integer> inorder = new ArrayList();
        inorderArray(root, inorder);
        return inorder;
    }

    public String preorder(Node curr) {
        // MLR Middle, Left, Right
        String output = "";
        // Verify we are not null
        if (curr == null)
            return output;

        // Middle
        output = output + "\t" + curr.data + "\t";

        // Left
        output = output + preorder(curr.left);

        // Right
        output = output + preorder(curr.right);

        return output;
    }

    /**
     * Orders an Array List via mid-points
     * 
     * @param data ArrayList of integers to be sorted
     * @return An ArrayList of integers sorted by mid-points
     */
    public ArrayList<Integer> midpoints(ArrayList<Integer> data) {
        ArrayList<Integer> finalList = new ArrayList<Integer>();

        // Stop cases
        if (data.size() <= 1) {
            return data;
        }

        // Break into two sides of the arraylist
        ArrayList<Integer> left = new ArrayList<Integer>();
        int mid = data.size() / 2;
        // Recursively call method with an ArrayList of values from index zero to
        // midpoints index
        List<Integer> temp = new LinkedList();
        temp = data.subList(0, mid);
        left.addAll(temp);

        ArrayList<Integer> right = new ArrayList<Integer>();
        // recursively call method with an ArrayList of values from index of midpoints
        // to end of data
        temp = data.subList(mid + 1, data.size());
        right.addAll(temp);

        finalList.add(data.get(mid));

        finalList.addAll(midpoints(left));
        finalList.addAll(midpoints(right));

        return finalList;
    }

    /**
     * Method used to add the elements for the BST in the order of the ArrayList
     * created from my midpoints method
     * Utilizes all 4 steps in this lab(in-order, midpoints, clear, re-balance)
     */
    public void rebalance() {
        ArrayList<Integer> inorder = new ArrayList();
        inorderArray(root, inorder);
        midpoints(inorder);
        int arraySize = midpoints(inorder).size(); // used in my for loop below to tell how many times to add
        clear();

        for (int i = 0; i < arraySize; i++) {
            // Adds elements to the BST in the order created in my midpoints method.
            add(midpoints(inorder).get(i));
        }
    }

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
        output = output + "\t" + curr.data + "\t";

        return output;
    }

    public boolean contains(int target) {
        // Check if empty
        if (root == null)
            return false;

        return search(target, root);
    }

    /**
     * Recursively search for target given
     * 
     * @param target data to look for
     * @param curr   node currently examining
     * @return return true if found, false otherwise
     */
    private boolean search(int target, Node curr) {
        // If we fall off the bottom of the tree
        if (curr == null)
            return false;

        // Check current Node
        if (curr.data == target)
            return true;
        else if (curr.data < target) // Target is bigger, go right!
            return search(target, curr.right);
        else // Target is smaller, go left!
            return search(target, curr.left);
    }

    /**
     * Removes a target int in the BST
     * 
     * @param target data to look for
     */
    public void remove(int target) {
        // Check for empty
        if (root == null)
            return;
        // Update root?
        root = removeNode(target, root);
    }

    private Node removeNode(int target, Node curr) {
        // If we fall off the bottom of the tree
        if (curr == null)
            return null;

        // Check current Node
        if (curr.data == target) {// Found target! Need to remove
                                  // 3 Cases
                                  // Case 1: No kids
            if (curr.left == null && curr.right == null)
                return null;
            // Case 2: 1 kid
            else if (curr.left == null)
                return curr.right;
            else if (curr.right == null)
                return curr.left;
            // Case 3: 2 kids
            else {
                // Step 1: find the replacement value
                // Lets find the max on the left side
                int replacementValue = max(curr.left);
                // Step 2: Remove the replacement value's node
                remove(replacementValue);
                // Step 3: Replace our data with the replacements value
                curr.data = replacementValue;
                return curr;
            }
        } else if (curr.data < target) // Target is bigger, go right!
            curr.right = removeNode(target, curr.right);
        else // Target is smaller, go left!
            curr.left = removeNode(target, curr.left);
        return curr;
    }

    private int max(Node curr) {
        if (curr.right != null) // Not the local max
            return max(curr.right);
        else // Is the local max
            return curr.data;
    }

    /**
     * Clears the BST of all entries
     */
    public void clear() {
        root = null;
    }
}