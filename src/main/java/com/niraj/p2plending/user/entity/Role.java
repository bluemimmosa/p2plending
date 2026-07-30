package com.niraj.p2plending.user.entity;

import com.niraj.p2plending.common.entity.BaseEntity;
import com.niraj.p2plending.user.enums.RoleName;
import com.niraj.p2plending.user.enums.RoleStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "roles",
        indexes = {
                @Index(
                        name = "idx_role_name",
                        columnList = "name"
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            unique = true,
            updatable = false,
            length = 30
    )
    private RoleName name;

    @Column(nullable = false, length = 100)
    private String displayName;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleStatus status;

    private Role(
            RoleName name,
            String description
    ) {
        this.name = name;
        this.displayName = name.getDisplayName();
        this.description = description;
        this.status = RoleStatus.ACTIVE;
    }

    public static Role create(
            RoleName name,
            String description
    ) {
        return new Role(name, description);
    }

    public void activate() {
        this.status = RoleStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = RoleStatus.INACTIVE;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return status == RoleStatus.ACTIVE;
    }

}