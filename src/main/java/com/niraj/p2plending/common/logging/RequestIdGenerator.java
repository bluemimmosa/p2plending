package com.niraj.p2plending.common.logging;

import java.util.UUID;


/**
 * Generates unique request identifiers.
 */
public final class RequestIdGenerator {


    private RequestIdGenerator() {
    }


    public static String generate() {

        return "REQ-" +
                UUID.randomUUID()
                        .toString()
                        .substring(0,8)
                        .toUpperCase();

    }

}