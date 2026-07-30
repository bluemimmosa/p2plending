package com.niraj.p2plending.common.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Represents a person's name.
 *
 * A value object that can be embedded into entities.
 *
 * @author Niraj Khadka
 * @since 1.0.0
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PersonName implements Serializable {

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    /**
     * Returns the complete name.
     */
    public String getFullName() {

        StringBuilder builder = new StringBuilder();

        builder.append(firstName);

        if (middleName != null && !middleName.isBlank()) {
            builder.append(" ").append(middleName);
        }

        builder.append(" ").append(lastName);

        return builder.toString();
    }

}