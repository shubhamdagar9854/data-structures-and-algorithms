package data_structures.linear.deque_priority_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Driver that creates a Deque and Priority Queue and runs through Lecture 13
 * commands
 * 
 * @author bjornmelin
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * CODE FOR RUNNING THROUGH DEQUE
         */
        System.out.println("-----CREATING DEQUE TO RUN THROUGH LECTURE 13 COMMANDS-----");
        Deque MyDeque = new LinkedList(); // Creates a Deque using a linked list

        Object firstElement = MyDeque.peekFirst();
        System.out.println("PEEKING FRONT OF DEQUE: \n" + firstElement + "\n");

        MyDeque.addLast(7); // Adds 7 to the end of the Deque
        System.out.println("ENQUEUED 7 TO END OF DEQUE: \n" + MyDeque + "\n");

        MyDeque.addLast(53); // Adds 7 to the end of the Deque
        System.out.println("ENQUEUED 53 TO END OF DEQUE: \n" + MyDeque + "\n");

        MyDeque.removeFirst(); // Dequeues 7 from the end of the Deque (front of the line)
        System.out.println("DEQUEUED AT THE FRONT OF THE DEQEUE: \n" + MyDeque + "\n");

        MyDeque.push(13);
        System.out.println("PUSHED 13 ONTO THE DEQUE: \n" + MyDeque + "\n");

        MyDeque.push(16);
        System.out.println("PUSHED 16 ONTO THE DEQUE: \n" + MyDeque + "\n");

        Object firstElement1 = MyDeque.peekFirst();
        System.out.println("PEEKING FRONT OF DEQUE: \n" + firstElement1 + "\n");

        MyDeque.pop();
        System.out.println("POPPING FROM DEQUE: \n" + MyDeque + "\n");

        MyDeque.addLast(81); // Adds 7 to the end of the Deque
        System.out.println("ENQUEUED 81 TO END OF DEQUE: \n" + MyDeque + "\n");

        MyDeque.removeFirst(); // Dequeues 7 from the end of the Deque (front of the line)
        System.out.println("DEQUEUED AT THE FRONT OF THE DEQEUE: \n" + MyDeque + "\n");

        MyDeque.pop();
        System.out.println("POPPING FROM DEQUE: \n" + MyDeque + "\n");

        MyDeque.push(12);
        System.out.println("PUSHED 12 ONTO THE DEQUE: \n" + MyDeque + "\n");

        Object firstElement2 = MyDeque.peekFirst();
        System.out.println("PEEKING FRONT OF DEQUE: \n" + firstElement2 + "\n");

        Object lastElement = MyDeque.peekLast();
        System.out.println("PEEKING BACK OF DEQUE: \n" + lastElement + "\n");

        MyDeque.removeLast();
        System.out.println("REMOVED LAST ELEMENT IN DEQUE: \n" + MyDeque + "\n");

        MyDeque.removeLast();
        System.out.println("REMOVED LAST ELEMENT IN DEQUE: \n" + MyDeque + "\n");

        MyDeque.addLast(1); // Adds 7 to the end of the Deque
        System.out.println("ENQUEUED 1 TO END OF DEQUE: \n" + MyDeque + "\n\n\n");

        /**
         * CODE FOR RUNNING THROUGH PRIORITY QUEUE
         */
        System.out.println("-----CREATING PRIORITY QUEUE TO RUN THROUGH LECTURE 13 COMMANDS-----");
        Queue<Package> MyPriorityQueue = new PriorityQueue(); // Creates a Priority Queue

        Package head = MyPriorityQueue.peek();
        System.out.println("PEEKING THE HEAD OF PRIORITY QUEUE:\n" + head + "\n\n");

        Package newEntry = new Package(7, 2);
        MyPriorityQueue.add(newEntry);
        System.out.println("ENQUEUED 7,2 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry1 = new Package(53, 1);
        MyPriorityQueue.add(newEntry1);
        System.out.println("ENQUEUED 53,1 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry2 = new Package(13, 2);
        MyPriorityQueue.add(newEntry2);
        System.out.println("ENQUEUED 13,2 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry3 = new Package(16, 3);
        MyPriorityQueue.add(newEntry3);
        System.out.println("ENQUEUED 16,3 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package firstEntry = MyPriorityQueue.peek();
        System.out.println("PEEKING THE PRIORITY QUEUE:\n" + firstEntry + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry4 = new Package(81, 1);
        MyPriorityQueue.add(newEntry4);
        System.out.println("ENQUEUED 81,1 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry5 = new Package(12, 4);
        MyPriorityQueue.add(newEntry5);
        System.out.println("ENQUEUED 12,4 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package firstEntry1 = MyPriorityQueue.peek();
        System.out.println("PEEKING THE PRIORITY QUEUE:\n" + firstEntry1 + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        MyPriorityQueue.remove();
        System.out.println("DEQUEUED FIRST ENTRY IN PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");

        Package newEntry6 = new Package(1, 2);
        MyPriorityQueue.add(newEntry6);
        System.out.println("ENQUEUED 1,2 INTO THE PRIORITY QUEUE:\n" + MyPriorityQueue + "\n\n");
    }
}