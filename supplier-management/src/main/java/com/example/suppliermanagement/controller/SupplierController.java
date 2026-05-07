package com.example.suppliermanagement.controller;

import com.example.suppliermanagement.dto.SupplierDto;
import com.example.suppliermanagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/add")
    public ResponseEntity<SupplierDto.Response> addSupplier(
            @RequestBody SupplierDto.Request request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplierService.addSupplier(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierDto.Response> updateSupplier(
            @PathVariable Long id,
            @RequestBody SupplierDto.Request request) {

        return ResponseEntity.ok(
                supplierService.updateSupplier(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto.Response> getSupplier(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                supplierService.getSupplier(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(
            @PathVariable Long id) {

        supplierService.deleteSupplier(id);

        return ResponseEntity.ok("Supplier deleted successfully");
    }
}