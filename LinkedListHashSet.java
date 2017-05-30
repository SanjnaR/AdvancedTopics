
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Stack;

import Sets.Coin;

public class LinkedListHashSet implements MyHashSet {

	private LinkedList<Object> data; 

	public LinkedListHashSet() {
		data = new LinkedList<Object>();

	}

	

	@Override
	public boolean add(Object y) {
		int newHashCode = y.hashCode();
		ListIterator iterA = data.listIterator();		
		while(iterA.hasNext()) {
			if(newHashCode == iterA.next().hashCode())
				return false;
		}
		
		data.add(y);
		return true;
	}


	@Override
	public boolean contains(Object x) {
		ListIterator iterA = data.listIterator();		
		if(data.getFirst() == x)
			return true;

		while(iterA.hasNext()) {
			if(iterA.next() == x)
				return true;
		}

		if(data.getLast() == x) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public Iterator iterator() {
		ListIterator iterA = data.listIterator();
		return (Iterator) iterA;
	}


	@Override
	public boolean remove(Object y) {
		return data.remove(y);

	}
	
	public String toString() {
		return data.toString();
//		String s = "";
//		ListIterator iterA = data.listIterator();
//		
//		
//		while(iterA.hasNext()) {
//			s += iterA.next();
//		}
//		
//		return s;

	}

		public static void main(String[] args) {

		LinkedListHashSet bowl = new LinkedListHashSet();

		bowl.add("apple");
		bowl.add("strawberry");
		bowl.add("pear");
		bowl.add("cherry");
		bowl.add("peach");
		bowl.add("lime");
		bowl.add("apple");
		System.out.println("Size: " + bowl.size());
		System.out.println(bowl);

		System.out.println("Remove apple? " + bowl.remove("apple"));
		System.out.println("Remove lime? " + bowl.remove("lime"));
		System.out.println("Remove kiwi? " + bowl.remove("kiwi"));
		System.out.println(bowl);
		System.out.println("Iterator");
		Iterator pointer = bowl.iterator();
		while (pointer.hasNext())
		System.out.print(pointer.next() + " ");

		System.out.println();
		System.out.println("Contains apple? " + bowl.contains("apple"));
		System.out.println("Contains lime? " + bowl.contains("lime"));
		System.out.println("Contains pear? " + bowl.remove("pear"));
		}


}
