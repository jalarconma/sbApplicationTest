package com.conexia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexia.entities.WaiterEntity;

@Repository(value = "WaiterDao")
public interface WaiterDao extends JpaRepository<WaiterEntity, Integer>{

}
