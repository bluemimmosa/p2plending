package com.niraj.p2plending.exception;


/**
 * Exception for duplicate data creation.
 */
public class DuplicateResourceException
        extends BusinessException {


    public DuplicateResourceException(
            ErrorCode errorCode
    ) {

        super(errorCode);
    }

}