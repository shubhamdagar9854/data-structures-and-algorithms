package data_structures.trees.red_black_tree;

/**
 * Red-Black Tree Implementation.
 * Red-Black Tree Class
 * @author Bjorn Melin
 * 4/12/19
 */

/**
 * This class represents a Red-Black Tree as outlined in CLRS chapter 13.
 * Most methods are class methods so they can be transcribed most directly
 * from the pseudo code in the text.
 */
public class RedBlackTree {

    /**
     * RedBlackTree parameter constructor
     */
    public RedBlackTree() {
        this.root = nil; // Sets the initial root of the RBTree to T.nil
    }

    //////////////////////////
    // Class Constants
    //////////////////////////
    private static final String RED = "RED";
    private static final String BLACK = "BLACK";

    //////////////////////////
    // Class Methods
    //////////////////////////

    /**
     * Method used to perform an in order tree walk on a given RBTree,
     * starting at a specified node.
     * 
     * @param T RedBlackTree denoting the tree in which perform the walk.
     * @param x RBNode denoting the node to start the tree walk at.
     *          To traverse the entire tree, this should always be T.root.
     */
    public static void inOrderTreeWalk(RedBlackTree T, RBNode x) {
        // if x is the nil node, then return b/c no other nodes in the tree
        if (x == T.nil) {
            return;
        }
        // recursively calls inOrderTreeWalk on the left child of node x
        inOrderTreeWalk(T, x.left);
        // prints out the value of node x
        System.out.print(x.value + ", ");
        // recursively calls inOrderTreeWalk on the right child of node x
        inOrderTreeWalk(T, x.right);
    }

    ////////////////////////////////
    // Rotation Methods //
    ////////////////////////////////
    /**
     * Method used to rotate a node to the left by changing pointer structure.
     * When doing a left-rotate, we assume that its right child y is not T.nil.
     * x may be any node in the tree whose right child is not T.nil. Makes y
     * the new root of the subtree, x as y's new left child, and y's left child
     * x's right child.
     * 
     * @param T RedBlackTree denoting the tree in which to rotate a node
     * @param x RBNode denoting the node to perform a left rotation on
     */
    public static void leftRotate(RedBlackTree T, RBNode x) {
        RBNode y = x.right; // set y to x's right child
        x.right = y.left; // turn y's left subtree into x's right subtree

        /**
         * if y's left child is not the nil node then set y's left child's
         * parent to be x
         */
        if (y.left != T.nil) {
            y.left.parent = x;
        }
        y.parent = x.parent; // link x's parent to y
        /**
         * if x's parent is the nil node, then set the RBTrees root to y
         */
        if (x.parent == T.nil) {
            T.root = y;
        }
        /**
         * if x is its parents left child, then set x's parents left
         * child to be y
         */
        else if (x == x.parent.left) {
            x.parent.left = y;
        }
        /**
         * otherwise set x's parents right child to be y
         */
        else {
            x.parent.right = y;
        }
        y.left = x; // put x on y's left
        x.parent = y; // set x's parent to y
    }

    ////////// CHECK THE DESCRIPTION FOR THIS METHOD////////

    /**
     * Method used to rotate a node to the right by changing pointer structure.
     * When doing a right-rotate, we assume that its left child y is not T.nil.
     * x may be any node in the tree whose left child is not T.nil. Makes y
     * the new root of the subtree, x as y's new right child, and y's right
     * child x's left child.
     * 
     * @param T RedBlackTree denoting the tree in which to rotate a node
     * @param x RBNode denoting the node to perform a left rotation on
     */
    public static void rightRotate(RedBlackTree T, RBNode x) {
        RBNode y = x.left; // set y to x's left child
        x.left = y.right; // turn y's right subtree into x's left subtree

        /**
         * if y's right child is not the nil node then set y's right child's
         * parent to be x
         */
        if (y.right != T.nil) {
            y.right.parent = x;
        }
        y.parent = x.parent; // link x's parent to y
        /**
         * if x's parent is the nil node, then set the RBTrees root to y
         */
        if (x.parent == T.nil) {
            T.root = y;
        }
        /**
         * if x is its parents right child, then set x's parents right
         * child to be y
         */
        else if (x == x.parent.right) {
            x.parent.right = y;
        }
        /**
         * otherwise set x's parents left child to be y
         */
        else {
            x.parent.left = y;
        }
        y.right = x; // put x on y's right
        x.parent = y; // set x's parent to y
    }

