package avltree;

public class Key implements Comparable<Key>{
	private int key;

	public Key(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(Key o) {
		int resp = -1;
		if(this.key == o.getKey()){
			resp = 0;
		}else if(this.key > o.getKey()){
			resp = 1;
		}
		return resp;
	}

	@Override
	public boolean equals(Object arg0) {
		boolean resp = false;
		if(arg0 instanceof Key){
			resp = this.key == ((Key) arg0).getKey();
		}
		return resp;
	}

	@Override
	public String toString() {
		return String.valueOf(this.key);
	}
	
	
}
