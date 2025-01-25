package data_structures.linear.deque_priority_queue;

/**
 * A Package
 * Used for data inside of Priority Queue
 * 
 * @author bjornmelin
 */
public class Package implements Comparable {

    private int data;
    private int priority;

    public Package(int inData, int inPriority) {
        data = inData;
        priority = inPriority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Object o) {
        return getPriority() - ((Package) o).getPriority();
    }

    @Override
    public String toString() {
        return "{" + data + ", " + priority + "}";
    }
}