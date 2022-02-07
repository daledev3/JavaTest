package com.frete.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frete.models.Frete;
import com.frete.models.Produto;
import com.frete.repository.FreteRepository;
import com.frete.repository.ProdutoRepository;
import com.frete.services.FreteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/frete")
@Api(value="endpoint frete")
@CrossOrigin(origins="*")
public class FreteController {
	
	@Autowired
	FreteRepository freteRepository;
	FreteService freteService;
	
	public FreteController(FreteRepository freteRepository, FreteService freteService) {
		super();
		this.freteRepository = freteRepository;
		this.freteService = freteService;
	}
	
	
	@PostMapping("/frete")
	@ApiOperation(value="Salvar uma cotação")
	public Frete salvaFrete(@RequestBody Frete frete) {
		freteService.calculaFrete(peso, cepOrigem, cepDestino, nomeDestinatario);
		return freteRepository.save(frete);
	}
	
	

}
