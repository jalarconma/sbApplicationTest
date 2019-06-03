package com.conexia.client.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexia.client.business.ClientBusiness;
import com.conexia.entities.ClientEntity;

@RestController
public class ClientRest {
	
	@Autowired
    private ClientBusiness clientBusiness;

    @GetMapping("/client/{id}")
    public Integer findClient(@PathVariable(name = "id") Integer clientId) {
        return clientBusiness.findById(clientId);
    }
    
    @PostMapping(name = "client")
    public Integer addAnswer(@Valid @RequestBody ClientEntity dto) {
    	return clientBusiness.create(dto);
    }

}
