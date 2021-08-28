package com.solvathon.incognito.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Policy {
    private Integer policyId;
    private BigDecimal premium;
    private BigDecimal fees;
    private LocalDate effectiveDate;
    private LocalDate policyExpirationDate;
    private Integer policyYear;
    private String insuranceType;
    private String status;
    private Integer userId;
    private Integer productId;
}
