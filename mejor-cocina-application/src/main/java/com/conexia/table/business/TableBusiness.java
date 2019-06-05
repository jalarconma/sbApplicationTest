package com.conexia.table.business;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.dao.TableDao;
import com.conexia.entities.TableEntity;
import com.conexia.table.dto.TableDTO;

@Service
public class TableBusiness {
	
	@Autowired
	private TableDao tableDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Type targetListType = new TypeToken<List<TableDTO>>() {}.getType();

	public Integer create(TableDTO dto) {
		TableEntity entity = modelMapper.map(dto, TableEntity.class);
		TableEntity created = tableDao.save(entity);
		return created.getId();
	}

	public List<TableDTO> findAll() {
		List<TableEntity> entities = tableDao.findAll();
	    List<TableDTO> dtos = modelMapper.map(entities, targetListType);
	    return dtos;
	}

}
