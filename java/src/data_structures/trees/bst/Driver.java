package data_structures.trees.bst;

/**
 * Tests BST Object
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST myTree = new BST();
        System.out.println(myTree);
        myTree.add(1);
        myTree.add(2);
        myTree.add(3);
        myTree.add(4);
        myTree.add(5);
        myTree.add(6);
        myTree.add(7);
        System.out.println(myTree);
        System.out.println("Is 4 in here?\t" + myTree.contains(4));
        System.out.println("Is 1 in here?\t" + myTree.contains(1));
        System.out.println("Is 6 in here?\t" + myTree.contains(6));
        System.out.println("Is 2 in here?\t" + myTree.contains(2));
        System.out.println("Is 3 in here?\t" + myTree.contains(3));
        System.out.println("Is 5 in here?\t" + myTree.contains(5));
        System.out.println("Is 16 in here?\t" + myTree.contains(16));
        System.out.println("Is 0 in here?\t" + myTree.contains(0));
        System.out.println("\n\n\n");
        myTree.rebalance();
        System.out.println(myTree);
    }
}