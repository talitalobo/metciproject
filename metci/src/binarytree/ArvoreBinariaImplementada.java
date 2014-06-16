package binarytree;

import avltree.ArvoreData;
import avltree.Key;

public class ArvoreBinariaImplementada implements ArvoreBinaria<ArvoreData, Key> {

	private ArvoreData dado;
	private ArvoreBinariaImplementada filhoEsquerda;
	private ArvoreBinariaImplementada filhoDireita;
	
	@Override
	public boolean isEmpty() {
		return (this.filhoEsquerda == null && this.filhoDireita == null);
	}

	@Override
	public boolean isLeaf() {
		boolean resp = false;
		if(!isEmpty()){
			resp = this.filhoDireita.isEmpty() && this.filhoEsquerda.isEmpty(); 
		}
		return resp;
	}

	@Override
	public int altura() {
		int resp = -1;
		if (!isEmpty()) {
			int alturaFilhoEsquerda = this.filhoEsquerda.altura();
			int alturaFilhoDireita = this.filhoDireita.altura();
			resp = 1 + maior(alturaFilhoEsquerda, alturaFilhoDireita);
		}
		return resp;
	}
	
	private int maior(int valor1, int valor2) {
		int resultado = valor1;
		if (valor2 > valor1) {
			resultado = valor2;
		}
		return resultado;
	}

	@Override
	public boolean pesquisar(Key chave) {
		boolean resp = false;
		if (!isEmpty()) {
			if (this.dado.getKey().equals(chave)) {
				resp = true;
			} else {
				if (this.dado.getKey().compareTo(chave) < 0) {
					resp = this.filhoEsquerda.pesquisar(chave);
				} else {
					resp = this.filhoDireita.pesquisar(chave);
				}
			}
		}
		return resp;
	}

	@Override
	public void inserir(ArvoreData novoElemento) {
		if (isEmpty()) {
			this.dado = novoElemento;
			this.filhoEsquerda = new ArvoreBinariaImplementada();
			this.filhoDireita = new ArvoreBinariaImplementada();
		} else {
			if (!this.dado.equals(novoElemento)) {
				if (novoElemento.getKey().compareTo(this.dado.getKey()) < 0) {
					this.filhoEsquerda.inserir(novoElemento);
				} else {
					this.filhoDireita.inserir(novoElemento);
				}
			}
		}
	}

	@Override
	public ArvoreData maximo() {
		ArvoreData maximo = this.dado;
		if (!this.isEmpty()) {
			ArvoreData maximoFilhoDireita = this.filhoDireita.maximo();
			if (maximoFilhoDireita != null && maximoFilhoDireita.getKey().compareTo(maximo.getKey()) > 0) {
				maximo = maximoFilhoDireita;
			}
		}
		return maximo;
	}

	@Override
	public ArvoreData minimo() {
		ArvoreData minimo = this.dado;
		if (!this.isEmpty()) {
			ArvoreData minimoFilhoEsquerda = this.filhoEsquerda.minimo();
			if (minimoFilhoEsquerda  != null && minimoFilhoEsquerda.getKey().compareTo(minimo.getKey()) < 0) {
				minimo = minimoFilhoEsquerda;
			}
		}
		return minimo;
	}

	@Override
	public void remover(Key chave) {
		if (!this.isEmpty()) {
			if (this.isLeaf()) {
				if (this.dado.getKey().equals(chave)) {
					this.dado = null;
					this.filhoEsquerda = null;
					this.filhoDireita = null;
				}
			} else {
				if (this.dado.getKey().equals(chave)) {
					// localizar o menor descendente a direita
					ArvoreBinariaImplementada menorDescendenteDireita = 
						this.menorDescendenteDireita();
					if(menorDescendenteDireita != null){ //tem descendente a direita distinto dele
						this.dado = menorDescendenteDireita.getDado();
						menorDescendenteDireita.remover(menorDescendenteDireita.getDado().getKey());
					}else{ //procura maior descendente a esquerda que vai existir nesse caso
						   //se nao existisse this seria folha e ja resolvia acima
						ArvoreBinariaImplementada maiorDescendenteEsquerda = 
							this.maiorDescendenteEsquerda();
						if(maiorDescendenteEsquerda != null){ //tem descendente a esquerda
							this.dado = maiorDescendenteEsquerda.getDado();
							maiorDescendenteEsquerda.remover(maiorDescendenteEsquerda.getDado().getKey());
						}
					}
				} else {
					if (chave.compareTo(this.dado.getKey()) < 0) {
						this.filhoEsquerda.remover(chave);
					} else {
						this.filhoDireita.remover(chave);
					}
				}
			}
		}
		
	}

