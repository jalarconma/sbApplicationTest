package com.conexia.client.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.conexia.dao.ClientDao;
import com.conexia.entities.ClientEntity;

@Service
public class ClientBusiness {
	
	@Autowired
	private ClientDao clientDao;

	public Integer findById(Integer clientId) {
		Optional<ClientEntity> client = clientDao.findById(clientId);
		return client.get().getId();
	}

	public Integer create(ClientEntity dto) {
		ClientEntity createdClient = clientDao.save(dto);
		return createdClient.getId();
	}

}
