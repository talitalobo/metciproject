package binarytree;

public interface ArvoreBinaria<T,K extends Comparable<K>> {
	public abstract boolean isEmpty();
	public abstract boolean isLeaf();
	public abstract int altura();
	public abstract boolean pesquisar(K chave);
	public abstract void inserir(T novoElemento);
	public abstract T maximo();
	public abstract T minimo();
	public abstract void remover(K chave);
	public abstract void preOrdem();
	public abstract void ordem();
	public abstract void posOrdem();
	public int countElements();
}
