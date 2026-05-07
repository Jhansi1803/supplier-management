package com.example.suppliermanagement.service;

import com.example.suppliermanagement.dto.SupplierDto;

public interface SupplierService {

    SupplierDto.Response addSupplier(SupplierDto.Request request);

    SupplierDto.Response updateSupplier(Long id, SupplierDto.Request request);

    SupplierDto.Response getSupplier(Long id);

    void deleteSupplier(Long id);
}