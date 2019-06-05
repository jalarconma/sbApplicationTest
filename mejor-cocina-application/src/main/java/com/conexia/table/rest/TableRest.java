package com.conexia.table.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexia.table.business.TableBusiness;
import com.conexia.table.dto.TableDTO;

@RestController
@CrossOrigin
public class TableRest {
	
	@Autowired
    private TableBusiness tableBusiness;
    
    @GetMapping("/table/all")
    public List<TableDTO> findClients() {
        return tableBusiness.findAll();
    }
    
    @PostMapping("/table")
    public Integer create(@Valid @RequestBody TableDTO dto) {
    	return tableBusiness.create(dto);
    }

}
