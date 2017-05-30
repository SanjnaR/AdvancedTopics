import java.util.NoSuchElementException;

public class ListIterator implements Iterator{

	private ListNode current;
	private ListNode previous;
	private LinkedList myList;
	private boolean canRemove;
	
	public ListIterator(LinkedList list) {
		myList = list;
		previous = null;
		current = null;
		canRemove = false;
	}
	public Object next() {
		if(myList.isEmpty()) 
			throw new NoSuchElementException("List is empty");
		if(current == null)
			current = myList.getFirst();
		else {
			previous = current;
			current = current.getNext();
		}
		if(current == null)
			throw new NoSuchElementException("No more elemts in this list");
		canRemove = true;
		
		return current.getValue();
	}

	public boolean hasNext() {
		if(myList.isEmpty()) 
			return false;
		else if(current == null) 
			return true;
		else 
			return current.getNext() != null;		
	}

	public void add(Object element) {
		canRemove = false;
		if(current == null) {
			myList.addFirst(element);
			current = myList.getFirst();
		}
		
		else if (current.getNext() == null) {
			ListNode newNode = new ListNode (element, null);
			current.setNext(newNode);
		}
		
		else {
			ListNode newNode = new ListNode(element, current.getNext());
			current.setNext(newNode);
			previous = current;
			current = newNode;
		}
	
	}

	public void remove() {
		if(!canRemove) 
			throw new NoSuchElementException("List is empty");
		
		else {
			previous.setNext(current.getNext());
		}
		
	}

	public void set(Object element) {
		if (myList.isEmpty()) {
			myList.addFirst(element);
		}
		
		else if(current == null) {
			myList.addLast(element);
		}
		
		else {
			current.setValue(element);
		}
		
	}
	
	public String toString() {
		return ("prev" + previous + "curr " + current);
	}
	
	public static void main(String[] args) {
		LinkedList bowl = new LinkedList();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cranberry");
		bowl.addLast("date");
		bowl.addLast("emblic");
		//ListIterator iter1 = bowl.iterator();
		//while()
		
	}

}
