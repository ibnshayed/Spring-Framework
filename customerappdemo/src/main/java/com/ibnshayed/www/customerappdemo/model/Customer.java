package com.ibnshayed.www.customerappdemo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer_app")
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
