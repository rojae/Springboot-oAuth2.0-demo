package com.auth.ibct.ibct.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User extends UserDateAudit {

    // Generated SerialVersionUID
    private static final long serialVersionUID = -3269634734584729134L;

    public enum Role {
        USER, ADMIN
    }

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(255)")
    private String id = UUID.randomUUID().toString(); // UUID

    @NotEmpty
    @Email
    private String email;

    @JsonIgnore
    @ToString.Exclude
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

}


