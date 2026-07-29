package com.niraj.p2plending.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * Central repository for application error codes.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    // User Related Errors

    USER_NOT_FOUND(
            "USER_001",
            "User not found"
    ),

    USER_ALREADY_EXISTS(
            "USER_002",
            "User already exists"
    ),


    // Authentication Errors

    INVALID_CREDENTIALS(
            "AUTH_001",
            "Invalid username or password"
    ),

    UNAUTHORIZED_ACCESS(
            "AUTH_002",
            "Unauthorized access"
    ),


    // Loan Related Errors

    ACTIVE_LOAN_REQUEST_EXISTS(
            "LOAN_001",
            "Borrower already has an active loan request"
    ),

    LOAN_REQUEST_NOT_FOUND(
            "LOAN_002",
            "Loan request not found"
    ),

    LOAN_REQUEST_EXPIRED(
            "LOAN_003",
            "Loan request has expired"
    ),

    INVALID_LOAN_AMOUNT(
            "LOAN_004",
            "Loan amount is outside allowed limit"
    ),


    // KYC Related Errors

    KYC_NOT_APPROVED(
            "KYC_001",
            "User KYC verification is not approved"
    ),


    // Common

    VALIDATION_FAILED(
            "COMMON_001",
            "Validation failed"
    ),

    INTERNAL_SERVER_ERROR(
            "COMMON_500",
            "Unexpected internal server error"
    );


    private final String code;

    private final String message;

}