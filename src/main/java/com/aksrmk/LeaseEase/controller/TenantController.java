package com.aksrmk.LeaseEase.controller;

import com.aksrmk.LeaseEase.dto.TenantUpdateRequest;
import com.aksrmk.LeaseEase.model.Tenant;
import com.aksrmk.LeaseEase.service.TenantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/tenant")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<Tenant> getTenants() {
        return tenantService.getTenants();
    }

    @PostMapping
    public void registerTenants(@RequestBody Tenant tenant) {
        tenantService.addTenant(tenant);
    }

    @DeleteMapping(path = "{tenantId}")
    public void deleteTenant(@PathVariable("tenantId") String tenantId) {
        tenantService.deleteTenant(tenantId);
    }

    @PutMapping(path = "{tenantId}")
    public void updateTenant(@PathVariable("tenantId") String tenantId,
                            @Valid @RequestBody TenantUpdateRequest updateRequest) {

        tenantService.updateTenant(tenantId, updateRequest);
    }
}
