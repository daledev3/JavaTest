package com.frete.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.frete.models.Frete;

public class FreteService {
	
	public Object consultaCep(String cep) throws IOException {	
		//faz a consulta das informações do cep
		URL url = new URL("https://viacep.com.br/ws/" + cep +"/json/");
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder jsonCep = new StringBuilder();
		 br.lines().forEach(l -> jsonCep.append(l.trim()));
         cep = jsonCep.toString();
         return cep;
         
		}
	
	public Boolean verificaDDD(Object Origem, Object Destino) {
		return null;
		
	}
	
	public Boolean verificaEstado(Object Origem, Object Destino) {
		return null;
		
	}

	

	public Frete calculaFrete(Double peso, String cepOrigem, String cepDestino, String nomeDestinatario) throws IOException {
		Object origem = consultaCep(cepOrigem);
		Object destino = consultaCep(cepDestino);
		
		Boolean dddIgual = verificaDDD(origem, destino);
		Boolean estadoIgual = verificaEstado(origem, destino);
		
		//O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00
		Double valor = peso;
		
		//CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia	
		if (dddIgual == true && estadoIgual == false) {
			double desconto = 0.50;
			double frete = valor * desconto;
			int EntregaDias = 1;
			
		}
		
		//CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias
			if(estadoIgual == true && estadoIgual == true ) {
			double desconto = 0.75;
			double frete = valor * desconto;
			int EntregaDias = 3;
			}
			
		//CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias
			if(estadoIgual) {
				double frete = valor;
				int entregaDias = 10;
				}
	}
	
		

}
