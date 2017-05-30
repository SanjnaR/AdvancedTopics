import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayListMapSet implements MyMapSet {
	private ArrayList<Object> key; 
	private ArrayList<Object> value; 
	@Override
	public Object put(Object key, Object value) {
		Object temp = null;
		
		for(int i = 0; i < this.key.size(); i++) {
			if(this.key.get(i) == key) {
				return this.value.get(i);
			}
		}
		this.value.add(value);
		this.key.add(key);
		return null;
		
	}

	@Override
	public Object remove(Object key) {
		Object temp;
		for(int i = 0; i < this.key.size(); i++) {
			if(this.key.get(i) == key) {
				this.key.remove(i);
				return value.get(i);
			}
		}
		return null;
	}

	@Override
	public Object get(Object key) {
		Object temp;
		for(int i = 0; i < this.key.size(); i++) {
			if(this.key.get(i) == key) {
				return value.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(Object key) {
		for(int i = 0; i < this.key.size(); i++) {
			if(this.key.get(i) == key) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for(int i = 0; i < this.value.size(); i++) {
			if(this.value.get(i) == value) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set keySet() {
		HashSet<Object> data = new HashSet<Object>();
		for(int i = 0; i < this.key.size(); i++) {
			data.add(key.get(i));
		}
		return data;
		
	}

	@Override
	public Set entrySet() {
		HashSet<String> data = new HashSet<String>();
		for(int i = 0; i < this.key.size(); i++) {
			data.add(key.get(i) + "=" + value.get(i));
		}
		return data;
	}

}
