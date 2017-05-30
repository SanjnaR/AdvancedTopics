import java.util.Iterator;

public interface MyHashSet
{
	
	public boolean add(Object y);
	
	public boolean contains(Object x);
	
	public boolean isEmpty();
	
	public int size();
	
	public Iterator iterator();
	
	public boolean remove(Object y);
	
	public String toString();
	
}