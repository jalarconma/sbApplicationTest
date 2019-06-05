package com.conexia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexia.entities.TableEntity;

@Repository(value = "TableDao")
public interface TableDao extends JpaRepository<TableEntity, Integer> {

}
