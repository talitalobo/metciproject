package estruturas;

import java.util.TreeMap;

public class MapWithTreeMap implements AbstractMap{
	private TreeMap<String,String> map;
	
	public MapWithTreeMap(){
		map = new TreeMap<String,String>();
	}
	
	public void insert(String key){
		map.put(key, key);
	}
	
	public TreeMap<String, String> get(){
		return map;
	}
	
	public boolean exists(String key){
		return map.containsKey(key);
	}

	@Override
	public int size() {
		return map.size();
	}

}
