package br.com.megamotos.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.megamotos.dao.MotoDao;
import br.com.megamotos.dao.VendedorDao;
import br.com.megamotos.domain.Moto;
import br.com.megamotos.domain.Vendedor;

@ManagedBean
@ViewScoped
public class vendedorBean implements Serializable {

	private Vendedor vendedor;
	private List<Vendedor> vendedores;
	private String acao;

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Vendedor getVendedor() {
		if (vendedor == null) {
			vendedor = new Vendedor();
		}
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	@PostConstruct
	public void listar() {
		try {
			VendedorDao vendedorDao = new VendedorDao();
			vendedores = vendedorDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar as informações");
			erro.printStackTrace();
		}

	}

	public void carregarCadastro() {

		try {

			acao = br.com.megamotos.util.jsfUtil.getParam("foracao");

			String valor = br.com.megamotos.util.jsfUtil.getParam("forCod");

			if (valor != null) {

				Long codigo = Long.parseLong(valor);
				VendedorDao vendedorDao = new VendedorDao();
				vendedor = vendedorDao.buscar(codigo);

			} else {

				vendedor = new Vendedor();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}

	public void novo() {
		vendedor = new Vendedor();
	}

	public void editar() {
		try {
			VendedorDao vendedorDao = new VendedorDao();
			vendedorDao.editar(vendedor);
			novo();
			Messages.addGlobalInfo("Vendedor Atualizado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}

	public void excluir() {
		try {
			VendedorDao vendedorDao = new VendedorDao();
			vendedorDao.excluir(vendedor);
			novo();
			Messages.addGlobalInfo("Vendedor Excluido");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}

	public void salvar() {
		try {
			VendedorDao vendedorDao = new VendedorDao();
			vendedorDao.salvar(vendedor);
			novo();
			Messages.addGlobalInfo("Vendedor Cadastrado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}

}
