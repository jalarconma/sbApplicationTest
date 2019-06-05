package com.conexia.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@Data
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2934393616988057345L;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDate updatedAt;

}
