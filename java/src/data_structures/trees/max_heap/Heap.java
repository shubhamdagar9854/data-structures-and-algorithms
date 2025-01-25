package data_structures.trees.max_heap;

/**
 * Interface for a Cargo Heap
 * 
 * @author bjornmelin
 */
public interface Heap {
    /**
     * Adds an entry to the heap
     * 
     * @param entry Cargo to add to the Heap
     */
    void add(Cargo entry);

    /**
     * Removes the current Root of the heap
     * 
     * @return the Cargo which was at the root of the heap
     */
    Cargo removeRoot();

    /**
     * Determines if a given target is in the heap or not
     * 
     * @param target Cargo to look for in the heap
     * @return true if target Cargo was in the heap, false otherwise
     */
    boolean contains(Cargo target);

    /**
     * Performs an INORDER, PREORDER and POSTORDER traversal of the Heap
     * 
     * @return a String which contains the output of the 3 traversals
     */
    String toString();
}