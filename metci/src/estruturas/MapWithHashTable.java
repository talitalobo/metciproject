package estruturas;

import java.util.HashMap;

public class MapWithHashTable {
	private HashMap<String,String> map;
	
	public MapWithHashTable(){
		map = new HashMap<String, String>();
	}
	
	public void insert(String key){
		map.put(key, key);
	}
	
	public HashMap<String, String> get(){
		return map;
	}
	
	public boolean exists(String key){
		return map.containsKey(key);
	}

}
