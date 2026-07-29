package com.niraj.p2plending.common.response;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


/**
 * Standard error response format.
 */
@Getter
@Builder
public class ErrorResponse {

    private boolean success;
    private String errorCode;
    private String message;
    private String path;
    private String requestId;
    private LocalDateTime timestamp;

}