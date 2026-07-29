package com.niraj.p2plending.common.util;

import java.util.UUID;


/**
 * Utility class for UUID operations.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
public final class UUIDUtil {


    private UUIDUtil() {
    }


    /**
     * Generates a random UUID.
     *
     * @return UUID value
     */
    public static UUID generateUUID() {

        return UUID.randomUUID();

    }


    /**
     * Generates UUID string.
     *
     * @return UUID string
     */
    public static String generateUUIDString() {

        return UUID.randomUUID()
                .toString();

    }

}