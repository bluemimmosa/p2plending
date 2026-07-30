package com.niraj.p2plending.user.entity;

import com.niraj.p2plending.common.entity.BaseEntity;
import com.niraj.p2plending.common.constants.RoleConstants;
import com.niraj.p2plending.user.enums.RoleStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "roles",
        indexes = {
                @Index(name = "idx_role_name", columnList = "name")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50, updatable = false)
    private String name;

    @Column(nullable = false, length = 100)
    private String displayName;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, updatable = false)
    private Boolean systemRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleStatus status;

    private Role(
            String name,
            String displayName,
            String description,
            boolean systemRole
    ) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.systemRole = systemRole;
        this.status = RoleStatus.ACTIVE;
    }

    public static Role createSystemRole(
            String name,
            String displayName,
            String description
    ) {
        return new Role(name, displayName, description, true);
    }

    public static Role createCustomRole(
            String name,
            String displayName,
            String description
    ) {
        return new Role(name, displayName, description, false);
    }

    public void activate() {
        this.status = RoleStatus.ACTIVE;
    }

    public void deactivate() {
        if (Boolean.TRUE.equals(systemRole)) {
            throw new IllegalStateException("System roles cannot be deactivated.");
        }
        this.status = RoleStatus.INACTIVE;
    }

    public void changeDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return status == RoleStatus.ACTIVE;
    }

    public boolean isAdmin() {
        return RoleConstants.ADMIN.equals(name);
    }

    public boolean isBorrower() {
        return RoleConstants.BORROWER.equals(name);
    }

    public boolean isLender() {
        return RoleConstants.LENDER.equals(name);
    }

    public boolean isKycOfficer() {
        return RoleConstants.KYC_OFFICER.equals(name);
    }
}