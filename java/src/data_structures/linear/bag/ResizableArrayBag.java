package data_structures.linear.bag;

import java.util.Arrays;

/**
 * A class that implements a bag of objects by using an array. Implements the Union, Equals, Difference, and Intersection Methods for additional bags.
 * @author bjornmelin
 */
public final class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag; // Cannot be final due to doubling
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param initialCapacity The integer capacity desired.
     */
    public ResizableArrayBag(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[initialCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        initialized = true;
    }

    /**
     * Creates a bag containing given entries.
     *
     * @param contents An array of objects.
     */
    public ResizableArrayBag(T[] contents)
    {
        this();
        for (int i = 0; i < contents.length; i++) 
        {
            add(contents[i]);
        }
        initialized = true;
    }

    /**
     * Used in the add() method. This tests the entry for duplicates in the bag.
     * @param newEntry : T denoting a possible entry to the bag
     * @return boolean denoting whether it is okay or not to add this entry to the bag, 
     * true if entry already is a duplicate, false otherwise
     */
    public boolean checkDuplicate(T newEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (newEntry == bag[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if addition is successful, false if duplicate found.
     */
    public boolean add(T newEntry)
    {
        checkInitialization();
        if (isArrayFull()) {
            doubleCapacity();
        }

        if (checkDuplicate(newEntry)) {
            return false;
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray()
    {
        checkInitialization();

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry)
    {
        checkInitialization();
        int counter = 0;

        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry)
    {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove()
    {
        checkInitialization();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry)
    {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    // Locates a given entry within the array bag.
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    // Removes and returns the entry at a given index within the array.
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];          // Entry to remove
            int lastIndex = numberOfEntries - 1;
            bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
            bag[lastIndex] = null;             // Remove reference to last entry
            numberOfEntries--;
        }
        return result;
    }

    // Returns true if the array bag is full, or false if not.
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    }

    // Doubles the size of the array bag.
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds "
                    + "allowed maximum of " + MAX_CAPACITY);
        }
    }

    // Throws an exception if receiving object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
        {
            throw new SecurityException("Uninitialized object used "
                    + "to call an ArrayBag method.");
        }
    }

    /**
     * Equals method to see if 2 bags are equal.  
     * To be equal, the Bags must have the same number of elements and have the same element values inside both Bags.
     * Order of the elements is NOT important.
     * @param newBag A bag that is to be tested against the original bag
     * @return boolean denoting whether the two bags are equal or not
     */
    public boolean equals(ResizableArrayBag<T> newBag) 
    {
        if (!(newBag instanceof ResizableArrayBag)) {
            return false;
        }
        if (!(bag.length == newBag.getCurrentSize())) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            if (!newBag.contains(bag[i])) {
                return false;
            }
        }
        return true;
    }

    /** 
     * Creates a new bag that combines the contents of this bag and anotherBag.
     * @param anotherBag The bag that is to be compared to.
     * @return A combined bag.
     */
    public BagInterface<T> union(BagInterface<T> anotherBag)
    {
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }

        int maxSize = Math.max(numberOfEntries, anotherBag.getCurrentSize());
        BagInterface<T> output = new ResizableArrayBag<>();
        
        for(int i = 0; i < maxSize; i++)
        {
            if(maxSize == numberOfEntries)
            {
                output.add(bag[i]);
                if(!output.contains(anotherBag.toArray()[i]))
                {
                    output.add(anotherBag.toArray()[i]);
                }
            }
            else
            {
                if(i < numberOfEntries)
                {
                    output.add(bag[i]);
                }
                if(!(output.contains(anotherBag.toArray()[i])))
                {
                    output.add(anotherBag.toArray()[i]);
                }
            }
        }
        return output;
    }
    
    /**
     * Creates a new bag that contains those objects that are present in both this bag
     * and anotherBag.
     * @param anotherBag The bag that is to be compared.
     * @return A combined bag.
     */
    public BagInterface<T> intersection(BagInterface<T> anotherBag)
    {
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }

        if(bag.equals(anotherBag))
        {
            return anotherBag;
        }

        int minSize = Math.min(numberOfEntries, anotherBag.getCurrentSize());
        BagInterface<T> output = new ResizableArrayBag<>();
        
        for(int i = 0; i < minSize; i++)
        {
            if(anotherBag.contains(bag[i]))
            {
                output.add(bag[i]);
            } 
        }
        return output;
    }

    /**
     * Creates a new bag of objects that appear in either bag but not both.
     * @param anotherBag The bag that is to be compared.
     * @return A new bag containing the symmetric difference.
     */
    public BagInterface<T> difference(BagInterface<T> anotherBag)
    {
        if(!(anotherBag instanceof ResizableArrayBag))
        {
           return null;
        }
 
        int maxSize = Math.max(numberOfEntries, anotherBag.getCurrentSize());
        BagInterface<T> differenceBag = new ResizableArrayBag<>();
         
        for(int i = 0; i < maxSize; i++)
        {
            if(maxSize == numberOfEntries)
            {
                if(!anotherBag.contains(bag[i]))
                {
                    differenceBag.add(bag[i]);
                }
                if(i < anotherBag.getCurrentSize())
                {
                    if(!this.contains(anotherBag.toArray()[i]))
                    {
                        differenceBag.add(anotherBag.toArray()[i]);
                    }
                }
            }
            else
            {
                if(!this.contains(anotherBag.toArray()[i]))
                {
                    differenceBag.add(anotherBag.toArray()[i]);
                }  
                if(i < numberOfEntries)
                {
                    if(!anotherBag.contains(bag[i]))
                    {
                        differenceBag.add(bag[i]);
                    }
                }
            }
        }
        return differenceBag;
    }
}