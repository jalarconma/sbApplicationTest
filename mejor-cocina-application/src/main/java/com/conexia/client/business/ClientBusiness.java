package com.conexia.client.business;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.client.dto.ClientDTO;
import com.conexia.dao.ClientDao;
import com.conexia.entities.ClientEntity;

@Service
public class ClientBusiness {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Type targetListType = new TypeToken<List<ClientDTO>>() {}.getType();

	public Integer findById(Integer clientId) {
		Optional<ClientEntity> client = clientDao.findById(clientId);
		return client.get().getId();
	}

	public Integer create(ClientDTO dto) {
		ClientEntity entity = modelMapper.map(dto, ClientEntity.class);
		ClientEntity createdClient = clientDao.save(entity);
		return createdClient.getId();
	}

	public List<ClientDTO> findAll() {
		List<ClientEntity> clients = clientDao.findAll();
	    List<ClientDTO> dtos = modelMapper.map(clients, targetListType);
	    return dtos;
	}

}
