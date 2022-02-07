package com.frete.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_frete")
public class Frete implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double peso;
	
	@Column(nullable = false)
	private String cepOrigem;
	
	@Column(nullable = false)
	private String cepDestino;
	
	@Column(nullable = false)
	private String nomeDestinatario;
	
	@Column(nullable = false)
	private Double vlTotalFrete;
	
	@Column(nullable = false)
	private String dataPrevistaEntrega;
	
	@Column(nullable = false)
	private String dataConsulta;
	
	
	
	
}

