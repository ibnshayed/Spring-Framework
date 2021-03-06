package com.ibnshayed.www.springboot2x.Model;

import lombok.*;

import javax.persistence.*;


@Data // Using @Data lombok annotation we can access constructor , getter ,setter and toString method
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mobile_Number")
    private long mobileNumber;
}
