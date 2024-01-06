package com.aksrmk.LeaseEase.config;

import com.aksrmk.LeaseEase.model.Apartment;
import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.model.Tenant;
import com.aksrmk.LeaseEase.repository.ApartmentRepository;
import com.aksrmk.LeaseEase.repository.OwnerRepository;
import com.aksrmk.LeaseEase.repository.TenantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(OwnerRepository ownerRepository,
                                        TenantRepository tenantRepository,
                                        ApartmentRepository apartmentRepository){
        return args -> {
            Owner johnDoe = new Owner.OwnerBuilder("john doe",
                        "password",
                        "john.doe@gmail.com",
                        LocalDate.of(1970, Month.JANUARY, 1)).build();
            ownerRepository.save(johnDoe);

            Tenant alice = new Tenant.TenantBuilder("alice wonders",
                    "password",
                    "alice.wonders@gmail.com",
                    LocalDate.of(1980, Month.JANUARY, 1)).build();

            tenantRepository.save(alice);
            Apartment m848 = new Apartment(
                    "848 W Mitchell St, Arlington, TX, 76013",
                    2,
                    2,
                    johnDoe);
            apartmentRepository.save(m848);
        };
    }
}
