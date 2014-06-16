package skiplist;

public interface SkipList {

	/**
	 * Insere no novo no na skip list contendo como dado satelite a propria chave. 
	 * A altura do novo no eh aleatoria.
	 * 
	 */
	void insert(int key, Object newValue);

	/**
	 * Insere no novo no na skip list contendo como dado satelite a propria chave. 
	 * A altura do novo no NAO eh aleatoria, ams informada como parametro.
	 * 
	 */
	void insert(int key, Object newValue, int height);
	
	/**
	 * Remove um no da skip list que contem a chave dada.
	 * 
	 */
	void remove(int key);

	/**
	 * 
	 * @return retorna a altura do maior no da skip list;
	 */
	int getHeight();

	/**
	 * Pesquisa um no na skip list dada uma chave.
	 * 
	 */
	SkipNode search(int key);

	/**
	 * @return os nos (em ordem) da skip list e os seus "forwards" entre parenteses;
	 */
	String printSkipList();
}
