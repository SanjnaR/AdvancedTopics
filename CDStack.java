import java.util.Iterator;
import java.util.Stack;
public class CDStack {
	Stack<String> myStack;
	
	public CDStack() {
		myStack = new Stack<String>();
		
		myStack.push("Future Hearts");
		myStack.push("Life's Not Out to Get You");
		myStack.push("Homesick");
		myStack.push("Science & Faith");
		myStack.push("AM");
		myStack.push("Don't Panic Its Longer Now");
		myStack.push("Infinity on High");
		myStack.push("A Lesson in Romantics");
		myStack.push("Vessel");
	}
	
	//public CDStack(int i)
	
	public String nextCD() {
		return myStack.peek();
	}
	
	public String playNextCD() {
		return myStack.pop();
	}
	
	public void printCDs() {
		//while(myStack.peek() != null)
		while(!myStack.isEmpty()) {
			System.out.println(myStack.pop() + " ");
		}	
	}
	
	public void printCDs2() {
		Iterator<String> i = myStack.iterator();
		while(i.hasNext()) {
			System.out.println(i.next() + " ");
		}
	}
	
	public void printCDs3() {
		for(String x : myStack) {
			System.out.println(x + " ");
		}
	}
	
	public int find(String name) {
		return myStack.search(name);
	}
	
	public static Stack<String> reverse(Stack<String> x) {
	
		Stack<String> revStack = new Stack<String>();
	
		while(!x.empty()){
			revStack.push(x.pop());
		}
		return revStack;
	
		
	}

	public static Stack<String> combine(Stack<String> x, Stack<String> y) {
		Stack<String> newStack = new Stack<String>();
		for(String s : y) {
			newStack.push(s);
		}
		
		for(String s : x) {
			newStack.push(s);
		}
		
		return newStack;
	}
	
//	public static Stack<String> combine2(Stack<String> x, Stack<String> y) {
//		Stack<String> temp = reverse(y);
//		System.out.println(y);
//		while(!temp.isEmpty())
//			x.push(temp.pop());
//		
//		return x;
//	}

	public static Stack<String> alternate(Stack<String> x, Stack<String> y) {
		Stack<String> newStack = new Stack<String>();
		
		Iterator<String> iterX = x.iterator();
		Iterator<String> iterY = y.iterator();
		
		while(iterX.hasNext() && iterY.hasNext()) {
			newStack.push(iterX.next());
			newStack.push(iterY.next());
		}
		
		if(iterX.hasNext()) {
			while(iterX.hasNext()) {
				newStack.push(iterX.next());
			}
		}
		
		if(iterY.hasNext()) {
			while(iterY.hasNext()) {
				newStack.push(iterY.next());
			}
		}
		
		return reverse(newStack);
	}
	
	public static Stack<String> combine3(Stack<String> x, Stack<String> y) {
		Stack<String> temp = reverse(y);
		while(!temp.isEmpty()) {
			x.push(temp.pop());
		}
		
		return x;
	}
	
	//correct
	public static Stack<String> alternate3(Stack<String>  x, Stack<String> y) {
		Stack<String> temp = new Stack<String>();
		
		while(!x.empty() || !y.empty()) {
			if(!x.isEmpty()) {
				temp.push(x.pop());
			}
			if(!y.isEmpty()) {
				temp.push(y.pop());
			}
		}
	return reverse(temp);
	}
	
	public static double getAverage(Stack<Integer> one) {
		double avg = 0;
		double count = 0;
		
		for(Integer i : one) {
			avg += i;
			count++;
		}
		
		return avg / count;
	}

	//remove every other element starting w the top
	public static Stack<String> removeEveryOther(Stack<String> one) {
		Stack<String> ans = new Stack<String>();
		
		while(!one.isEmpty()) {
			one.pop(); //gets rid of one
		
			if(!one.isEmpty()) //removes and puts next one in other stack
				ans.push(one.pop());
		}
		
		Stack<String> temp = new Stack<String>();
		
		while(!ans.isEmpty()) { //putting it in the right order
			temp.push(ans.pop());
		}
		return temp;
		
	}	
	
	public static String convertToBinary(int n) {
		Stack<String> s = new Stack<String>();
		while(n > 0) {
			s.push("" + n % 2);
			n = n/2;
		}
	
		String temp = "";
		while(!s.isEmpty()) {
			temp += s.pop();
		}
	
		return temp;
	}		

	public static void main(String[] args) {
		Stack<String> t = new Stack<String>();
		t.add("A");
		t.add("B");
		t.add("C");
		System.out.println("original" + t);
		//System.out.println("reverse" + reverse(t));
		
		Stack<String> s = new Stack<String>();
		s.add("D");
		s.add("E");
		s.add("F");
		s.add("G");
		s.add("H");
		System.out.println("alternate" + alternate3(t, s));

		Stack<Integer> a = new Stack<Integer>();
		a.push(5);
		a.push(2);
		a.push(15);
		a.push(3);
		System.out.println("average: " + getAverage(a));
		
		Stack<String> r = new Stack<String>();
		r.add("A");
		r.add("B");
		r.add("C");
		r.add("D");
		r.add("E");
		System.out.println("remove every other " + removeEveryOther(r));
		
		//CDStack tc = new CDStack();
		//tc.printCDs(); //top to bottom
		//tc.printCDs2(); //bottom to top
		//System.out.println(tc.myStack); //bottom to top
		//tc.printCDs3(); //bottom to top
		
		System.out.println(convertToBinary(47));
		System.out.println(convertToBinary(120));
		
	}
}
