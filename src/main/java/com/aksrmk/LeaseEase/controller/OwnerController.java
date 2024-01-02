package com.aksrmk.LeaseEase.controller;

import com.aksrmk.LeaseEase.dto.OwnerUpdateRequest;
import com.aksrmk.LeaseEase.model.Owner;
import com.aksrmk.LeaseEase.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @PostMapping
    public void registerOwners(@RequestBody Owner owner) {
        ownerService.addOwner(owner);
    }

    @DeleteMapping(path = "{ownerId}")
    public void deleteOwner(@PathVariable("ownerId") String ownerId) {
        ownerService.deleteOwner(ownerId);
    }

    @PutMapping(path = "{ownerId}")
    public void updateOwner(@PathVariable("ownerId") String ownerId,
                            @Valid @RequestBody OwnerUpdateRequest updateRequest) {

        ownerService.updateOwner(ownerId, updateRequest);
    }
}
