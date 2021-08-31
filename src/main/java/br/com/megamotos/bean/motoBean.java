package br.com.megamotos.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import br.com.megamotos.dao.MotoDao;
import br.com.megamotos.domain.Moto;


@ManagedBean
@ViewScoped
public class motoBean implements Serializable{
	
	private Moto moto;
	private List<Moto> motos;
	private String acao;	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Moto getMoto() {
		if(moto == null) {
			moto = new Moto();
		}
		return moto;
	}
	
	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public List<Moto> getMotos(){
		return motos;
	}
	
	public void  setMotos(List<Moto> motos) {
		this.motos = motos;
	}

	
	@PostConstruct
	public void listar() {
		try {
			MotoDao motoDao = new MotoDao();
			motos = motoDao.listar();
								
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
				MotoDao motoDao = new MotoDao();
				moto = motoDao.buscar(codigo);

			} else {
				
				moto = new Moto();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}
	
	
	
	public void novo() {
		moto = new Moto();	
	}
	
	
	public void editar() {

		try {
			MotoDao motoDao = new MotoDao();
			motoDao.editar(moto);
			novo();
			Messages.addGlobalInfo("Atualizado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Atualizar");
			erro.printStackTrace();
		}

	}
	
	
	public void excluir() {
		try {
			MotoDao motoDao = new MotoDao();
			motoDao.excluir(moto);
			novo();
			Messages.addGlobalInfo("Moto Excluida");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
	
		
	public void salvar() {
		try {
			MotoDao motoDao = new MotoDao();
			motoDao.salvar(moto);
			novo();
			Messages.addGlobalInfo("Moto Cadastrada");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}
		
	}

}
