package com.niraj.p2plending.user.entity;

import com.niraj.p2plending.common.entity.BaseEntity;
import com.niraj.p2plending.common.model.valueobject.EmailAddress;
import com.niraj.p2plending.common.model.valueobject.MobileNumber;
import com.niraj.p2plending.common.model.valueobject.PersonName;
import com.niraj.p2plending.user.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_mobile", columnList = "mobile_number")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Embedded
    private PersonName name;

    @Embedded
    private EmailAddress email;

    @Embedded
    private MobileNumber mobileNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean emailVerified;

    @Column(nullable = false)
    private boolean mobileVerified;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    private User(
            PersonName name,
            EmailAddress email,
            MobileNumber mobileNumber,
            String encodedPassword
    ) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = encodedPassword;
        this.accountStatus = AccountStatus.PENDING_KYC;
        this.emailVerified = false;
        this.mobileVerified = false;
    }

    public static User create(
            PersonName name,
            EmailAddress email,
            MobileNumber mobileNumber,
            String encodedPassword
    ) {
        return new User(name, email, mobileNumber, encodedPassword);
    }

    public void verifyEmail() {
        this.emailVerified = true;
    }

    public void verifyMobile() {
        this.mobileVerified = true;
    }

    public void activate() {
        this.accountStatus = AccountStatus.ACTIVE;
    }

    public void suspend() {
        this.accountStatus = AccountStatus.SUSPENDED;
    }

    public void lock() {
        this.accountStatus = AccountStatus.LOCKED;
    }

    public void deactivate() {
        this.accountStatus = AccountStatus.DEACTIVATED;
    }

    public void assignRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public boolean hasRole(String roleName) {
        return roles.stream()
                .anyMatch(role -> role.getName().equals(roleName));
    }

    public void changePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public boolean isActive() {
        return accountStatus == AccountStatus.ACTIVE;
    }
}