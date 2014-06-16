package avltree;

public class ArvoreData {

	private Key key;
	private Object satelliteData;
	
	public ArvoreData(Key key, Object satelliteData) {
		this.key = key;
		this.satelliteData = satelliteData;
	}
	
	public ArvoreData(Key key) {
		this.key = key;
	}
	
	/*
	@Override
	public int compareTo(ArvoreData arg0) {
		return this.key.compareTo(arg0.getKey());
	}
	*/

	@Override
	public String toString() {
		return this.key.toString();
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Object getSatelliteData() {
		return satelliteData;
	}

	public void setSatelliteData(Object satelliteData) {
		this.satelliteData = satelliteData;
	}



}
