package skiplist;

/**
 * Laboratorio de Estrutura de Dados
 * @author talitalm - 20921059
 * Estrutura: SkipList
 */

import javax.management.RuntimeErrorException;

public class SkipListImpl2 implements SkipList {

	protected SkipNode root;
	protected int level;
	protected int maxLevel;
	protected double probability = 0.5;
	private static SkipNode NIL;
	private final int PROXIMO = 0;
	
	public SkipListImpl2(int maxLevel, boolean useMaxLevelAsInitialLevel) {
		if(useMaxLevelAsInitialLevel){
			this.level = maxLevel;
		}else{
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, 1, new Integer(Integer.MAX_VALUE));
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o no NIL
	 * Caso teseja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializaco com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
		for (int i  = 0; i < maxLevel; i ++) {
			root.forward[i] = NIL;
		}
	}
	
	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,Object) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		double random = Math.random(); // funcao geradora
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}
	
	@Override
	public void insert(int key, Object newValue) {
		SkipNode[] values = new SkipNode[this.maxLevel]; // array de nodos
		SkipNode no = this.root; // estabalece o novo no como raiz
		
		for (int index = level -1; index >= 0; index--) {
			while (no.forward[index].key < key) { // compara o no que esta variando com a chave passada
				no = no.forward[index];
			}
			values[index] = no;
		}
		no = no.forward[PROXIMO];
		
		if (no.key == key) {
			no.satteliteData = newValue;
		}
		
		else {
			int altura = randomLevel();
			if (altura > this.level) {
				for (int i = this.level + 1; i >= altura; i--) {
					values[i] = this.root;
				}
				this.level = altura;
			}
			SkipNode noAux = new SkipNode(key, altura, newValue);
			for (int i = 0; i < altura; i++) {
				noAux.forward[i] = values[i].forward[i];
			}
		}
	}

	
	
	/*void insert(int, Object, int height) = caso o height 
	seja menor que o maxLevel, insere na lista. 
	Senao retorna um RuntimeException(“Nivel excedido”).*/
	
	@Override
	public void insert(int key, Object newValue, int height) throws RuntimeException {
		
		if (height < maxLevel) {
			SkipNode node = this.root;
			SkipNode[] values = new SkipNode[maxLevel];
			
			for (int index = level -1; index >= 0; index--) {
				while (node.forward[index].key < key) {
					node = node.forward[index];
				}
				values[index] = node;
			}
			node = node.forward[PROXIMO];
			if (node.key == key) {
				node.satteliteData = newValue;
			} else {
				if (height > this.level) {
					for (int i = this.level; i >= height; i--) {
						values[i] = this.root;
					}
					 for (int i = 0; i < height; i++) {
                         values[i] = this.root;
                 }
					 this.level = height;
				}
				SkipNode noAInserir = new SkipNode(key, height, newValue);
                for (int i = 0; i < height; i++){
                        noAInserir.forward[i] = values[i].forward[i];
                        values[i].forward[i] = noAInserir;
                }
			}
		} else {
			throw new RuntimeException("Nivel excedido"); //
		}
	}

	/*remove(int key) = remove o nó da lista 
	se existe ou retorna uma 
	RuntimeException(“No inexistente”) caso contrario.*/
	
	
	@Override
	public void remove(int key)throws RuntimeException {
		SkipNode node = this.root;
		SkipNode[] values = new SkipNode[maxLevel];

	}
	
	
	/*int getHeight() = retorna a altura do no com 
	o maior nivel da lista (nao o com maior chave!). 
	O metodo deve ter a menor complexidade possivel!!!! 
	Preciso varrer toda a lista em busca do nó 
	com maior altura? Respondam a essa pergunta e saberao 
			qual a complexidade desse metodo.*/
	

	@Override
	public int getHeight() {
		int altura = getHeightAux(root);
		return altura;
	}

	private int getHeightAux(SkipNode nodo) {
		int maxHeight = 0;
		
		if (!(nodo == null)) {
			if (nodo.height > maxHeight) {
				int ash = getHeightAux(nodo.forward[PROXIMO]);
			}
		}
		return maxHeight;
	}
	
	
	/*SkipNode search(int key) = retorna 
	o no se encontrar ou uma 
	RuntimeException(“No inexistente”) caso contrario.*/
	
	
	@Override
	public SkipNode search(int key) throws RuntimeException {
		SkipNode noProcurado = this.root;
		for (int i = level - 1; i >= 0; i --) {
			while (noProcurado.forward[i].key < key) {
				noProcurado = noProcurado.forward[i];
			}
		}
		noProcurado = noProcurado.forward[PROXIMO];
		if (noProcurado.key ==  key) {
			return noProcurado;
		} else {
			throw new RuntimeException("No inexistente");
		}
	}

	@Override
	public String printSkipList() {
		 SkipNode x = this.root;
	        String toReturn = "";
	        while ( x != NIL ){
	            if ( x == this.root ){
	                toReturn += "<ROOT";
	            }
	            else{
	                toReturn += " <"+x.key;
	            }
	            toReturn += ","+x.height+">(";
	            for ( int i=0; i<x.forward.length; i++ ){
	                toReturn += ( x.forward[i] != null ? ( i > 0 ? "," : "" )+( x.forward[i] != NIL ? x.forward[i].key : "NIL" ) : "") ;
	            }
	            toReturn += ")";
	            x = x.forward[0];
	        }
	        return toReturn;
	    }
		
		//return printLocal(root);
	//}
	
	private String printLocal(SkipNode nodo) {
		String print = "";
		
		if (!(nodo == null)) {
			if (nodo == root) {
				print += "<ROOT," + maxLevel + ">" + "(" + "NIL" + ")" ;
			} else {
				print += " <" + nodo.satteliteData + "," + nodo.height + ">" + "(" + nodo.key +")" + " ";
			}
			printLocal(nodo.forward[PROXIMO]);
		}
		
		return print;
	}
	
	

}
