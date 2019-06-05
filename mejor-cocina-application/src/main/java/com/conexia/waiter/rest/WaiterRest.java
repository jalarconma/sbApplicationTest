package com.conexia.waiter.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexia.waiter.business.WaiterBusiness;
import com.conexia.waiter.dto.WaiterDTO;

@RestController
@CrossOrigin
public class WaiterRest {
	
	@Autowired
	WaiterBusiness waiterBusiness;
	
    @GetMapping("/waiter/all")
    public List<WaiterDTO> findClients() {
        return waiterBusiness.findAll();
    }
    
    @PostMapping("/waiter")
    public Integer create(@Valid @RequestBody WaiterDTO dto) {
    	return waiterBusiness.create(dto);
    }

}