	@Override
	public void preOrdem() {
		if (!isEmpty()) {
			visita(this);
			this.filhoEsquerda.preOrdem();
			this.filhoDireita.preOrdem();
		}
	}

	public String preOrdemImpressao() {
		String resp = "";
		if (!isEmpty()) {
			resp = resp + this.getDado().toString() + " ";
			resp = resp + this.filhoEsquerda.preOrdemImpressao();
			resp = resp + this.filhoDireita.preOrdemImpressao();
		}
		return resp;
	}

	@Override
	public void ordem() {
		if (!isEmpty()) {
			this.filhoEsquerda.ordem();
			visita(this);
			this.filhoDireita.ordem();
		}
	}

	@Override
	public void posOrdem() {
		if (!isEmpty()) {
			this.filhoEsquerda.posOrdem();
			this.filhoDireita.posOrdem();
			visita(this);
		}
	}
	

	@Override
	public int countElements() {
		int resp = 0;
		if(!isEmpty()){
			resp = 1 + this.filhoEsquerda.countElements() + this.filhoDireita.countElements();
		}
		return resp;
	}
	
	
	
	@Override
	public String toString() {
		String resp = "null";
		if(this.dado != null){
			resp = this.dado.toString(); 
		}
		return resp;
	}

	protected void visita(ArvoreBinariaImplementada no) {
		System.out.print(no.getDado().toString() + " ");
	}
	protected ArvoreBinariaImplementada maiorDescendenteEsquerda() {
		ArvoreBinariaImplementada resp = null;
		if (!isEmpty()) {
			if (!this.filhoEsquerda.isEmpty()) {
				resp = this.filhoEsquerda.maiorDescendenteDireita();
			}
		}
		return resp;
	}
	protected ArvoreBinariaImplementada maiorDescendenteDireita() {
		ArvoreBinariaImplementada resp = null;
		if (!isEmpty()) {
			if (!this.filhoDireita.isEmpty()) {
				resp = this.filhoDireita.maiorDescendenteDireita();
			} else {
				resp = this;
			}
		}
		return resp;
	}
	
	protected ArvoreBinariaImplementada menorDescendenteDireita() {
		ArvoreBinariaImplementada resp = null;
		if (!isEmpty()) {
			if (!this.filhoDireita.isEmpty()) {
				resp = this.filhoDireita.menorDescendenteEsquerda();
			}
		}
		return resp;
	}

	protected ArvoreBinariaImplementada menorDescendenteEsquerda() {
		ArvoreBinariaImplementada resp = null;
		if (!isEmpty()) {
			if (!this.filhoEsquerda.isEmpty()) {
				resp = this.filhoEsquerda.menorDescendenteEsquerda();
			} else {
				resp = this;
			}
		}
		return resp;
	}
	
	public ArvoreData getDado() {
		return dado;
	}

	public void setDado(ArvoreData dado) {
		this.dado = dado;
	}

	public ArvoreBinariaImplementada getFilhoEsquerda() {
		return filhoEsquerda;
	}

	public void setFilhoEsquerda(ArvoreBinariaImplementada filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}

	public ArvoreBinariaImplementada getFilhoDireita() {
		return filhoDireita;
	}

	public void setFilhoDireita(ArvoreBinariaImplementada filhoDireita) {
		this.filhoDireita = filhoDireita;
	}

	
	public static void main(String[] args) {
		ArvoreBinariaImplementada raiz = new ArvoreBinariaImplementada();
		raiz.inserir(new ArvoreData(new Key(8)));
		raiz.inserir(new ArvoreData(new Key(4)));
		raiz.inserir(new ArvoreData(new Key(12)));
		raiz.inserir(new ArvoreData(new Key(2)));
		raiz.inserir(new ArvoreData(new Key(6)));
		raiz.inserir(new ArvoreData(new Key(5)));
		raiz.inserir(new ArvoreData(new Key(15)));
		raiz.inserir(new ArvoreData(new Key(17)));
		raiz.inserir(new ArvoreData(new Key(14)));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(8));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(14));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(15));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(17));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(12));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(6));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(4));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(5));
		raiz.preOrdem();
		System.out.println("");
		raiz.remover(new Key(2));
		raiz.preOrdem();
		System.out.println("");
	}
	
}
