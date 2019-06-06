package com.conexia.dao;

import java.util.List;

import com.conexia.entities.BillingEntity;

public interface BillingDaoCustom {
	
	List<BillingEntity> findByRegistrationMonthAndYear(Integer year, Integer mont);

}
