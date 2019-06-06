package com.conexia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexia.entities.BillingEntity;

@Repository(value = "BillingDao")
public interface BillingDao extends JpaRepository<BillingEntity, Integer>, BillingDaoCustom {
	
//	@Query("select b from BillingEntity b where year(b.registrationDate) = :year and month(b.registrationDate) = :month")
//	List<BillingEntity> findByRegistrationMonthAndYear(@Param("year") Integer year, @Param("month") Integer mont);

}
