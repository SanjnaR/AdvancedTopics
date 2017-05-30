import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ArrayListStack implements MyStack {
	private ArrayList<Object> data; 
	
	public ArrayListStack() {
		data = new ArrayList<Object>(); //size 0
	}
	
	@Override
	public Object push(Object item) {
		data.add(0, item);
		return item;
	}

	@Override
	public Object pop() {
		if(data.isEmpty())
			throw new NoSuchElementException("Can't remove from an empty list");
		return data.remove(0);
	}

	@Override
	public Object peek() {
		if(data.isEmpty())
			throw new NoSuchElementException("Can't remove from an empty list");
		return data.get(0);
	}

	@Override
	public boolean isEmpty() {
		if(data.size() == 0) {
			return true;
		}
		
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public int search(Object a) {
		if(data.isEmpty())
			throw new NoSuchElementException("Can't remove from an empty list");
		for(int i = data.size() - 1; i >= 0; i--) {
			if(data.get(i) == a)
				return i + 1;
		}
		
		return -1;
	}
	
	public String toString() {	
		String s = "";
		for(int i = data.size() - 1; i >= 0; i--) {
			s += data.get(i) + " ";
		}
		
		return s;
	}
	
	static void arrayListStack()
	{
	ArrayListStack tc = new ArrayListStack();
	System.out.println(tc.push("quarter"));
	System.out.println(tc.push("dime"));
	System.out.println(tc.push("nickel"));
	System.out.println(tc.push("penny"));
	System.out.println( "toString() " + tc);
	System.out.println( "peek() " + tc.peek());
	System.out.println( "search for dime " + tc.search("dime"));
	System.out.println( "search for euro " + tc.search("euro"));
	System.out.println( "Size " + tc.size());
	System.out.println("pop() and isEmpty()");
	while (!tc.isEmpty())
	System.out.println(tc.pop());
	
	System.out.println();
	
	Stack ab = new Stack();
	System.out.println(ab.push("quarter"));
	System.out.println(ab.push("dime"));
	System.out.println(ab.push("nickel"));
	System.out.println(ab.push("penny"));
	System.out.println( "toString() " + ab);
	System.out.println( "peek() " + ab.peek());
	System.out.println( "search for dime " + ab.search("dime"));
	System.out.println( "search for euro " + ab.search("euro"));
	System.out.println( "Size " + ab.size());
	System.out.println("pop() and isEmpty()");
	while (!ab.isEmpty())
	System.out.println(ab.pop());
	}
	
	public static void main(String[] args) {
		arrayListStack();
	}

}
