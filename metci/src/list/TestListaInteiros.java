package list;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class TestListaInteiros {

	private ListaInteiros lista = new ListaInteirosImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testClass(){
		Assert.assertTrue(lista.isEmpty());
		Assert.assertEquals(0, lista.tamanho());
		for (int i = 1; i <= 100; i++) {
			lista.inserir(i*5);
			Assert.assertEquals(i, lista.tamanho());
		}
		
		Assert.assertEquals(250, lista.procurar(250));
		Assert.assertEquals(100, lista.revert().tamanho());
		Assert.assertEquals(500, lista.maior());
		Assert.assertEquals(5, lista.menor());
		
		
		for (int i = 100; i >= 1; i--) {
			lista.remover(i*5);
			Assert.assertEquals(i-1, lista.tamanho());
		}
		Assert.assertEquals(0, lista.revert().tamanho());
		
	}

}
