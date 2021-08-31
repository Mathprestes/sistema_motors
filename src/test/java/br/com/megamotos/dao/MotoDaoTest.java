package br.com.megamotos.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.megamotos.domain.Moto;

public class MotoDaoTest {

	@Ignore
	@Test
	public void salvar() {

		Moto moto = new Moto();
		moto.setChassi("9c");
		moto.setCor("Laranja");
		moto.setMarca("Yamaha");
		moto.setValor(12.000f);
		moto.setModelo("CG160Titan");
		moto.setPlaca("CTZ-8000");
		MotoDao motoDao = new MotoDao();
		motoDao.salvar(moto);
		System.out.println("\nMotocicleta cadastrada com sucesso!");
	}

	@Ignore
	@Test
	public void listar() {

		MotoDao motoDao = new MotoDao();
		List<Moto> resultado = motoDao.listar();
		System.out.println("Total de Registro = " + resultado.size());
		for (Moto produto : resultado) {

			System.out.println("Motocicleta: " + produto.getMarca());
			System.out.println("Modelo: " + produto.getModelo());
			System.out.println("Placa: " + produto.getPlaca());
			System.out.println("Chassi: " + produto.getChassi());
		}

	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		MotoDao motoDao = new MotoDao();
		Moto moto = motoDao.buscar(codigo);

		if (moto == null) {
			System.out.println("Nenhum registro encontrado! ");
		} else {
			System.out.println("Motocicleta: " + moto.getMarca());
			System.out.println("Modelo: " + moto.getModelo());
			System.out.println("Placa: " + moto.getPlaca());
			System.out.println("Chassi: " + moto.getChassi());

		}

	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 2L;
		MotoDao motoDao = new MotoDao();
		Moto moto = motoDao.buscar(codigo);

		if (moto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			motoDao.excluir(moto);
			System.out.println("\nRegistro excluído!\n");
			System.out.println("Motocicleta: " + moto.getMarca());
			System.out.println("Modelo: " + moto.getModelo());
			System.out.println("Placa: " + moto.getPlaca());
			System.out.println("Chassi: " + moto.getChassi());

		}
	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 2L;
		MotoDao motoDao = new MotoDao();
		Moto moto = motoDao.buscar(codigo);

		if (moto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			moto.setMarca("Honda");
			moto.setCor("Vermelha");
			moto.setChassi("9C2KC2200MR001100");
			moto.setModelo("CG 160 TITAN");
			moto.setValor(14.100f);
			motoDao.editar(moto);
			
			System.out.println("\nRegistro atualizado!\n");
			
			System.out.println("Motocicleta: " + moto.getMarca());
			System.out.println("Modelo: " + moto.getModelo());
			System.out.println("Placa: " + moto.getPlaca());
			System.out.println("Chassi: " + moto.getChassi());

		}
	}

}
