package com.conexia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conexia.entities.BillingEntity;

@Repository(value = "BillingDao")
public interface BillingDao extends JpaRepository<BillingEntity, Integer> {
	
	@Query("select b from BillingEntity b where year(b.registrationDate) = ?1 and month(b.registrationDate) = ?2")
	List<BillingEntity> findByRegistrationMonthAndYear(Integer year, Integer mont);

}
