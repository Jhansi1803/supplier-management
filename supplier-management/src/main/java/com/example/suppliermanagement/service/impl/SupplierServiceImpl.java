package com.example.suppliermanagement.service.impl;

import com.example.suppliermanagement.dto.SupplierDto;
import com.example.suppliermanagement.entity.Supplier;
import com.example.suppliermanagement.event.SupplierEvent;
import com.example.suppliermanagement.kafka.SupplierKafkaProducer;
import com.example.suppliermanagement.repository.SupplierRepository;
import com.example.suppliermanagement.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final SupplierKafkaProducer kafkaProducer;

    @Override
    public SupplierDto.Response addSupplier(SupplierDto.Request request) {

        Supplier supplier = Supplier.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .build();

        Supplier savedSupplier = repository.save(supplier);

        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_CREATED")
                .supplierId(savedSupplier.getId())
                .message("Supplier created successfully")
                .timestamp(LocalDateTime.now())
                .build();

        kafkaProducer.publishEvent(event);

        return SupplierDto.Response.builder()
                .id(savedSupplier.getId())
                .name(savedSupplier.getName())
                .email(savedSupplier.getEmail())
                .phone(savedSupplier.getPhone())
                .address(savedSupplier.getAddress())
                .build();
    }

    @Override
    public SupplierDto.Response updateSupplier(Long id, SupplierDto.Request request) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());

        Supplier updatedSupplier = repository.save(supplier);

        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_UPDATED")
                .supplierId(updatedSupplier.getId())
                .message("Supplier updated successfully")
                .timestamp(LocalDateTime.now())
                .build();

        kafkaProducer.publishEvent(event);

        return SupplierDto.Response.builder()
                .id(updatedSupplier.getId())
                .name(updatedSupplier.getName())
                .email(updatedSupplier.getEmail())
                .phone(updatedSupplier.getPhone())
                .address(updatedSupplier.getAddress())
                .build();
    }

    @Override
    public SupplierDto.Response getSupplier(Long id) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        return SupplierDto.Response.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .address(supplier.getAddress())
                .build();
    }

    @Override
    public void deleteSupplier(Long id) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        repository.deleteById(id);

        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_DELETED")
                .supplierId(supplier.getId())
                .message("Supplier deleted successfully")
                .timestamp(LocalDateTime.now())
                .build();

        kafkaProducer.publishEvent(event);
    }
}