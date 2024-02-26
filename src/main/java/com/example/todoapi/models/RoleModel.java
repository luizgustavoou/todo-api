package com.example.todoapi.models;

import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import com.example.todoapi.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_role")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "roleId")
public class RoleModel implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public RoleModel(UserRole role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role.getRole();
    }

}