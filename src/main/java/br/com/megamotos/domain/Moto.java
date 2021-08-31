package br.com.megamotos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Moto extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String cor;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String chassi;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private Float valor;
	
	
	public String getModelo() {
		return modelo;
	}
		
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


}
