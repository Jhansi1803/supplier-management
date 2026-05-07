package com.example.suppliermanagement.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEvent {

    private String eventType;
    private Long supplierId;
    private String message;
    private LocalDateTime timestamp;
}