    ////////////////////////////////
    // Insertion Methods //
    ////////////////////////////////
    /**
     * Method used to insert a node into a RBTree
     * 
     * @param T RedBlackTree denoting the tree in which to insert a node
     * @param z RBNode denoting the node to be inserted into the tree
     */
    public static void rBInsert(RedBlackTree T, RBNode z) {
        RBNode y = T.nil; // creates a node y and sets it as the nil node
        RBNode x = T.root; // creates a node x and sets it as the root node
        /**
         * while x is not the nil node, right and left pointers are moved down
         * the tree, going left or right depending on the value of z and x
         */
        while (x != T.nil) {
            y = x; // set y equal to x
            /**
             * if the value of node z is less than the value of node x, set
             * x to be the left child of what it currently is
             */
            if (z.value < x.value) {
                x = x.left;
            }
            /**
             * if the value of node z is not less than the value of node x, set
             * x to be the right child of what it currently is
             */
            else {
                x = x.right;
            }
        }
        z.parent = y; // set z's parent to point to y

        /**
         * if y is the nil node, set the RBTrees root to be z
         */
        if (y == T.nil) {
            T.root = z;
        } else if (z.value < y.value) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = T.nil; // set z's left child to be the nil node
        z.right = T.nil; // set z's right child to be the nil node
        z.color = RED; // set z's color to be red
        // call upon fixup method to restore RBTree properties
        rBInsertFixup(T, z);
    }

