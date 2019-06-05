package com.conexia.billing.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.billing.dto.BillingINDTO;
import com.conexia.billing.dto.BillingRegistrationINDTO;
import com.conexia.billing.dto.BillingWaiterDTO;
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
	
	public List<BillingWaiterDTO> findByWaiterAndYearAndMonth(BillingRegistrationINDTO dto) {
		List<BillingEntity> billings = billingDao.findByRegistrationMonthAndYear(dto.getYear(), dto.getMonth());
		return calculateBillingsByWaiter(billings);
	}

	private List<BillingWaiterDTO> calculateBillingsByWaiter(List<BillingEntity> billings) {
		Map<Integer, List<BillingEntity>> billingsByWaiter = orderBillingsByWaiter(billings);
		List<BillingWaiterDTO> dtos = plusBillingsByWaiter(billingsByWaiter);
		dtos.addAll(findWaitersWithoutBillings(billingsByWaiter));
		
		return dtos;
	}

	private List<BillingWaiterDTO> findWaitersWithoutBillings(
			Map<Integer, List<BillingEntity>> billingsByWaiter) {
		List<BillingWaiterDTO> dtos = new ArrayList<>();
		List<WaiterEntity> waiters = waiterDao.findNotInByIds(billingsByWaiter.keySet());
		
		if (waiters == null) {
			return dtos;
		}
		
		for (WaiterEntity waiter : waiters) {
			BillingWaiterDTO dto = new BillingWaiterDTO();
			dto.setWaiterName(waiter.getName());
			dto.setWaiterLastName(waiter.getFirstLastName());
			dto.setTotalBillingsValue(0d);
			dtos.add(dto);
		}
		
		return dtos;
	}

	private List<BillingWaiterDTO> plusBillingsByWaiter(Map<Integer, List<BillingEntity>> billingsByWaiter) {
		List<BillingWaiterDTO> dtos = new ArrayList<>();
		
		for (Integer waiterId : billingsByWaiter.keySet()) {
			Optional<WaiterEntity> waiterOpt = waiterDao.findById(waiterId);
			WaiterEntity waiter = waiterOpt.get();
			
			BillingWaiterDTO dto = new BillingWaiterDTO();
			dto.setWaiterName(waiter.getName());
			dto.setWaiterLastName(waiter.getFirstLastName());
			Double billingsValue = calculateBillingsValue(billingsByWaiter.get(waiterId));
			
			dto.setTotalBillingsValue(billingsValue);
			dtos.add(dto);
		}
		
		return dtos;
	}

	private Map<Integer, List<BillingEntity>> orderBillingsByWaiter(List<BillingEntity> billings) {
		Map<Integer, List<BillingEntity>> billingsByWaiter = new HashMap<>();
		
		for (BillingEntity billing : billings) {
			Integer waiterId = billing.getWaiter().getId();
			List<BillingEntity> orderedBillings = billingsByWaiter.get(waiterId);
			
			if (orderedBillings == null) {
				orderedBillings = new ArrayList<>();
			}
			
			orderedBillings.add(billing);
			billingsByWaiter.replace(waiterId, orderedBillings);
		}
		
		return billingsByWaiter;
	}

	private Double calculateBillingsValue(List<BillingEntity> billings) {
		Double value = 0d;
		
		if (billings == null) {
			return value;
		}
		
		for (BillingEntity billing : billings) {
			value += billing.getValue();
		}
		
		return value;
	} 

}
