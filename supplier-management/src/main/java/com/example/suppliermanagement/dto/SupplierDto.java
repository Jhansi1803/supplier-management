package com.example.suppliermanagement.dto;

import lombok.Builder;
import lombok.Data;

public class SupplierDto {

    @Data
    public static class Request {

        private String name;
        private String email;
        private String phone;
        private String address;
    }

    @Data
    @Builder
    public static class Response {

        private Long id;
        private String name;
        private String email;
        private String phone;
        private String address;
    }
}