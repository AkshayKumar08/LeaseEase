package com.aksrmk.LeaseEase.controller;

import com.aksrmk.LeaseEase.dto.ApartmentUpdateRequest;
import com.aksrmk.LeaseEase.model.Apartment;
import com.aksrmk.LeaseEase.service.ApartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Apartment> getApartments() {
        return apartmentService.getApartments();
    }

    @PostMapping
    public void registerApartment(@RequestBody Apartment apartment) {
        apartmentService.addApartment(apartment);
    }

    @DeleteMapping(path = "{apartmentId}")
    public void deleteApartment(@PathVariable("apartmentId") String apartmentId) {
        apartmentService.deleteApartment(apartmentId);
    }

    @PutMapping(path = "{apartmentId}")
    public void updateApartment(@PathVariable("apartmentId") String apartmentId,
                            @Valid @RequestBody ApartmentUpdateRequest updateRequest) {

        apartmentService.updateApartment(apartmentId, updateRequest);
    }
}
