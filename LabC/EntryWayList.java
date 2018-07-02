/**
 * A list that only allows the user to access the beginning or ending elements of the list,
 * not any elements from the middle of the list. It implements EntryWayListInterface using linked DoubleNodes.
 * Entries begin with 1.
 *
 * @author Lishan Chan
 * @version 1.0
 */

public class EntryWayList<T> implements EntryWayListInterface<T> {

    private DoubleNode firstNode;
    private DoubleNode lastNode;
    private int numberOfEntries;


    /** Default constructor
     *
     */

    public EntryWayList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /** 1-arg constructor for chain with 1 DoubleNode
     *
     * @param starterNode first DoubleNode in the chain
     */

    public EntryWayList(DoubleNode starterNode) {
        firstNode = starterNode;
        lastNode = starterNode;
        numberOfEntries = 1;
    }


    /** Inserts a specific new entry to the beginning of this list at position 1.
     * The list's size increases by 1, and the specific positions of other entries each bump up by 1.
     *
     * @param newEntry object to be inserted at the beginning of this list
     * @return boolean that is true if newEntry is successfully added to the beginning of the list, false otherwise
     */

    public boolean insertHead(T newEntry) {

        DoubleNode newNode = new DoubleNode(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.next = firstNode; // add newNode to beginning of chain
            firstNode.previous = newNode; // link first node in chain back to newNode
            firstNode = newNode; // point firstNode to new entry at beginning of chain
        }

        numberOfEntries++;

        return true;

    }


    /** Inserts a specific new entry to the end of this list.
     * The list's size increases by 1, but the specific positions of other entries are unchanged.
     *
     * @param newEntry object to be inserted at the end of this list
     * @return boolean that is true if newEntry is successfully added to the end of the list, false otherwise
     */

    public boolean insertTail(T newEntry) {

        DoubleNode newNode = new DoubleNode(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;
        }

        numberOfEntries++;

        return true;
    }


    /** Removes the first entry in this list at position 1.
     * The list's size decreases by 1, and the specific positions of other entries each bump down by 1.
     *
     * @return the object that has been removed from the beginning of this list, if removal is successful, or null
     */

    public T deleteHead() {

        T removedEntry;

        if (isEmpty()) {
            removedEntry = null;
        } else if (numberOfEntries == 1) {
            removedEntry = (T) firstNode.data;
            firstNode.data = null;
            firstNode.next = null;
            firstNode.previous = null;
            lastNode = firstNode;
            numberOfEntries--;
        } else {
            removedEntry = (T) firstNode.data;
            firstNode.next.previous = null;
            firstNode = firstNode.next;
            numberOfEntries--;
        }

        return removedEntry;

    }


    /** Removes the last entry in this list.
     * The list's size decreases by 1, but the specific positions of other entries are unchanged.
     *
     * @return the object that has been removed from the end of this list, if removal is successful, or null
     */

    public T deleteTail() {

        T removedEntry;

        if (isEmpty()) {
            removedEntry = null;
        } else if (numberOfEntries == 1) {
            removedEntry = (T) lastNode.data;
            lastNode.data = null;
            lastNode.next = null;
            lastNode.previous = null;
            firstNode = lastNode;
            numberOfEntries--;
        } else {
            removedEntry = (T) lastNode.data;
            lastNode.previous.next = null;
            lastNode = lastNode.previous;
            numberOfEntries--;
        }

        return removedEntry;

    }


    /** Prints out all current entries in this list in the order of their positions,
     * starting with position 1.
     *
     */

    public void display() {

        if(isEmpty()) {
            System.out.println("List is empty.");
        } else {
            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] result = (T[]) new Object[numberOfEntries];

            int index = 0;
            DoubleNode currentNode = firstNode;
            while ((index < numberOfEntries) && (currentNode != null)) {
                result[index] = (T) currentNode.data;
                currentNode = currentNode.next;
                index++;
            }

            System.out.print("List contains:");

            for (T element : result) {
                System.out.print(" " + element);
            }

            System.out.println();
        }
    }


    /** Checks this list for a specific entry.
     *
     * @param anEntry the object to look for in this list
     * @return an integer representing the first position of anEntry in this list, or -1 if entry not found
     */

    public int contains(T anEntry) {

        boolean found = false;
        DoubleNode currentNode = firstNode;
        int position = 1;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            }
            else {
                currentNode = currentNode.next;
                position++;
            }
        }

        if (!found)
            position = -1;

        return position;

    }


    /** Checks to see if there are entries in this list.
     *
     * @return boolean that is true if there are no entries in this list, false otherwise
     */

    public boolean isEmpty() {

        if(numberOfEntries == 0)
            return true;
        else
            return false;

    }


    /** Checks to see if all positions in this list are occupied by an object.
     *
     * @return boolean that is true if all positions in this list reference an object,
     * false if at least one is null
     */

    public boolean isFull() {

        DoubleNode currentNode = firstNode;
        boolean foundNull = true;

        for (int position = 1; position <= numberOfEntries; position++) {

            if(currentNode.data == null) {
                foundNull = false;
            } else {
                currentNode = currentNode.next;
            }

        }

        return foundNull;
    }

}

