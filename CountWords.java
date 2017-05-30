import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/****
counts number of words and unique words in a file
prints frequency of most common words
****/
public class CountWords {
	static ArrayList<WordTally> words;
	public  final String FINAL_FILE = "dream.txt";
	Scanner inFile;
	int count;		
	
	public CountWords() {
		words = new ArrayList<WordTally>();
		count = 0;
		File file = new File(FINAL_FILE);
		try{
			 inFile = new Scanner(file);
			while(inFile.hasNext()) {
				String temp = inFile.next();
					count++;
				temp = temp.toLowerCase();
				temp = temp.replaceAll("[;,:.'!?\"-]", "");
				if(temp.length() > 0) {
					insert(temp);
				}
			}
			inFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
	}
	
	public void totalWords() {
		System.out.println("The total number of words is " + count);
	}
	
	public void uniqueWords() {
		int count = words.size();
		System.out.println("the number of unique words is "+ count);
	}
	

	public static void insert(String t) {
		if(words.size() == 0) {
			WordTally s = new WordTally(t);
			words.add(s);
			return;
		}
		

		for(int i = 0; i < words.size(); i++) {
			if(words.get(i).getWord().equals(t)) {
				words.get(i).increase();
				return;
			}
		}
		
		WordTally s = new WordTally(t);
		words.add(s);		
	}
	
	public void display() {
		for(int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i).toString());
		}
	}
	
	private void sort() {
		Collections.sort(words);
	}
	
	public void mostFrequentWords(int num) {
		sort();
		System.out.println("The most frequent words are: ");
		for(int i = 0; i < num; i++) {
			System.out.println(words.get(i).getWord() + " " + words.get(i).getCount());
		}
	}

		public static void main(String[]args) {
			CountWords c = new CountWords();
			c.totalWords();
			c.uniqueWords();
			c.mostFrequentWords(30);
	
		}

}
