package com.conexia.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.conexia.entities.WaiterEntity;

@Repository(value = "WaiterDao")
public interface WaiterDao extends JpaRepository<WaiterEntity, Integer> {
	
	@Query(value = "SELECT w FROM WaiterEntity w WHERE w.id NOT IN :ids")
	List<WaiterEntity> findNotInByIds(@Param("ids") Collection<Integer> ids);

}