    /**
     * Method called upon by rBInsert to restructure the RBTree
     * after a node is inserted to ensure that all RBT Properties are preserved.
     * 
     * @param T RedBlackTree denoting the tree in which to insert a node
     * @param z RBNode denoting the node to be inserted into the tree
     */
    public static void rBInsertFixup(RedBlackTree T, RBNode z) {
        while (z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                RBNode y = z.parent.parent.right;
                if (y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(T, z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(T, z.parent.parent);
                }
            } else {
                RBNode y = z.parent.parent.left;
                if (y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(T, z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(T, z.parent.parent);
                }
            }
        }
        T.root.color = BLACK;
    }

    ////////////////////////////////
    // Deletion Methods //
    ////////////////////////////////
    /**
     * Method used to move subtrees in the RBTree, replaces one subtree as a
     * child of its parent with another subtree.
     * 
     * @param T RedBlackTree denoting the tree in which to delete a node
     * @param u RBNode denoting deleted node
     * @param v RBTree denoting node to change subtrees
     */
    public static void rBTransplant(RedBlackTree T, RBNode u, RBNode v) {
        if (u.parent == T.nil) {
            T.root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    /**
     * Method used to delete a node from a RBT
     * 
     * @param T RedBlackTree denoting the tree in which to delete a node
     * @param z RBNode denoting the node to be deleted in the tree
     */
    public void rBDelete(RedBlackTree T, RBNode z) {
        RBNode x;
        RBNode y = z;
        String yOrigColor = y.color;
        if (z.left == T.nil) {
            x = z.right;
            rBTransplant(T, z, z.right);
        } else if (z.right == T.nil) {
            x = z.left;
            rBTransplant(T, z, z.left);
        } else {
            y = rBTMinimum(z.right);
            yOrigColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rBTransplant(T, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rBTransplant(T, z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOrigColor == BLACK) {
            rBDeleteFixup(T, x);
        }
    }

    /**
     * Method called upon by rBDelete to restructure the RBTree
     * after a node is deleted to ensure that all RBT Properties are preserved.
     * 
     * @param T RedBlackTree denoting the tree in which to delete a node
     * @param x RBNode denoting the node to start fixing Tree at
     */
    public static void rBDeleteFixup(RedBlackTree T, RBNode x) {
        while ((x != T.root) && (x.color == BLACK)) {
            if (x == x.parent.left) {
                RBNode w = x.parent.right;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(T, x.parent);
                    w = x.parent.right;
                }
                if ((w.left.color == BLACK) && (w.right.color == BLACK)) {
                    w.color = RED;
                    x = x.parent;
                } else if (w.right.color == BLACK) {
                    w.left.color = BLACK;
                    w.color = RED;
                    rightRotate(T, w);
                    w = x.parent.right;
                }
                w.color = x.parent.color;
                x.parent.color = BLACK;
                w.right.color = BLACK;
                leftRotate(T, x.parent);
                x = T.root;
            } else {
                RBNode w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(T, x.parent);
                    w = x.parent.left;
                }
                if ((w.right.color == BLACK) && (w.left.color == BLACK)) {
                    w.color = RED;
                    x = x.parent;
                } else if (w.left.color == BLACK) {
                    w.right.color = BLACK;
                    w.color = RED;
                    rightRotate(T, w);
                    w = x.parent.left;
                }
                w.color = x.parent.color;
                x.parent.color = BLACK;
                w.left.color = BLACK;
                leftRotate(T, x.parent);
                x = T.root;
            }
        }
        x.color = BLACK;
    }

    ////////////////////////////////
    // BST Methods //
    ////////////////////////////////
    /**
     * Method used to find the RBNode in the tree with the lowest value
     * Does so by "skiing" down the left of the tree.
     * 
     * @param x RBNode denoting the node to start looking for min at
     * @return RBNode containing the minimum value in the RBTree
     */
    public RBNode rBTMinimum(RBNode x) {
        while (x.left != nil) {
            x = x.left;
        }
        return x;
    }

    /**
     * Method used to find the RBNode in the tree with the highest value
     * Does so by "skiing" down the right of the tree.
     * 
     * @param x RBNode denoting the node to start looking for max at
     * @return RBNode containing the maximum value in the RBTree
     */
    public RBNode rBTMaximum(RBNode x) {
        while (x.right != nil) {
            x = x.right;
        }
        return x;
    }

    /**
     * Method used to find the successor of a given node.
     * 
     * @param x RBNode denoting the node to find the successor of
     * @return RBNode which is the successor of node x
     */
    public RBNode rBTSuccessor(RBNode x) {
        if (x.right != nil) {
            return rBTMinimum(x.right);
        }
        RBNode y = x.parent;
        while ((y != nil) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * Method used to find the predecessor of a given node.
     * 
     * @param x RBNode denoting the node to find the predecessor of
     * @return RBNode which is the predecessor of node x
     */
    public RBNode rBTPredecessor(RBNode x) {
        if (x.left != nil) {
            return rBTMaximum(x.left);
        }
        RBNode y = x.parent;
        while ((y != nil) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * Method used to search the tree for a node iteratively, chose iterative
     * because it will usually run faster than recursive version.
     * 
     * @param x RBNode denoting the node to start your search at.
     *          This node should be T.root when called in order to search the
     *          entire tree.
     * @param k int denoting the value (key) you are searching for in the RBTree
     */
    public RBNode rBTSearch(RBNode x, int k) {
        while ((x != nil) || (k != x.value)) {
            if (k < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    //////////////////////////
    // Instance Variables
    //////////////////////////

    // The root and nil node of the RBT
    private RBNode root;
    private final RBNode nil = new RBNode(Integer.MIN_VALUE, BLACK);

    //////////////////////////
    // Instance Methods
    //////////////////////////
    /**
     * Gets the root node of the RBT
     * 
     * @return RBNode denoting the root node of the tree
     */
    public RBNode getRoot() {
        return root;
    }

    /**
     * Creates a String representation of the tree, showing the structure.
     * 
     * @return String describing an RBTree
     */
    @Override
    public String toString() {
        return "{" + "root=" + root + ", nil=" + nil + ", max=" +
                rBTMaximum(root) + ", min=" + rBTMinimum(root) + "}";
    }

    //////////////////////////
    // Internal Classes
    //////////////////////////

    /**
     * A Red-Black tree node.
     */
    class RBNode {
        RBNode parent = null;
        RBNode left = null;
        RBNode right = null;
        int value;
        String color;

        /**
         * Creates a String representation of a RBNode
         * 
         * @return String describing an RBNode
         */
        public String toString() {
            return "{" + "value=" + value + "color=" + color;
        }

        /**
         * RBNode parameter constructor
         * 
         * @param v int denoting the value to set the RBNode to
         * @param c String denoting the color to set the RBNode to
         */
        RBNode(int v, String c) {
            this.value = v;
            this.color = c;
        }

        /**
         * When called on, this will tell you the height of a specified RBnode.
         * 
         * @return int denoting the height of the RBNode
         */
        int height() {
            int answer = 0;
            if (left == null || right == null) {
                // Leave answer at zero
                // This should only occur with the nil node
            } else {
                // Answer is greater of left or right height, plus one.
                int leftHeight = left.height();
                int rightHeight = right.height();
                answer = leftHeight > rightHeight ? leftHeight : rightHeight;
                answer = answer + 1;
            }
            return answer;
        }
    }

}
