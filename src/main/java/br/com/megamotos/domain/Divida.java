package br.com.megamotos.domain;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Divida extends GenericDomain {

	@JoinColumn(nullable = false)
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Moto moto;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Vendedor vendedor;

	@Column(length = 12, nullable = false)
	private float valTotal;

	@Column(length = 12, nullable = false)
	private float valParcela;

	@Column(length = 3, nullable = false)
	private int qtParcelas;

	@Column(length = 20, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtInicial;

	@Column(length = 20, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dtFinal;

	@Column(length = 25, nullable = false)
	private String tipoConta;

	@Column(length = 15, nullable = false)
	private String situacao;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Moto getMoto() {
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public float getValTotal() {
		return valTotal;
	}

	public void setValTotal(float valTotal) {
		this.valTotal = valTotal;
	}

	public float getValParcela() {
		return valParcela;
	}

	public void setValParcela(float valParcela) {
		this.valParcela = valParcela;
	}

	public int getQtParcelas() {
		return qtParcelas;
	}

	public void setQtParcelas(int qtParcelas) {
		this.qtParcelas = qtParcelas;
	}
	

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	

	/*
	 * @javax.persistence.Transient private String getsituacaoFormatado() { String
	 * situacaoFormatado = null;
	 * 
	 * if (situacao) { situacaoFormatado = "Em Dia"; } else { situacaoFormatado =
	 * "Atrasado"; } return situacaoFormatado; }
	 */

}
