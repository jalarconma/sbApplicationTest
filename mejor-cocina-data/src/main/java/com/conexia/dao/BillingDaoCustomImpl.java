package com.conexia.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.conexia.entities.BillingEntity;

public class BillingDaoCustomImpl implements BillingDaoCustom {
	
    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<BillingEntity> findByRegistrationMonthAndYear(Integer year, Integer month) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BillingEntity> query = cb.createQuery(BillingEntity.class);
        Root<BillingEntity> billing = query.from(BillingEntity.class);
        
        Path<LocalDate> registrationDatePath = billing.get("registrationDate");
        
        Predicate yearPredicate = cb.equal(cb.function("year", Integer.class, registrationDatePath), year);
        Predicate monthPredicate = cb.equal(cb.function("month", Integer.class, registrationDatePath), month);
        
        query.where(cb.and(yearPredicate, monthPredicate));
        
        return entityManager.createQuery(query)
                .getResultList();
	}

}
