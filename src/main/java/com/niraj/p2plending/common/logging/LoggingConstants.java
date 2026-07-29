package com.niraj.p2plending.common.logging;


/**
 * Logging related constants.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
public final class LoggingConstants {


    private LoggingConstants() {
    }


    /**
     * HTTP header name used for request tracking.
     */
    public static final String REQUEST_ID_HEADER =
            "X-Request-ID";


    /**
     * MDC key for storing request ID.
     */
    public static final String REQUEST_ID_MDC =
            "requestId";

}