import java.io.File;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;

public class ClubMap {
	ArrayList<Student> stud = new ArrayList<Student>();
	HashMap<String, ArrayList<Student>> club;
	public ClubMap() {
		club = new HashMap<String, ArrayList<Student>>();
		load();

	}
	public void load() {
		File file = new File("student.txt");
		try
		{
			Scanner inFile = new Scanner(file);
			while(inFile.hasNext())
			{
				String lastName = inFile.next();

				String firstName = inFile.next();

				String id = inFile.next();

				String club = inFile.next();

				Student s = new Student(lastName, firstName, id);

				addInOrder(s, club);
			}

			inFile.close();
		}catch(FileNotFoundException e){
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
	}

	public void addNoOrder(Student s, String clubName) {
		ArrayList temp = club.get(clubName);
		//System.out.println("TEMP" + temp);
		if(temp == null) {
			temp = new ArrayList<Student>();
			temp.add(s);
			club.put(clubName, temp);
		}

		else {
			temp.add(s);
			club.put(clubName, temp);
		}
	}
	

	public void addInOrder(Student s, String clubName) {
		ArrayList<Student> temp = club.get(clubName);
		//System.out.println("TEMP" + temp);
		if(temp == null) {
			temp = new ArrayList<Student>();		
			temp.add(s);
			club.put(clubName, temp);
		}

		else {	
			for(int i = 0; i < temp.size(); i++) {
				Student t = temp.get(i);
				if(s.getLastName().compareTo(t.getLastName()) < 0) {
					temp.add(i, s);
					club.put(clubName, temp);
					return;
				}
			}
			temp.add(s);
			club.put(clubName, temp);
			
		}
	}
	
	public ArrayList<Student> getStudents(String clubName) {
		return club.get(clubName);
	}
	




	public void display() {

		HashMap<String, ArrayList<Student>> temp = club;


		Set<String> keySet = temp.keySet();

		Iterator<String> iterA = keySet.iterator();
		//Iterator<String> iter = keySet.iterator();

		while(iterA.hasNext()) {
			String key = iterA.next();
			ArrayList<Student> value = temp.get(key);
			System.out.println(key + ":" + value);
		}

	}



	public static void main(String[] args) throws FileNotFoundException {
		ClubMap cm = new ClubMap();
		cm.display();
		System.out.println("MATH" + cm.getStudents("Math"));

	}

}
