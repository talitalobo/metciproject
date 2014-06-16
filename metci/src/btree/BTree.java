package btree;

public interface BTree {

	/**
	 * Procura na �rvore B pelo valor passado como par�metro. O m�todo retorna
	 * -1 se n�o achou o elemento, se achar, retorna a quantidade de acessos ao
	 * disco at� achar o valor procurado.
	 * 
	 * @param valor
	 *            O valor desejado na busca
	 *@return -1 se n�o achar, x se achar, sendo x o n�mero de acessos ao disco
	 *         at� achar o valor procurado.
	 */
	public int buscar(int valor);

	/**
	 * Insere um valor na �rvore B. O m�todo retorna o n�mero de acessos ao
	 * disco necess�rios para localizar um espa�o vazio para a inser��o do
	 * valor.
	 * 
	 * @param valor
	 *            O valor a ser inserido
	 *@return x, sendo x o n�mero de acessos ao disco necess�rias para a
	 *         inser��o do valor.
	 */
	public int inserir(int valor);

	/**
	 * Retorna o n�mero de elementos percorridos para encontrar o elemento
	 * desejado. Diferente do m�todo buscar(), que retorna o n�mero de acessos
	 * ao disco, este retorna o n�mero de elementos(n�o n�s) que foram
	 * percorridos at� achar o elemento. O pr�prio elemento n�o entra na
	 * contagem.
	 * 
	 * @param valor
	 *            O valor desejado na busca
	 *@return -1 se n�o achar, x se achar, sendo x o n�mero de elementos
	 *         percorridos at� achar o elemento, n�o incluindo ele.
	 */
	public int getQuantidadePercorridos(int valor);

	/**
	 * M�todo chamado quando for necess�rio criar um novo n� na �rvore
	 * 
	 * @param grau
	 *            O grau da �rvore
	 */
	public void criaNode(int grau);
	

}
