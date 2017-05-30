import java.util.Set;

public interface MyMapSet {
	public Object put(Object key,Object value);
	//is used to insert an entry in this map.
	
	public Object remove(Object key);
	//is used to delete an entry for the specified key.
	
	public Object get(Object key);
	//is used to return the value for the specified key.
	
	public boolean containsKey(Object key);
	//is used to search the specified key from this map.
	
	public boolean containsValue(Object value);
	//is used to search the specified value from this map.
	
	public Set keySet();
	//returns the Set view containing all the keys.
	
	public Set entrySet();
	//returns the Set view containing all the keys and values.
}