package estruturas;

import java.util.ArrayList;
import java.util.List;

public class MapWithList implements AbstractMap{
    List<String> keys;
    List<String> values;
    
    public MapWithList(){
    	keys = new ArrayList<String>();
    	values = new ArrayList<String>();
    }
    
    public void insert(String key){
    	keys.add(key);
    	values.add(key);
    }
    
    public boolean exists(String key){
    	return keys.contains(key);
    	
    }
    
    public int size(){
    	return keys.size();
    }
}
