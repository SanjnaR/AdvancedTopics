import java.util.LinkedList;
import java.util.ListIterator;

public class Fruits {
	LinkedList<String> bowl;
	
	public Fruits() {
		bowl = new LinkedList<String>();
		//insertB("apple");
		bowl.addFirst("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("lime");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
	}
	
	public void displayFruit(){
		System.out.println(bowl);
	}
	
	public void displayFruit2(){
		for(String t : bowl) {
			System.out.println(t);
		}
	}
	
	public void displayFruit3(){
		ListIterator<String> iter1 = bowl.listIterator();
		while(iter1.hasNext())
			System.out.println(iter1.next());
	}
	
	public void testIterator() {
		ListIterator<String> tc = bowl.listIterator();
		tc.remove();
	}
	
	public void displayEveryOtherFruit() {
		ListIterator<String> iter1 = bowl.listIterator();
		while(iter1.hasNext()) {
			iter1.next();
			if(iter1.hasNext()) {
				System.out.println(iter1.next());
			}
			else 
				return;
		}
	}
	
	public void displayReverse() {
		ListIterator<String> iter1 = bowl.listIterator();
		
		while(iter1.hasNext()) {
			iter1.next();
		}
		
		while(iter1.hasPrevious()) {
			System.out.println(iter1.previous());
			//iter1.previous();
		}
	}
	
	public void removeEveryOtherFruit() {
			ListIterator<String> iter1 = bowl.listIterator();
			while(iter1.hasNext()) {
				iter1.next();
				iter1.remove();
				if(iter1.hasNext()) {
					iter1.next();
				}
			}
	}
	
	public void removeLastTwoFruit() {
		bowl.removeLast();
		bowl.removeLast();
	}
	
	public void removeLastTwoFruit2() {
		ListIterator<String> iter1 = bowl.listIterator();
		while(iter1.hasNext()) {
			iter1.next();
		}
		if(iter1.hasPrevious()) {
			iter1.previous();
			iter1.remove();
		}
		if(iter1.hasPrevious()) {
			iter1.previous();
			iter1.remove();
		}
	}
	
	public void deleteByFirstLetter(String firstLett) {
		ListIterator<String> iter1 = bowl.listIterator();
		while(iter1.hasNext()) {
			if(iter1.next().substring(0, 1).equals(firstLett)) {
				iter1.remove();
			}
		}
	}
	
	public void insertInOrder(String fruit) {
		ListIterator<String> iter1 = bowl.listIterator();
		while(iter1.hasNext()) {
			if(iter1.next().compareTo(fruit) > 0) {
				iter1.previous();
				iter1.add(fruit);
				return;
			}
		}
		
		iter1.add(fruit);
	}
	
	public void merge (Fruits other) {
		ListIterator<String> iter2 = other.bowl.listIterator();
		
		while(iter2.hasNext()) {
			insertInOrder(iter2.next());
		}
	
	
	}
	
	
	public static void main(String[] args) {
		Fruits f1 = new Fruits();
		f1.displayFruit();
		f1.insertInOrder("blueberry");
		f1.displayFruit();
		
		
		Fruits f2 = new Fruits();
		f1.merge(f2);
		f1.displayFruit();
	}
	
}
