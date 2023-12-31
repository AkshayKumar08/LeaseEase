package com.aksrmk.LeaseEase.config;

import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class OwnerConfig {
    @Bean
    CommandLineRunner commandLineRunner(OwnerRepository ownerRepository){
        return args -> {
            Owner johnDoe = new Owner.OwnerBuilder("john doe",
                        "password",
                        "john.doe@gmail.com",
                        LocalDate.of(1970, Month.JANUARY, 1)).build();
            ownerRepository.save(johnDoe);
        };
    }
}
