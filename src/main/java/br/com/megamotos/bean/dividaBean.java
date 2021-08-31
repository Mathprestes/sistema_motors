package br.com.megamotos.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.com.megamotos.dao.ClienteDao;
import br.com.megamotos.dao.DividaDao;
import br.com.megamotos.dao.MotoDao;
import br.com.megamotos.dao.VendedorDao;
import br.com.megamotos.domain.Cliente;
import br.com.megamotos.domain.Divida;
import br.com.megamotos.domain.Moto;
import br.com.megamotos.domain.Vendedor;

@ManagedBean
@ViewScoped
public class dividaBean implements Serializable {

	private Divida divida;
	private List<Divida> dividas;
	private String acao;
	private List<Cliente> clientes;
	private List<Moto> motos;
	private List<Vendedor> vendedores;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Moto> getMotos() {
		return motos;
	}

	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}

	public List<Divida> getDividas() {
		return dividas;
	}

	public void setDividas(List<Divida> dividas) {
		this.dividas = dividas;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@PostConstruct
	public void listar() {
		try {
			DividaDao dividaDao = new DividaDao();
			dividas = dividaDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar as informações");
			erro.printStackTrace();
		}

	}

	public void enviar() {
		Messages.addGlobalInfo("Mensagem Enviada");
	}

	public void carregarCadastro() {

		try {

			acao = br.com.megamotos.util.jsfUtil.getParam("foracao");

			String valor = br.com.megamotos.util.jsfUtil.getParam("forCod");

			if (valor != null) {

				Long codigo = Long.parseLong(valor);
				DividaDao dividaDao = new DividaDao();
				divida = dividaDao.buscar(codigo);

			} else {

				divida = new Divida();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {

			divida = new Divida();
			MotoDao motoDao = new MotoDao();
			motos = motoDao.listar();

			ClienteDao clienteDao = new ClienteDao();
			clientes = clienteDao.listar();

			VendedorDao vendedorDao = new VendedorDao();
			vendedores = vendedorDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}

	public void editar() {

		try {
			DividaDao dividaDao = new DividaDao();
			dividaDao.editar(divida);
			novo();
			Messages.addGlobalInfo("Divida Editada!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar!");
			erro.printStackTrace();
		}

	}

	public void pagar() {

		try {
			DividaDao dividaDao = new DividaDao();
			dividaDao.editar(divida);
			novo();
			Messages.addGlobalInfo("Pagamento Cadastrado!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			divida = (Divida) evento.getComponent().getAttributes().get("dividaSel");

			DividaDao dividaDao = new DividaDao();
			dividaDao.excluir(divida);

			dividas = dividaDao.listar();
			Messages.addGlobalInfo("Registro Excluido!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			DividaDao dividaDao = new DividaDao();
			dividaDao.salvar(divida);
			novo();
			Messages.addGlobalInfo("Nova Venda Cadastrada");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}

}
