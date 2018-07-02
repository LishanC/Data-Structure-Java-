/**
 * modify the standard stack so that they do not allow duplicate items and 
 * they provide a method to change the priority of a particular element. 
 * @author Lishan Chan
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;

public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T>
	implements NoDupsPrioritizeStackInterface<T> {
	
	public NoDupsPrioritizeArrayStack() {
		super();
	} 
	public NoDupsPrioritizeArrayStack(int initialCapacity) {
		super(initialCapacity);
	} 

	//override the push method which does not allow duplicates.
	@Override
	public void push(T newEntry) 
        {
	    topIndex++;
            if(!isDuplicate(newEntry))
            {
        	if (topIndex >= stack.length) 
        	{
        		doubleArray();
        	}			
        	stack[topIndex] = newEntry;
            }	
	}
	
	//use the help method to check if the element already exists in the stack
	private boolean isDuplicate(T newEntry)
	{
		boolean isDuplicate =false;
		for(int i=0; i<topIndex; i++)
	    {
	        if (newEntry.equals(stack[i]))
	        {
	         	isDuplicate=true;
	         	break;
	        }
	    }
		return isDuplicate;	
	} 
	
        //If invoked with an element currently in the stack, the method moves the element
	//to the top of the stack. If invoked with an element not in the stack, 
	//the method adds the element to the top of the stack 
	public void moveToTop(T entry)
        {
	    boolean found = false;
	    if (!isEmpty())
	    {
		for (int i = 0; i < topIndex; i++)
		{
		     if (entry.equals(stack[i]))
		     {
			 stack[i] = stack[i + 1];
			 stack[i + 1] = entry;
     			found = true;
		    }
		}
		if (!found) 
                {
		    push(entry);
		}
	    }
	}	
  
	//display the element from left to right
	public void display()
       {
	    for (int i = 0; i <= topIndex; i++) 
            {
		System.out.print(stack[i] + ",");
	    }
            System.out.println();
	}
} 
