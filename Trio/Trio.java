/**
 * Lab A: Generics
 * CS 111C
 * Lishan Chan
 */

import java.util.*;

public class Trio<T extends Comparable<? super T>> implements Comparable<Trio <T>>
{
	//instance variables
	private T item1, item2, item3;
	
	//constructor with 3 parameters
	public Trio(T item1, T item2, T item3)
	{
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	//getters
	public T getItem1() 
	{
		return item1;
	}
	
	public T getItem2() 
	{
		return item2;
	}
	
	public T getItem3() 
	{
		return item3;
	}

	//setters
	public void setItem1(T item1) 
	{
		this.item1 = item1;
	}

	public void setItem2(T item2) 
	{
		this.item2 = item2;
	}

	public void setItem3(T item3) 
	{
		this.item3 = item3;
	}
	
	//toString method
	@Override
	public String toString()
	{
		return "This Trio contains " + item1.toString() + 
				" in position 1, " + item2.toString() + 
				" in position 2, and " + item3.toString() + 
				" in position 3.";
	}
	
	//contains method that determines whether the Trio
	//contains the item passed in as the parameter
	public boolean contains(Object other)
	{
		T otherItem = (T) other;
		return (otherItem.equals(item1) ||
				otherItem.equals(item2) ||
				otherItem.equals(item3));
	}
	
	//sameItems method that checks whether all 3
	//items are equal, if not return false
	public boolean sameItems()
	{
		return (item1.equals(item2) &&
				item2.equals(item3) &&
				item1.equals(item3));
	}
	
	//equals method that returns true if the current
	//Trio has the same 3 items as another Trio
	@Override
	public boolean equals(Object other)
	{
		if (other instanceof Trio<?>)
		{
			Trio<?> otherTrio = (Trio<?>) other;
			
			ArrayList<T> trioList = new ArrayList<T>();
			trioList.add(item1); 
			trioList.add(item2); 
			trioList.add(item3);
			Collections.sort(trioList);

			ArrayList<T> otherTrioList = new ArrayList<T>();
			otherTrioList.add((T) otherTrio.item1); 
			otherTrioList.add((T) otherTrio.item2);
			otherTrioList.add((T) otherTrio.item3);
			Collections.sort(otherTrioList);
		
			return (trioList.equals(otherTrioList));
		}
		else
		{
			return false;
		}
	}

	//helper method to find the smallest item in any Trio
	private T smallestItem(Trio someTrio)
	{
		ArrayList<T> trioList = new ArrayList<T>();
		trioList.add((T) someTrio.getItem1());
		trioList.add((T) someTrio.getItem2());
		trioList.add((T) someTrio.getItem3());
		Collections.sort(trioList);
		return trioList.get(0);
	}
	
	//extra credit
	//compareTo method that orders Trio objects by the
	//smallest item in each Trio
	@Override
	public int compareTo(Trio<T> otherTrio) 
	{
		return smallestItem(this).compareTo(smallestItem(otherTrio));
	}
}
