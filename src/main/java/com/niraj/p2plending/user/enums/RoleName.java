package com.niraj.p2plending.user.enums;

/**
 * Defines all system roles.
 *
 * The enum name is persisted in the Role table.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
public enum RoleName {

    ADMIN("Administrator"),

    BORROWER("Borrower"),

    LENDER("Lender"),

    KYC_OFFICER("KYC Officer");

    private final String displayName;

    RoleName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}