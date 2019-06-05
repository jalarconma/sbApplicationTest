package com.conexia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexia.entities.BillingEntity;

@Repository(value = "BillingDao")
public interface BillingDao extends JpaRepository<BillingEntity, Integer> {

}
