package com.niraj.p2plending.exception;


import com.niraj.p2plending.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * Handles all application exceptions globally.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ) {


        ErrorCode error =
                exception.getErrorCode();


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorResponse.builder()
                                .success(false)
                                .errorCode(error.getCode())
                                .message(error.getMessage())
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build()
                );

    }



    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException exception,
            HttpServletRequest request
    ) {


        ErrorCode error =
                exception.getErrorCode();


        return ResponseEntity
                .badRequest()
                .body(
                        ErrorResponse.builder()
                                .success(false)
                                .errorCode(error.getCode())
                                .message(error.getMessage())
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build()
                );

    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(
            Exception exception,
            HttpServletRequest request
    ) {


        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ErrorResponse.builder()
                                .success(false)
                                .errorCode(
                                        ErrorCode.INTERNAL_SERVER_ERROR.getCode()
                                )
                                .message(
                                        ErrorCode.INTERNAL_SERVER_ERROR.getMessage()
                                )
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build()
                );

    }

}