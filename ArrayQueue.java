import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ArrayQueue implements MyQueue {
	private Object[] data; 

	public ArrayQueue() {
		data = new Object[0];
	}

	@Override
	public boolean empty() {
		return data.length == 0;
	}

	@Override
	public boolean offer(Object item) {
		Object[] temp = new Object[data.length + 1];
		for(int i = 0; i < temp.length - 1; i++) {
			temp[i] =  data[i];
		}
		temp[temp.length - 1] = item;
		data = temp;
		return true;
	}

	@Override
	public Object poll() {
		if(!empty()) {
			Object[] temp = new Object[data.length - 1];
			Object x = data[0];
			for(int i = 0; i < temp.length; i++) {
				temp[i] = data[i + 1];
			}

			data = temp;
			return x;
		}

		return null;

	}

	@Override
	public Object peek() {
		return data[0];
	}

	public void append(ArrayQueue q) {
		Object temp[] = new Object[q.getSize() + data.length];
		
		int index = 0;
		for(int i = 0; i < data.length; i++) {
			temp[index] = data[i];
			index++;
		}
		
		while(!q.empty()) {
			temp[index] = q.poll();
			index++;
		}
		data = temp;

	}

	public static ArrayQueue alternate (ArrayQueue p, ArrayQueue q) {
		ArrayQueue temp = new ArrayQueue();
		
		while(!p.empty() && !q.empty()) {
			temp.offer(p.poll());
			temp.offer(q.poll());
		}
	
		if(!p.empty()) {
			while(!p.empty()) {
				temp.offer(p.poll());
			}
		}
		
		if(!q.empty()) {
			while(!q.empty()) {
				temp.offer(q.poll());
			}
		}
		
		return temp;
	}

	public void reverse() {

	}

	public int getSize() {
		return data.length;
	}

	public String toString() {	
		String s = "";
		for(int i = 0; i < data.length; i++) {
			s += data[i] + " ";
		}

		return s;
	}


	static void arrayQueue()
	{
		ArrayQueue tc = new ArrayQueue();
		System.out.println(tc.offer("quarter"));
		System.out.println(tc.offer("dime"));
		System.out.println(tc.offer("nickel"));
		System.out.println(tc.offer("penny"));
		
		ArrayQueue ab = new ArrayQueue();
		System.out.println(ab.offer("quarter"));
		System.out.println(ab.offer("dime"));
		System.out.println(ab.offer("nickel"));
		System.out.println(ab.offer("penny"));
		System.out.println(alternate(tc, ab));
		
		//tc.append(ab);
		
		
//		
//		System.out.println( "toString() " + tc);
//		System.out.println( "peek() " + tc.peek());
//
//		System.out.println("pop() and isEmpty()");
//		while (!tc.empty())
//			System.out.println(tc.poll());
//		System.out.println();

		
	}

	public static void main(String[] args) {
		arrayQueue();
	}


}
