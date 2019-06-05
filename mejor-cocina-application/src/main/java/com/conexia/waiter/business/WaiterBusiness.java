package com.conexia.waiter.business;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.dao.WaiterDao;
import com.conexia.entities.WaiterEntity;
import com.conexia.waiter.dto.WaiterDTO;
import java.lang.reflect.Type;

@Service
public class WaiterBusiness {
	
	@Autowired
	private WaiterDao waiterDao;
	
    @Autowired
    private ModelMapper modelMapper;
	
	public Integer create(WaiterDTO dto) {
		WaiterEntity entity = modelMapper.map(dto, WaiterEntity.class);
		entity = waiterDao.save(entity);
		return entity.getId();
	}

	public List<WaiterDTO> findAll() {
		List<WaiterEntity> entities = waiterDao.findAll();
	    Type targetListType = new TypeToken<List<WaiterDTO>>() {}.getType();
	    List<WaiterDTO> dtos = modelMapper.map(entities, targetListType);
	    return dtos;
	}
	
	

}
