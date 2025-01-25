package data_structures.trees.max_heap;

/**
 * Driver to test Cargo Heap
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MaxHeap myHeap = new MaxHeap();

        System.out.println("------------- TESTING ADD -------------\n");
        System.out.println("-------- Add 4 --------");
        myHeap.add(new Cargo("HERE", 4));
        System.out.println(myHeap);

        System.out.println("-------- Add 5 --------");
        myHeap.add(new Cargo("HERE", 5));
        System.out.println(myHeap);

        System.out.println("-------- Add 8 --------");
        myHeap.add(new Cargo("HERE", 8));
        System.out.println(myHeap);

        System.out.println("-------- Add 10 --------");
        myHeap.add(new Cargo("HERE", 10));
        System.out.println(myHeap);

        System.out.println("-------- Add 15 --------");
        myHeap.add(new Cargo("HERE", 15));
        System.out.println(myHeap);

        System.out.println("\n\n------------- TESTING REMOVE ROOT -------------\n");
        myHeap.removeRoot();
        System.out.println(myHeap);

        myHeap.removeRoot();
        System.out.println(myHeap);

        myHeap.removeRoot();
        System.out.println(myHeap);

        myHeap.removeRoot();
        System.out.println(myHeap);

        myHeap.removeRoot();
        System.out.println(myHeap);

        myHeap.removeRoot();
        System.out.println(myHeap);

        System.out.println("------------- TESTING ADD AFTER REMOVING -------------\n");
        System.out.println("-------- Add 17 --------");
        myHeap.add(new Cargo("HERE", 17));
        System.out.println(myHeap);

        System.out.println("-------- Add 1 --------");
        myHeap.add(new Cargo("HERE", 1));
        System.out.println(myHeap);

        System.out.println("-------- Add 11 --------");
        myHeap.add(new Cargo("HERE", 11));
        System.out.println(myHeap);
    }
}