package com.niraj.p2plending.exception;


import lombok.Getter;


/**
 * Base business exception.
 */
@Getter
public class BusinessException extends RuntimeException {


    private final ErrorCode errorCode;


    public BusinessException(ErrorCode errorCode) {

        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }

}