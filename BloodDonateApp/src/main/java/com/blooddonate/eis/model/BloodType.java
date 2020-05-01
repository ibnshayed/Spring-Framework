package com.blooddonate.eis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.stream.Stream;

public enum BloodType {
    @JsonProperty("A+")
    A_POSITIVE ("A+"),
    @JsonProperty("A-")
    A_NEGETIVE ("A-"),
    @JsonProperty("B+")
    B_POSITIVE ("B+"),
    @JsonProperty("B-")
    B_NEGETIVE ("B-"),
    @JsonProperty("AB+")
    AB_POSITIVE ("AB+"),
    @JsonProperty("AB-")
    AB_NEGETIVE ("AB-"),
    @JsonProperty("O+")
    O_POSITIVE ("O+"),
    @JsonProperty("O-")
    O_NEGETIVE ("O-");

    String shortBloodType;

    private BloodType(String shortBloodType) {
        this.shortBloodType = shortBloodType;
    }

    public String getShortBloodType() {
        return shortBloodType;
    }

    public void setShortBloodType(String shortBloodType) {
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
