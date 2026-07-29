package com.niraj.p2plending.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 * Date and time utility methods.
 */
public final class DateTimeUtil {


    private DateTimeUtil() {
    }


    /**
     * Nepal Standard Time zone.
     */
    private static final String NEPAL_ZONE =
            "Asia/Kathmandu";


    /**
     * Returns current Nepal time.
     *
     * @return current local date time
     */
    public static LocalDateTime now() {

        return ZonedDateTime
                .now(
                        ZoneId.of(NEPAL_ZONE)
                )
                .toLocalDateTime();

    }


    /**
     * Adds hours to current time.
     *
     * @param hours hours to add
     * @return future date time
     */
    public static LocalDateTime addHours(
            int hours
    ) {

        return now()
                .plusHours(hours);

    }


    /**
     * Adds minutes to current time.
     *
     * @param minutes minutes to add
     * @return future date time
     */
    public static LocalDateTime addMinutes(
            int minutes
    ) {

        return now()
                .plusMinutes(minutes);

    }

}