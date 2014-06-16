package list;

public class ListaInteirosImpl implements ListaInteiros {

	private int dado = -1;
	private ListaInteirosImpl proximo;
	
	
	/**
	 * verifica se eh vazio
	 */
	@Override
	public boolean isEmpty(){
		boolean var = false;
		
		if (this.proximo == null){
			var = true;
		}
		return var;
	}
	
	
	/**
	 * dah o tamanho da linked list
	 */
	@Override
	public int tamanho() {
		int tamanho = 0;
		
		if (this.proximo != null){
			tamanho = 1 + proximo.tamanho();
		}
		return tamanho;
	}

	
	/**
	 * insere um novo elemento (ver anotacoes :B)
	 */
	@Override
	public void inserir(int numero) {
		
		if (this.proximo == null ){
			this.dado = numero;
			this.proximo = new ListaInteirosImpl();
		} else {
			proximo.inserir(numero);
		}
	}

	
	@Override
	public int procurar(int numero) {
		int saida = -1;
		
		if (this.proximo == null){
			throw new RuntimeException(MSG_INEXISTENTE);
		}
		 
		else{
			if (this.dado == numero){
				saida = this.dado;
			} else {
				saida = proximo.procurar(numero);
			}
		}
		return saida;
	}

	
	@Override
	public void remover(int numero) {
		if (!isEmpty()){
			if (this.dado == numero){
				this.dado = proximo.dado;
				this.proximo = proximo.proximo;
			}
			else {
				proximo.remover(numero);
			}
		}
	}
	
	
	
	@Override
	public ListaInteiros revert() {
		ListaInteiros var = new ListaInteirosImpl();
		
		if (!isEmpty()){
			var = proximo.revert();
			var.inserir(this.dado);
		}
		return var;
	}

	
	@Override
	public int maior() {
		int var = Integer.MIN_VALUE;
		
		if (!isEmpty())
			if (this.dado > var){
				int maiorResto = proximo.maior();
				if (maiorResto > this.dado){
					var = maiorResto;
				} else {
					var = dado;
				}
			}
			else {
				var = proximo.maior();
			}
		return var;
	}

	
	
	@Override
	public int menor() {
		int var = Integer.MAX_VALUE;
		
		if (!isEmpty())
			if (this.dado < var){
				int maiorResto = proximo.maior();
				if (maiorResto < this.dado){
					var = maiorResto;
				} else {
					var = dado;
				}
			}
			else {
				var = proximo.maior();
			}
		return var;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public ListaInteirosImpl getProximo() {
		return proximo;
	}

	public void setProximo(ListaInteirosImpl proximo) {
		this.proximo = proximo;
	}

}