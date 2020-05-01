package com.blooddonate.eis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Email is required.")
    private String email;
    @NotBlank(message = "Phone is required.")
    private String phone;
    @NotBlank(message = "Address is required.")
    private String address;
    @Convert(converter = BloodTypeConverter.class)
    private BloodType bloodType;


    public Donor(String name,String email,String phone,
                 String address,BloodType bloodType) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bloodType = bloodType;
    }
}
