package com.conexia.billing.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexia.billing.business.BillingBusiness;
import com.conexia.billing.dto.BillingINDTO;
import com.conexia.billing.dto.BillingRegistrationINDTO;
import com.conexia.billing.dto.BillingWaiterDTO;

@RestController
@CrossOrigin
public class BillingRest {
	
	@Autowired
    private BillingBusiness billingBusiness;
	
    @PostMapping("/billing")
    public Integer create(@Valid @RequestBody BillingINDTO dto) {
    	return billingBusiness.create(dto);
    }
    
    @GetMapping("/billing/by-waiter/year/{year}/month/{month}")
    public List<BillingWaiterDTO> findBillingsByWaiter(@PathVariable(name = "year") String year,
    		@PathVariable(name = "month") String month) {
        return billingBusiness.findByWaiterAndYearAndMonth(new BillingRegistrationINDTO(year, month));
    }
    

}
