

public class CircularArrayQueue implements MyQueue{

	private int head;
	private int tail;
	private int theSize;
	private int capacity;
	private Object[] elements;

	public CircularArrayQueue(int capacity) {
		elements = new Object[capacity];
		this.capacity = capacity;
		theSize = 0;
		head = 0;
		tail = 0;

	}

	@Override
	public boolean empty() {
		return theSize == 0;
	}

	@Override
	public boolean offer(Object item) {
		
		
		for(int i = head; i < elements.length; i++){ //NORMAL CASE
			if(elements[i] == null) {
				elements[i] = item;
				return true;
			}
		}
		
		
		for (int i = 0; i < head; i++) { //HEAD
			if(elements[i] == null) {
				elements[i] = item;
				return true;
			}
		}
		
		//DOUBLE CAPCITY
		
				System.out.println("double array");
				Object[] temp = new Object[elements.length * 2];
				
				int index = 0;
				for(int i = head; i < elements.length; i++) {
					temp[index] = elements[i];
					index++;
				}

				for(int j = 0; j < head; j++) {
					temp[index] = elements[j];
					index++;
				}
				
				temp[index] = item;
				head = 0;
				tail = index;
				elements = temp;
				capacity = elements.length;
				theSize++;
				return true;


//return true;

			
		}

		@Override
		public Object poll() {

			Object ret = elements[head];
			elements[head] = null;
			head++;
			capacity--;
			//capacity--;
			return ret;
			
			

//			Object[] temp = new Object[capacity];
//			Object ret = elements[head];
//
//			if(head > tail) {
//				int index = 0;
//				for(int i = head + 1; i < capacity; i++) {
//					temp[index] = elements[i];
//					index++;
//				}
//
//				for(int j = 0; j < tail; j++) {
//					temp[index] = elements[j];
//					index++;
//				}
//
//				tail = index;
//
//			}
//
//			else {
//				int index = 0;
//				for(int i = head + 1; i < capacity; i++) {
//					temp[index] = elements[i];
//					index++;
//				}
//
//			}
//
//			theSize--;
//			elements = temp;
//			capacity = elements.length;
//
//			for(int i = 0; i < elements.length; i++) {
//				if(elements[i] == null) {
//					tail = i-1;
//					break;
//				}
//			}
//			return ret;

		}

		@Override
		public Object peek() {
			return elements[head];
		}

		public String toString() {
			String t = "";
			for(Object x:elements) {
				t += x + " ";
			}
			return t;
		}
		public int getHead() {
			return head;
		}

		public int getTail() {
			return tail;
		}

		public int getSize() {
			return theSize;
		}

		public int getCapacity() {
			return capacity;
		}


		public static void main(String[] args) {
			CircularArrayQueue a = new CircularArrayQueue(10);
			a.offer(1);
			a.offer(2);
			a.offer(3);
			a.offer(4);
			a.offer(5);
			a.offer(6);
			a.offer(7);
			a.offer(8);			
			a.offer(9);
			System.out.println(a);
			System.out.println("NEXT: " +a.poll());
			System.out.println("NEXT: "+a.poll());
			System.out.println("NEXT: "+a.poll());
			System.out.println(a);
			a.offer(10);
			System.out.println("after 10");
			System.out.println(a);
			System.out.println("tail " + a.getTail());
			System.out.println("size" + a.getSize());
			
			a.offer(11);
			System.out.println(a);
			a.offer(12);
			System.out.println(a);
			System.out.println("NEXT: "+a.poll());
			System.out.println(a);
			a.offer(13);
			System.out.println(a);
			a.offer(14);
			System.out.println(a);
			a.offer(15);
			System.out.println(a);
					System.out.println("NEXT: "+a.poll());
					System.out.println(a);
		}

	}
