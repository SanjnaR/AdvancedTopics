import java.util.ArrayList;

public class LiverTransplantQueue implements PriorityQueue

{
	private ArrayList<Patient> data; 

	public LiverTransplantQueue() {
		data = new ArrayList<Patient>(); //size 0
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
	public void add(Object x) {
		data.add((Patient) x);
	}

	@Override
	public Object poll() {
		Patient currentPatient = data.get(0);
		int currentMax = data.get(0).getPriority();
		int index =  0;
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).getPriority() > currentMax) {
				currentMax = data.get(i).getPriority();
				currentPatient = data.get(i);
				index = i;
			}
		}
		
		return data.remove(index);
	}
	
	@Override
	public Object peek() {
		return data.get(0);
	}

	@Override
	public int size() {
		return data.size();
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < data.size(); i++) {
			s += data.get(i).getName() + " " + data.get(i).getPriority()  + ", ";
		}
		
		return s;
	}	

	public static void main(String[] args) 

	{

		LiverTransplantQueue pq= new LiverTransplantQueue();

		pq.add(new Patient("Smith",3));

		pq.add(new Patient("Chen",2));

		pq.add(new Patient("Jones",3));

		pq.add(new Patient("Wong",3));

		pq.add(new Patient("Gupta",2));

		pq.add(new Patient("Garcia",1));

		pq.add(new Patient("Brown",3));

		System.out.println("The list is");
		
		System.out.println(pq);  
		
		System.out.println();

		while(pq.size()>0)

		{
			System.out.println("The next patient for the liver transplant is");
			System.out.println(pq.poll());
		}
	}


}
