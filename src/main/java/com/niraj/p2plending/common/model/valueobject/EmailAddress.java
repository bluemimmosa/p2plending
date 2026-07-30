package com.niraj.p2plending.common.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Locale;

/**
 * Represents an email address as a Value Object.
 *
 * This class encapsulates normalization logic.
 *
 * Validation is handled separately using Bean Validation.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmailAddress implements Serializable {

    @Column(
            name = "email",
            length = 255,
            unique = true
    )
    private String email;

    /**
     * Factory method.
     */
    public static EmailAddress of(String email) {

        if (email == null || email.isBlank()) {
            return null;
        }

        return new EmailAddress(
                email.trim()
                        .toLowerCase(Locale.ROOT)
        );
    }

    @Override
    public String toString() {
        return email;
    }

}