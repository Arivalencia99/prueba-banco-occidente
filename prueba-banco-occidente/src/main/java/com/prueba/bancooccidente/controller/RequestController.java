package com.prueba.bancooccidente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bancooccidente.dto.RequestDTO;
import com.prueba.bancooccidente.service.IRequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	IRequestService requestService;
	
	@PostMapping("/enviar")
	public ResponseEntity<?>grupoAutobus(@RequestBody RequestDTO request) {
		return ResponseEntity.ok(requestService.grupoAutobus(request));
	}

}
