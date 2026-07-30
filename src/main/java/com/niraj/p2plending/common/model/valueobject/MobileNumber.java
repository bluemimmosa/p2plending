package com.niraj.p2plending.common.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Represents a mobile number.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MobileNumber implements Serializable {

    @Column(
            name = "mobile_number",
            nullable = false,
            unique = true,
            length = 20
    )
    private String mobileNumber;

    /**
     * Factory method.
     */
    public static MobileNumber of(String mobileNumber) {

        if (mobileNumber == null) {
            throw new IllegalArgumentException(
                    "Mobile number cannot be null."
            );
        }

        return new MobileNumber(
                mobileNumber.trim()
        );

    }

    @Override
    public String toString() {
        return mobileNumber;
    }

}