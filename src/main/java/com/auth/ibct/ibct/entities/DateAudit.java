package com.auth.ibct.ibct.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
    value = {"createdAt", "updatedAt"},
    allowGetters = true
)

public abstract class DateAudit implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@CreatedDate
    @Column(name="createdAt", nullable = true, updatable = false, columnDefinition = "datetime default GETDATE()")
    private Instant createdAt;

    @LastModifiedDate
    @Column(name="updatedAt", nullable = true)
    private Instant updatedAt;
}