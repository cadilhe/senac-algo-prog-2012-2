package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaPilhaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbstractMinhaPilha() {
		
		MinhaPilhaImp<Object> obj = null;
		
		try {
			obj = criarMinhaPilha();
			Assert.assertNotNull(obj);
		} catch (Exception e) {
			fail("Não deveria lançar exceção");
		}
	}

	private <T> MinhaPilhaImp<T> criarMinhaPilha() {
		
		MinhaPilhaImp<T> resultado = null;
		
		resultado = new MinhaPilhaImp<T>();
		
		return resultado;
	}

	@Test
	public void testPush() {
		
		MinhaPilhaImp<String> obj = null;
		String valor = null;
		String valorPosicaoZero = null;

		obj = criarMinhaPilha();
		valor = "valor";
		obj.push(valor);
		valorPosicaoZero = consultarValorTopo(obj);
		Assert.assertEquals(valorPosicaoZero, valor);
	}

	private <T> T consultarValorTopo(MinhaPilhaImp<T> obj) {
		
		T resultado = null;
		MinhaLista<T> lista = null;
		
		lista = obj.getMinhaLista();
		resultado = lista.buscar(0);

		return resultado;
	}


	@Test
	public void testPop() {
		
		MinhaPilhaImp<String> obj = null;
		String prefixo = null;
		int quantidade = 0;
		String resultado = null;
		String esperado = null;

		prefixo = "string-";
		quantidade = 10;
		obj = criarPilhaStringComElementos(prefixo, quantidade);
		for (int i = quantidade - 1; i >= 0; i--) {
			esperado = elementoParaIndice(prefixo, i);
			resultado = obj.pop();
			Assert.assertEquals(esperado, resultado);
		}
	}

	private MinhaPilhaImp<String> criarPilhaStringComElementos(String prefixo,
			int quantidade) {
		
		MinhaPilhaImp<String> resultado = null;
		MinhaLista<String> lista = null;
		String valor = null;
		
		resultado = criarMinhaPilha();
		lista = resultado.getMinhaLista();
		for (int i = 0; i < quantidade; i++) {
			valor = elementoParaIndice(prefixo, i);
			lista.prefixar(valor);
		}
		
		return resultado;
	}

	private String elementoParaIndice(String prefixo, int indice) {
		
		String resultado = null;
		
		resultado = prefixo + String.valueOf(indice);
		
		return resultado;
	}

	@Test
	public void testPopPilhaVazia() {
		
		MinhaPilhaImp<String> obj = null;

		obj = criarMinhaPilha();
		try {
			obj.pop();
			fail();
		} catch (EmptyStackException e) {
			Assert.assertTrue(true);
		}
	}
}
