package com.blooddonate.eis;

import com.blooddonate.eis.model.BloodType;
import com.blooddonate.eis.model.Donor;
import com.blooddonate.eis.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BloodDonateApplication {
    @Autowired
    private DonorRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BloodDonateApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            repository.saveAll(List.of(
                            new Donor("Abul Mia", "abulmia@gmail.com", "0123456789", "Dohar", BloodType.A_POSITIVE),
                            new Donor("Babul Ahmed", "babulahmed@gmail.com", "01552546789", "Gulistan", BloodType.O_POSITIVE),
                            new Donor("Kabul Ali", "kabulali@gmail.com", "0123464229", "Banani", BloodType.AB_POSITIVE),
                            new Donor("Rahim Khandakar", "rahim2018@gmail.com", "0123445789", "Badda", BloodType.B_POSITIVE),
                            new Donor("Alisha Baloch", "alisha2020@gmail.com", "0128421547", "Kakrail", BloodType.A_NEGETIVE)
            ));

            repository.findAll().forEach(System.out::println);
            System.out.println("A_POSITIVE : " + BloodType.A_NEGETIVE);
        };
    }

}
