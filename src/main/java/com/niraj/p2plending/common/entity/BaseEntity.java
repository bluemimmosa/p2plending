package com.niraj.p2plending.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * Base entity containing common fields shared by all entities.
 *
 * Internal ID is optimized for database operations.
 * Public UUID is used for external communication.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {


    /**
     * Internal database identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Public identifier exposed through APIs.
     */
    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    private UUID publicId = UUID.randomUUID();


    /**
     * Record creation timestamp.
     */
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt;


    /**
     * Record modification timestamp.
     */
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    /**
     * User/system creating the record.
     */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;


    /**
     * User/system updating the record.
     */
    @LastModifiedBy
    private String updatedBy;


    /**
     * Optimistic locking version.
     */
    @Version
    private Long version;

}