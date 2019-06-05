package com.conexia.billing.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.billing.dto.BillingINDTO;
import com.conexia.dao.BillingDao;
import com.conexia.dao.ClientDao;
import com.conexia.dao.TableDao;
import com.conexia.dao.WaiterDao;
import com.conexia.entities.BillingEntity;
import com.conexia.entities.ClientEntity;
import com.conexia.entities.TableEntity;
import com.conexia.entities.WaiterEntity;
import com.conexia.common.*;

@Service
public class BillingBusiness {
	
	@Autowired
	private BillingDao billingDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private WaiterDao waiterDao;
	
	@Autowired
	private TableDao tableDao;
	
	public Integer create(BillingINDTO dto) {
		Optional<ClientEntity> client = clientDao.findById(dto.getClientId());
		
		if (!client.isPresent()) {
			throw new ResourceNotFoundException("Cliente no encontrado");
		}
		
		Optional<WaiterEntity> waiter = waiterDao.findById(dto.getWaiterId());
		
		if (!waiter.isPresent()) {
			throw new ResourceNotFoundException("Camarero no encontrado");
		}
		
		Optional<TableEntity> table = tableDao.findById(dto.getTableId());
		
		if (!table.isPresent()) {
			throw new ResourceNotFoundException("Mesa no encontrada");
		}
		
		BillingEntity billing = new BillingEntity();
		billing.setClient(client.get());
		billing.setWaiter(waiter.get());
		billing.setTable(table.get());
		billing.setValue(dto.getValue());
		billing.setRegistrationDate(dto.getRegistrationDate());
		
		billing = billingDao.save(billing);
		
		return billing.getId();
	}

}
