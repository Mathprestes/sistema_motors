package br.com.megamotos.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.megamotos.domain.Cliente;
import br.com.megamotos.domain.Divida;
import br.com.megamotos.domain.Moto;
import br.com.megamotos.domain.Vendedor;

public class DividaDaoTest {
	
	
	@Ignore
	@Test
	public void salvar() {		
		
		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);
		
		Long codigom = 1L;
		MotoDao motoDao = new MotoDao();
		Moto moto = motoDao.buscar(codigom);
		
		Long codigov = 1L;
		VendedorDao vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.buscar(codigov);
		
					
		Date data = new Date();
		Divida divida = new Divida();
		divida.setValTotal(16000.f);
		divida.setValParcela(500.f);
		divida.setQtParcelas(48);
		divida.setDtInicial(data);
		divida.setDtFinal(data);
		divida.setTipoConta("Promissória");
		divida.setSituacao("Em dia");
		divida.setCliente(cliente);
		divida.setMoto(moto);
		divida.setVendedor(vendedor);		
		
		DividaDao dividaDao = new DividaDao();
		dividaDao.salvar(divida);
		System.out.println("\nDívida registrada! ");
	}
	
	@Ignore
	@Test
	public void listar() {
		DividaDao dividaDao = new DividaDao();
		List<Divida> resultado = dividaDao.listar();		
		
		System.out.println("\nTotal de Registro = " + resultado.size()+"\n");
		
		for(Divida divida:resultado) {
			
			System.out.println("Total da divida: " + divida.getValTotal());
			System.out.println("Quantidade de parcelas contratadas: " + divida.getQtParcelas());
			System.out.println("Modalidade da compra: " + divida.getTipoConta());
			System.out.println("Data da compra: " + divida.getDtInicial());
			System.out.println("Inicio das parcelas: " + divida.getDtInicial());
			System.out.println("Situação do contrato: " + divida.getSituacao());
			System.out.println("Término das parcelas: " + divida.getDtFinal() + "\n");			
		}
	}
	
	@Ignore
	@Test
	public void buscar() {
		
		Long codigo = 1L;
		DividaDao dividaDao = new DividaDao();
		Divida divida = dividaDao.buscar(codigo);
		List<Divida> resultado = dividaDao.listar();
		
		if (divida == null) {
			System.out.println("Nenhum registro encontrado! ");
		}else {
			System.out.println("\nTotal de registro(s) encontrado(s): " + resultado.size());
			
		}
		
	}
	
	@Ignore
	@Test
	public void excluir() {
		
		Long codigo = 2L;
		DividaDao dividaDao = new DividaDao();
		Divida divida = dividaDao.buscar(codigo);
		
		if (divida == null) {
			System.out.println("Nenhum registro encontrado!");
		}else {
			dividaDao.excluir(divida);
			System.out.println("\nO registro " +  " código = " + divida.getCodigo() + " foi excluído! " );
			
		}
	}
	
	@Ignore
	@Test
	public void editar() {
		Long codigo = 1L;
		DividaDao dividaDao = new DividaDao();
		Divida divida = dividaDao.buscar(codigo);
		
		if(divida == null) {
			System.out.println("Nenhum registro encontrado!");
		}else {
			ClienteDao clienteDao = new ClienteDao();
			Cliente cliente = clienteDao.buscar(1);
	        
	        divida.setQtParcelas(36);
	        dividaDao.editar(divida);
	        divida.setSituacao("atrasado");	        
			
			System.out.println("Registro atualizado!");
			System.out.println("Total: " + divida.getValTotal());
			System.out.println("Quantidade de parcelas alterada para : " + divida.getQtParcelas());
			System.out.println("Situação alterada para : " + divida.getSituacao());
						
		}
			
	}
	
}
