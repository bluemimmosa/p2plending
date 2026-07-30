package com.niraj.p2plending.user.enums;

/**
 * Represents the lifecycle status of a user account.
 *
 * Authentication verification (mobile/email) is handled
 * separately through dedicated boolean flags.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
public enum AccountStatus {

    /**
     * Newly registered account awaiting KYC approval.
     */
    PENDING_KYC,

    /**
     * Fully active account.
     */
    ACTIVE,

    /**
     * Temporarily suspended by administrator.
     */
    SUSPENDED,

    /**
     * Locked because of suspicious activity
     * or repeated authentication failures.
     */
    LOCKED,

    /**
     * User voluntarily deactivated account.
     */
    DEACTIVATED

}