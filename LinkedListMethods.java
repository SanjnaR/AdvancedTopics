import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMethods {
	
	//return new linked list a and the end of b
	public static LinkedList<String> append(LinkedList<String> a, LinkedList<String> b) {
		ListIterator<String> iterA = a.listIterator();
		ListIterator<String> iterB = b.listIterator();
		
		while(iterA.hasNext() && iterB.hasNext()) {
			iterA.add(iterB.next());
		}
		
		if(iterB.hasNext()) {
			a.addLast(iterB.next());
		}		
		return a;
	}
	
	public static LinkedList<String> delete(LinkedList<String> a, String s) {
		ListIterator<String> iterA = a.listIterator();
		while(iterA.hasNext()) {
			String current = (String) iterA.next();
			if(s.equals(current)) {
				iterA.previous(); //does the same thing when removed
				iterA.remove(); //removes the thing at the last next/previous
			}
		}
		return a;
	}
	
	public static void display(LinkedList<String> a) {
		for(String s: a) {
			System.out.println(s);
		}
	}
	
	//return a LL of alternating values
	public static LinkedList<String> merge(LinkedList<String> a, LinkedList<String> b) {
		ListIterator<String> iterA = a.listIterator();
		ListIterator<String> iterB = b.listIterator();
		
		while(iterA.hasNext() && iterB.hasNext()) {
			iterA.add(iterB.next());
			iterA.next();
			//iterB.next();
		}
		
		if(iterB.hasNext()) {
			a.addLast(iterB.next());
		}		
		return a;
	}
	

	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("1");
		list2.add("3");
		list2.add("5");
		list2.add("7");
		list2.add("9");
		
		list.add("2");
		list.add("4");
		list.add("6");
		list.add("8");
		list.add("10");
		
		
		System.out.println(merge(list, list2));
		
		System.out.println(delete(list, "5"));
		
	}
	
}
