package com.conexia.billing.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexia.billing.dto.BillingClientDTO;
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
	
	private static final Double VIP_CLIENT_EXPENSE = 100000d;
	
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
		validateDate(dto);
		Integer year = Integer.parseInt(dto.getYear());
		Integer month = Integer.parseInt(dto.getMonth());
		List<BillingEntity> billings = billingDao.findByRegistrationMonthAndYear(year, month);
		return calculateBillingsByWaiter(billings);
	}
	
	public List<BillingClientDTO> findByClientGreatherThanVIPExpense() {
		List<ClientEntity> clients = clientDao.findAll();
		return calculateBillingsByClient(clients);
	}

	private List<BillingClientDTO> calculateBillingsByClient(List<ClientEntity> clients) {
		List<BillingClientDTO> dtos = new ArrayList<>();
		
		for (ClientEntity client : clients) {
			Double totalBillingValues = calculatetotalBillingValues(client.getBillings());
			
			if (totalBillingValues.doubleValue() > VIP_CLIENT_EXPENSE) {
				BillingClientDTO dto = new BillingClientDTO();
				dto.setClientName(client.getName());
				dto.setClientLastName(client.getFirstLastName());
				dto.setTotalBillingsValue(totalBillingValues);
				dtos.add(dto);
			}
		}
		
		return dtos;
	}

	private Double calculatetotalBillingValues(List<BillingEntity> billings) {
		Double value = 0d;
		
		for (BillingEntity billing : billings) {
			value += billing.getValue();
		}
		
		return value;
	}

	private void validateDate(BillingRegistrationINDTO dto) {
		
		if (!StringUtils.isNumeric(dto.getYear())
				&& !StringUtils.isNumeric(dto.getMonth())) {
			throw new InputDataException("La fecha no es válida");
		}
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
		Set<Integer> setKeys = billingsByWaiter.keySet();
		
		if (setKeys.isEmpty()) {
			return addAllWaitersWithOutBillingValues();
		}
		
		List<WaiterEntity> waiters = waiterDao.findNotInByIds(setKeys.stream().toArray(Integer[]::new));
		
		if (waiters == null) {
			return dtos;
		}
		
		for (WaiterEntity waiter : waiters) {
			dtos.add(addZeroValueBillingWaiter(waiter));
		}
		
		return dtos;
	}

	private List<BillingWaiterDTO> addAllWaitersWithOutBillingValues() {
		List<BillingWaiterDTO> dtos = new ArrayList<>();
		List<WaiterEntity> waiters = waiterDao.findAll();
		
		for (WaiterEntity waiter : waiters) {
			dtos.add(addZeroValueBillingWaiter(waiter));
		}
		
		return dtos;
	}

	private BillingWaiterDTO addZeroValueBillingWaiter(WaiterEntity waiter) {
		BillingWaiterDTO dto = new BillingWaiterDTO();
		dto.setWaiterName(waiter.getName());
		dto.setWaiterLastName(waiter.getFirstLastName());
		dto.setTotalBillingsValue(0d);
		
		return dto;
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
			billingsByWaiter.put(waiterId, orderedBillings);
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
