package skiplist;

public class SkipNode {

	//a chave do root eh Integer.MIN_VALUE e a do NIL eh Integer.MAX_VALUE
	protected int key;
	protected int height;
	protected Object satteliteData;
	protected SkipNode[] forward;
	
	public SkipNode(int key, int height, Object satelliteData){
		this.key = key;
		this.height = height;
		this.satteliteData = satelliteData;
		this.forward = new SkipNode[height];
	}
	
	public int getKey() {
		return key;
	}
	
	public SkipNode[] getStkipNodes() {
		return forward;
	}
	
	
		
}
