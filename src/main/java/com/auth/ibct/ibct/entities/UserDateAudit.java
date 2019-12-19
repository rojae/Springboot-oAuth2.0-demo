package com.auth.ibct.ibct.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Data;

@Data
@MappedSuperclass
@JsonIgnoreProperties(
    value = {"createdBy", "updatedby"},
    allowGetters = true
)

public abstract class UserDateAudit extends DateAudit {

    // Generated SerialVersionUID
    private static final long serialVersionUID = -2677651824542556293L;

    @CreatedBy
    @JsonIgnore
    @Column(name="createdBy", columnDefinition = "varchar(255)", nullable = true, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @JsonIgnore
    @Column(name="updatedBy", columnDefinition = "varchar(255)", nullable = true)
    private String updatedBy;

}