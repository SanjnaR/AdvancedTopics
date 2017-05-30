import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinFlip {
	static ArrayList<WordTally> words;
	public  final String FINAL_FILE = "dream.txt";
			
	
	public CoinFlip() {
		words = new ArrayList<WordTally>();

		File file = new File(FINAL_FILE);
		try{
			Scanner inFile = new Scanner(file);
			while(inFile.hasNext()) {
				String temp = inFile.next();
				temp = temp.toLowerCase();
				temp = temp.replaceAll("[;,:.?\"-]", "");
				//inserting
			}
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		//System.out.println(file);
	}
	
}
