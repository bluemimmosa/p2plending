package com.niraj.p2plending.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Password encryption utility.
 */
public final class PasswordUtil {


    private PasswordUtil() {
    }


    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();



    /**
     * Encrypt password.
     *
     * @param rawPassword plain password
     * @return encrypted password
     */
    public static String encode(
            String rawPassword
    ) {

        return encoder.encode(rawPassword);

    }



    /**
     * Verify password.
     *
     * @param rawPassword entered password
     * @param encodedPassword stored password
     * @return true if matches
     */
    public static boolean matches(
            String rawPassword,
            String encodedPassword
    ) {

        return encoder.matches(
                rawPassword,
                encodedPassword
        );

    }

}