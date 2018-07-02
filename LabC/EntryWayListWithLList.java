/**
 * A list that only allows the user to access the beginning or ending elements of the list,
 * not any elements from the middle of the list. It implements EntryWayListInterface using LList.
 * Entries begin with 1.
 * @author Lishan Chan
 * @version 1.0
 */

public class EntryWayListWithLList<T> implements EntryWayListInterface<T>
{

    private LList<T> linkedList;

    /** Default constructor
     *
     */

    public EntryWayListWithLList() {
        linkedList = new LList<T>();
    }

    /** Inserts a specific new entry to the beginning of this list at position 1.
     * The list's size increases by 1, and the specific positions of other entries each bump up by 1.
     *
     * @param newEntry object to be inserted at the beginning of this list
     * @return boolean that is true if newEntry is successfully added to the beginning of the list, false otherwise
     */

    public boolean insertHead(T newEntry) {

        linkedList.add(1, newEntry);
        return true;

    }


    /** Inserts a specific new entry to the end of this list.
     * The list's size increases by 1, but the specific positions of other entries are unchanged.
     *
     * @param newEntry object to be inserted at the end of this list
     * @return boolean that is true if newEntry is successfully added to the end of the list, false otherwise
     */

    public boolean insertTail(T newEntry) {

        linkedList.add(linkedList.getLength() + 1, newEntry);
        return true;

    }


    /** Removes the first entry in this list at position 1.
     * The list's size decreases by 1, and the specific positions of other entries each bump down by 1.
     *
     * @return the object that has been removed from the beginning of this list, if removal is successful, or null
     */

    public T deleteHead() {

        return linkedList.remove(1);

    }


    /** Removes the last entry in this list.
     * The list's size decreases by 1, but the specific positions of other entries are unchanged.
     *
     * @return the object that has been removed from the end of this list, if removal is successful, or null
     */

    public T deleteTail() {

        return linkedList.remove(linkedList.getLength());

    }


    /** Prints out all current entries in this list in the order of their positions,
     * starting with position 1.
     *
     */

    public void display() {

        T[] linkedListArray = linkedList.toArray();
        for (T entry : linkedListArray)
            System.out.print(entry + " ");

    }


    /** Checks this list for a specific entry.
     *
     * @param anEntry the object to look for in this list
     * @return an integer representing the first position of anEntry in this list, or -1 if entry not found
     */

    public int contains(T anEntry) {

        if (linkedList.contains(anEntry))
            return linkedList.getPosition(anEntry);
        else
            return -1;

    }


    /** Checks to see if there are entries in this list.
     *
     * @return boolean that is true if there are entries in this list, false otherwise
     */

    public boolean isEmpty() {

        return linkedList.isEmpty();

    }


    /** Checks to see if all positions in this list are occupied by an object.
     *
     * @return boolean that is true if all positions in this list reference an object,
     * false if at least one is null
     */

    public boolean isFull() {

        boolean hasNull = false;

        for (int i = 1; i <= linkedList.getLength(); i++) {
            if (linkedList.getEntry(i) == null)
                hasNull = true;
        }

        return !hasNull;

    }

}




