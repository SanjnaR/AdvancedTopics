import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountLetters {
	
	
	public static void tallyPrint(String phrase) {
		HashMap<String, Integer> letters = new HashMap<String, Integer>();
		Set<String> keys = letters.keySet();
		int startIndex = 0;
		for(int i = 0; i < phrase.length(); i++) {
			if(!(keys.contains(phrase.substring(i, i+1)))) {
				letters.put(phrase.substring(i, i+1), 1);
			}
			else {
				String s = phrase.substring(i, i+1);
				letters.put(s,letters.get(s) + 1);
			}
		}
	
//
//		String restPhrase = phrase.substring(startIndex, phrase.length());
//		while(restPhrase.length() > 0) {
//			if(restPhrase.substring(startIndex, startIndex+1) == " ")
//					startIndex++;
//			
//			if(!(keys.contains(restPhrase.substring(startIndex, startIndex+1)))) {
//				String s = restPhrase.substring(startIndex, startIndex+1);
//				letters.put(s,letters.get(s));
//		
//			}
//			else {
//				String s = restPhrase.substring(startIndex, startIndex+1);
//				letters.put(s,letters.get(s) + 1);
//			}
//		}
//		
		Set<String> keySet = letters.keySet();
		Iterator<String> iter = keySet.iterator();
		System.out.println();
		
		while(iter.hasNext()) {
			String key = iter.next();
			Integer value = letters.get(key);
			System.out.println(key + "->" + value);
		}
		
	}
	
	
	public static void main(String[] args) {
		tallyPrint("my nose runs and my feet smell");
	}

}
