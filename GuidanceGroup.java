import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.TreeSet;

public class GuidanceGroup {
	private TreeSet<SatStudent> group;
	
	public GuidanceGroup() {
		group = new TreeSet<SatStudent>();
		load();
	}
	
	
	
	public void load(){
		File file = new File("SATData.txt");
		try
		{
			Scanner inFile = new Scanner(file);
			while(inFile.hasNext())
			{
				String name = inFile.next();
				int math = Integer.parseInt(inFile.next());	
				int verbal = Integer.parseInt(inFile.next());
				int writing = Integer.parseInt(inFile.next());
				SatStudent one = new SatStudent(name, math, verbal, writing);
			//	System.out.println(one);
				add(one);
			}

			inFile.close();
		}catch(FileNotFoundException e){
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
	}

	
	public void add(SatStudent s) {
		 group.add(s);

	}

	public void display() {
		Iterator<SatStudent> iter = group.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
	
	public double average() {
		double avg = 0;
		int count = 0;
		Iterator<SatStudent> iter = group.iterator();
		while(iter.hasNext()) {
			avg += iter.next().getTotal();
			count++;
		}
		return avg / count;
	}
	
	
//	public String getMin() {
//		group.
//	}
//	public String getMax() {
// 
//	}
	
		public static void main(String[] args) {
		GuidanceGroup gr = new GuidanceGroup();
		gr.display();
	}


}
