package com.niraj.p2plending.common.constants;


import java.math.BigDecimal;


/**
 * Loan related business constants.
 */
public final class LoanConstants {


    private LoanConstants() {
    }


    /**
     * Minimum loan amount allowed.
     *
     * Initial value:
     * NPR 1000
     *
     * Editable from admin panel later.
     */
    public static final BigDecimal DEFAULT_MIN_LOAN_AMOUNT =
            BigDecimal.valueOf(1000);


    /**
     * Maximum loan amount allowed.
     *
     * Initial value:
     * NPR 100000
     */
    public static final BigDecimal DEFAULT_MAX_LOAN_AMOUNT =
            BigDecimal.valueOf(100000);


    /**
     * Minimum allowed interest rate.
     */
    public static final BigDecimal MIN_INTEREST_RATE =
            BigDecimal.valueOf(5);


    /**
     * Maximum allowed interest rate.
     *
     * Based on NRB compliance.
     */
    public static final BigDecimal MAX_INTEREST_RATE =
            BigDecimal.valueOf(18);


    /**
     * Loan request active duration.
     */
    public static final int LOAN_REQUEST_ACTIVE_HOURS =
            24;


    /**
     * Maximum offers displayed to borrower.
     */
    public static final int MAX_DISPLAYED_OFFERS =
            10;


}