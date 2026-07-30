package com.niraj.p2plending.user.entity;

import com.niraj.p2plending.common.entity.BaseEntity;
import com.niraj.p2plending.user.enums.RoleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {

    /**
     * Internal system role name.
     *
     * Immutable after creation.
     */
    @Column(
            nullable = false,
            unique = true,
            length = 50,
            updatable = false
    )
    private String name;

    /**
     * User-friendly role name.
     */
    @Column(
            nullable = false,
            length = 100
    )
    private String displayName;

    /**
     * Description shown in admin panel.
     */
    @Column(length = 500)
    private String description;

    /**
     * Indicates whether this is a
     * built-in system role.
     *
     * Immutable.
     */
    @Column(
            nullable = false,
            updatable = false
    )
    private Boolean systemRole = false;

    /**
     * Current lifecycle status.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleStatus status =
            RoleStatus.ACTIVE;

}