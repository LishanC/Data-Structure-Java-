/**
An interfae for the ADT list. Entries in a list have positions that begin with 1.
@author Lishan Chan
@version 1.0
*/

public interface EntryWayListInterface<T>
{
      /** see whether the new entry insert to the first of the list
       @param newEntry an object that need to be inserted
       @return true if the oject was insertd to the beginning of the list, or false if not */
       public boolean insertHead(T newEntry);
     
      /** see whether the new entry insert to the end of the list
       @param newEntry The object that need to be inserted
       @return true if the object was inserted to the end of the list, or false if not */
       public boolean insertTail(T newEntry);

      /** delete the first object of the list
       @return the first object of the list that has been delete */
       public T deleteHead();
       
      /** delete the last object of the list
       @return the last object of the list that has been deleted */
       public T deleteTail() ;
      
      /** display all the entries in the list */
       public void display();

      /** get the position of the anEntry
       @param anEntry is the desired object
       @return The position of entries currently in the list. */
       public int contains(T anEntry) ;

      /** see whether this list is empty.true if empty, if not false. */
       public boolean isEmpty();

      /** see whether this list is full. true if full, otherwise false. */
       public boolean isFull();
}

