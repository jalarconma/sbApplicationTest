package com.conexia.billing.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexia.billing.business.BillingBusiness;
import com.conexia.billing.dto.BillingINDTO;

@RestController
@CrossOrigin
public class BillingRest {
	
	@Autowired
    private BillingBusiness billingBusiness;
	
    @PostMapping("/billing")
    public Integer create(@Valid @RequestBody BillingINDTO dto) {
    	return billingBusiness.create(dto);
    }

}
