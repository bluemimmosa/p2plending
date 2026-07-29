package com.niraj.p2plending.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


/**
 * Standard API response wrapper used by all REST endpoints.
 *
 * @param <T> response payload type
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public class ApiResponse<T> {


    /**
     * Indicates whether request was successful.
     */
    private final boolean success;


    /**
     * Human readable response message.
     */
    private final String message;


    /**
     * Actual response payload.
     */
    private final T data;


    /**
     * Response generation timestamp.
     */
    private final LocalDateTime timestamp;



    /**
     * Creates successful response.
     */
    public static <T> ApiResponse<T> success(
            String message,
            T data
    ) {

        return new ApiResponse<>(
                true,
                message,
                data,
                LocalDateTime.now()
        );
    }



    /**
     * Creates failed response.
     */
    public static <T> ApiResponse<T> failure(
            String message
    ) {

        return new ApiResponse<>(
                false,
                message,
                null,
                LocalDateTime.now()
        );
    }

}