package avltree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import binarytree.ArvoreBinariaImplementada;


public class TestArvoreAVL {

	private ArvoreAVL raiz;
	private static final int ELEMENTOS = 70;
	
	@Before
	public void setUp() throws Exception {
		raiz = new ArvoreAVLImpl();
		for (int i = 0; i < ELEMENTOS; i++) {
			raiz.inserir(new ArvoreData(new Key(i)));
		}
	}
	
	@Test
	public void testInserir() {
		//elemetos ja foram previamente inseridos na arvore
		Assert.assertEquals(ELEMENTOS, raiz.countElements());
		System.out.println(((ArvoreBinariaImplementada) raiz).preOrdemImpressao());
	}

	@Test
	public void testRemover() {
		Assert.assertEquals(ELEMENTOS, raiz.countElements());
		System.out.println(((ArvoreBinariaImplementada) raiz).preOrdemImpressao());
		raiz.remover(new Key(4));
		Assert.assertEquals(ELEMENTOS-1, raiz.countElements());
		System.out.println(((ArvoreBinariaImplementada) raiz).preOrdemImpressao());
	}

	@Test
	public void testAltura() {
		int h = raiz.altura();
		//usando conversao tudo pra base 10 porque Math.log considera como base o numero 'e'
		int logN = (int)(Math.log10(ELEMENTOS)/Math.log10(2));
		Assert.assertEquals(true, (h <= logN) && (logN <= (h + 1)));
	}

}
