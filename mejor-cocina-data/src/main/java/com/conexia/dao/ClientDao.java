package com.conexia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexia.entities.ClientEntity;

@Repository(value = "ClientDao")
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {

}