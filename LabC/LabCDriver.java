// Lishan Chan
// CS 111C: Lab C
// LabCDriver.java: Driver for Lab C and Extra Credit
// To test EntryWayListWithLList instead of EntryWayList, comment in and out lines 38 and 41.

/* Create a driver program to test your implementation (18 points).
The driver program will operate from the client perspective. Your driver program should:

display an empty list
add five entries to the list- some at the head and some at the tail
display the list
remove the first entry
remove the last entry
display the list
test to see if elements are in the list (test one element that is in the list and one that is not)
remove the last three elements in the list
try to remove an element from the empty list
*/

/**
 * Driver program for Lab C.
 * Tests two implementations of EntryWayListInterface:
 * 1. EntryWayList
 * 2. EntryWayListWithLList
 *
 * To test EntryWayListWithLList instead of EntryWayList, comment in and out lines 38 and 41.
 *
 * @author Jacquelyn Cheng
 * @author Sharon Gong
 * @author Lishan Chan
 * @version 1.0
 */

public class LabCDriver {

    public static void main(String[] args) {

        EntryWayList<String> entryList = new EntryWayList<String>();

//        TO TEST EXTRA CREDIT: Comment out line 38 and uncomment line 41.
//        EntryWayListWithLList<String> entryList = new EntryWayListWithLList<>();

        // display an empty list
        entryList.display();

        // add five entries to the list- some at the head and some at the tail
        entryList.insertHead("Blue"); // Blue
        entryList.insertHead("Orange"); // Orange Blue
        entryList.insertTail("Purple"); // Orange Blue Purple
        entryList.insertHead("Red"); // Red Orange Blue Purple
        entryList.insertTail("Black"); // Red Orange Blue Purple Black

        // display the list
        System.out.println("Order should be: Red Orange Blue Purple Black");
        entryList.display();

        // remove the first entry
        System.out.println(entryList.deleteHead() + " was removed");

        // remove the last entry
        System.out.println(entryList.deleteTail() + " was removed");

        // display the list
        System.out.println("Order should be: Orange Blue Purple");
        entryList.display();

        // test to see if elements are in the list (check one that is and one that is not)
        int position;

        position = entryList.contains("Blue");

        if (position == -1)
            System.out.println("Blue not found");
        else
            System.out.println("Blue found at position " + position);

        position = entryList.contains("Green");

        if (position == -1)
            System.out.println("Green not found");
        else
            System.out.println("Green found at position " + position);

        // remove the last three elements from the list
        System.out.println("Removed: " + entryList.deleteTail());
        System.out.println("Removed: " + entryList.deleteHead());
        System.out.println("Removed: " + entryList.deleteTail());

        // try to remove an element from the empty list
        System.out.println("Removed: " + entryList.deleteHead());

        // test isFull method
        entryList.insertHead("Blue"); // Blue
        entryList.insertHead("Orange"); // Orange Blue
        entryList.insertTail(null); // Orange Blue null
        entryList.insertHead("Red"); // Red Orange Blue null
        entryList.insertTail("Black"); // Red Orange Blue null Black

        System.out.println("List full? Should be false: " + entryList.isFull());

        entryList.deleteTail(); // Red Orange Blue null
        entryList.deleteTail(); // Red Orange Blue

        System.out.println("List full? Should be true: " + entryList.isFull());

    }



}


