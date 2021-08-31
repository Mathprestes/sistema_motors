package br.com.megamotos.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;
import java.util.List;

import br.com.megamotos.domain.Moto;
import br.com.megamotos.domain.Vendedor;
import br.com.megamotos.domain.Cliente;

public class VendedorDaoTest {

	@Ignore
	@Test
	public void salvar() {		

		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Diogo Neres");
		vendedor.setCpf("1234567890");
		vendedor.setTelefone("14-97651912");
		vendedor.setSenhaSemCriptografia("123");
		SimpleHash hash = new SimpleHash("md5");
		vendedor.setSenha("123");

		VendedorDao vendedorDao = new VendedorDao();
		vendedorDao.salvar(vendedor);
		System.out.println("\nVendedor cadastrado com sucesso!!");
	}

	@Ignore
	@Test
	public void listar() {

		VendedorDao vendedorDao = new VendedorDao();
		List<Vendedor> resultado = vendedorDao.listar();
		System.out.println("\nTotal de registro(s)= " + resultado.size());

		for (Vendedor moto : resultado) {
			System.out.println("Vendedor: " + moto.getNome());

		}
	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		VendedorDao vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.buscar(codigo);
		List<Vendedor> resultado = vendedorDao.listar();

		if (vendedor == null) {
			System.out.println("\nNenhum registro encontrado! ");
		} else {
			System.out.println("\nTotal de registro(s) = " + resultado.size());
			System.out.println("\nRegistro encontrado: " + vendedor.getNome());
		}

	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 1L;
		VendedorDao vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.buscar(codigo);

		if (vendedor == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			vendedorDao.excluir(vendedor);
			System.out.println("Este registro " + vendedor.getNome() + " código " + vendedor.getCodigo()
					+ " foi excluído com sucesso! ");

		}
	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 1L;
		VendedorDao vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.buscar(codigo);

		if (vendedor == null) {
			System.out.println("\nNenhum registro encontrado!");
		} else {
			vendedor.setNome("José Antônio");
			vendedor.setCpf("01020304050");
			
			vendedorDao.editar(vendedor);
			
			System.out.println("\nRegistro atualizado!");
			System.out.println("\nNovo nome: " + vendedor.getNome());
			System.out.println("Novo CPF: " + vendedor.getCpf());

		}
	}

}
