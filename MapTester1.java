import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
public class MapTester1 {
	
	

	public static void main(String[] args) {
		HashMap<String, String> favoriteColors = new HashMap<String, String>();
		favoriteColors.put("Juliet", "PINK");
		favoriteColors.put("Eve", "PINK");
		favoriteColors.put("Eve", "BLUE");
		favoriteColors.put("Romeo", "GREEN");
		favoriteColors.put("Adam", "BLUE");
		favoriteColors.put("Adam", "PINK");
		favoriteColors.put("Adam", "GREEN");
		
//		System.out.println("remove " + favoriteColors.remove("Juliet"));
		System.out.println("? " + favoriteColors.put("Adam", "YELLOW"));
		
		
//		favoriteColors.put("Eve", "PINK");
//		favoriteColors.put("Eve", "BLUE");
//		
		
		System.out.println("? " + favoriteColors.put("John", "MAGENTA"));
		System.out.println("? " + favoriteColors.put("Adam", "YELLOW"));

		System.out.println(favoriteColors);
		
		Set<String> keySet = favoriteColors.keySet();
		Iterator<String> iter = keySet.iterator();
		System.out.println();
		System.out.println("COLORS");
		
		while(iter.hasNext()) {
			String key = iter.next();
			String value = favoriteColors.get(key);
			System.out.println(key + "->" + value);
		}
		
		System.out.println();
		System.out.println("COLORS");
		for(String x : favoriteColors.keySet())
			System.out.println(x + " " +favoriteColors.get(x));
	
		System.out.println(favoriteColors.entrySet());
		System.out.println(favoriteColors.remove("REMOVE" + "Adam"));
		System.out.println(favoriteColors.remove("MAdam"));
		
//		System.out.println("KEY SET " + favoriteColors.keySet());
		System.out.println(favoriteColors);
		
		System.out.println("Values " + favoriteColors.values());
		
		Set x = favoriteColors.keySet();
		System.out.println("TC" + x);

		
		Iterator<String> iter2 = x.iterator();
		
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}

	}

}
