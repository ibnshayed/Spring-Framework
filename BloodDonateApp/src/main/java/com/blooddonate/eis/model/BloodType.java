package com.blooddonate.eis.model;

import java.util.Optional;
import java.util.stream.Stream;

public enum BloodType {
    A_POSITIVE ("A+"),
    A_NEGETIVE ("A-"),
    B_POSITIVE ("B+"),
    B_NEGETIVE ("B-"),
    AB_POSITIVE ("AB+"),
    AB_NEGETIVE ("AB-"),
    O_POSITIVE ("O+"),
    O_NEGETIVE ("O-");

    String shortBloodType;

    private BloodType(String shortBloodType) {
        this.shortBloodType = shortBloodType;
    }

    public static Optional<BloodType> of(String value) {
        return Stream.of(values())
                .filter(v -> v.shortBloodType.equalsIgnoreCase(value))
                .findFirst();
    }

    @Override
    public String toString() {
        return shortBloodType;
    }
}
