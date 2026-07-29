package com.niraj.p2plending.exception;


/**
 * Exception thrown when requested resource does not exist.
 */
public class ResourceNotFoundException
        extends BusinessException {


    public ResourceNotFoundException(
            ErrorCode errorCode
    ) {

        super(errorCode);
    }

}