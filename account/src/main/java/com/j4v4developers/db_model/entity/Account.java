package com.j4v4developers.db_model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(of = "id", callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "account")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "username")
    private String username;

    @Column(value = "email")
    private String email;

    @Column(value = "password")
    private String password;

    @Column(value = "is_active")
    private Boolean isActive;

    @Column(value = "created_at")
    private LocalDate createdAt;
}
