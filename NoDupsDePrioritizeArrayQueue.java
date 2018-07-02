/**
 * modify the standard  queue so that they do not allow duplicate items and 
 * they provide a method to change the priority of a particular element. 
 * @author Lishan Chan
 * @version 1.0
 */

import java.util.Arrays;

public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T> 
	implements NoDupsDePrioritizeQueueInterface<T> {


	public NoDupsDePrioritizeArrayQueue() {
		super();
	} 
	public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
		super(initialCapacity);
	} 
 
	
	@Override
	//override the enqueue method which does not allow duplicates.
	public void enqueue(T newEntry)
	{
		if(!isDuplicate(newEntry))
		{
		    if (isArrayFull()) 
		       doubleArray(); 
    
		    backIndex = (backIndex + 1) % queue.length;
		    queue[backIndex]=newEntry;
		}
	} 
	
	//use the help method to check if the element already exists in the queue
	private boolean isDuplicate(T newEntry)
	{
		boolean isDuplicate=false;
		for(int i=0; i<queue.length; i++)
		{
			if(newEntry.equals(queue[i]))
			{
			    isDuplicate=true;
			    break;
			}
		}
		return isDuplicate;
	}

	//If an element currently in the queue, the method moves the element
	//to the back of the queue. If invoked with an element not in the queue, 
	//the method adds the element to the back of the queue
	public void moveToBack(T entry) 
        {
	     if (!isEmpty())
             {
		  boolean found = false;
		  for (int i =0; i < backIndex; i++) 
                  {
			if (entry.equals(queue[i]))
                        {
			   queue[i] = queue[i + 1];
			   queue[i + 1] = entry;			
		        }
	         }
	     if(!found);
		enqueue(entry);
	     }
	}

	public void display() 
        {
	    for(int i = 0; i<queue.length; i++)
            {
		System.out.print(queue[i] + " ");
			
	    }
            System.out.println();
	} 
}
