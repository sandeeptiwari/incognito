package com.solvathon.incognito.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "Policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "policy_id")
    private Long policyId;

    private BigDecimal premium;

    private BigDecimal fees;

    private LocalDate effectiveDate;

    private LocalDate policyExpirationDate;

    private Integer policyYear;

    private String insuranceType;

    private String status;

    private Integer productId;

    private boolean quote;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name="user_policy", joinColumns = {@JoinColumn(name="policy_id",insertable = false,
            updatable = false, referencedColumnName = "policy_id")},
            inverseJoinColumns = {@JoinColumn(name ="user_id" ,insertable = false,
                    updatable = false, referencedColumnName = "id")})
    private User user;

    public Policy(BigDecimal premium,
                  BigDecimal fees,
                  LocalDate effectiveDate,
                  LocalDate policyExpirationDate,
                  Integer policyYear,
                  String insuranceType,
                  String status,
                  boolean quote) {
        this.premium = premium;
        this.fees = fees;
        this.effectiveDate = effectiveDate;
        this.policyExpirationDate = policyExpirationDate;
        this.policyYear = policyYear;
        this.insuranceType = insuranceType;
        this.status = status;
        this.quote = quote;
    }

    public Policy() {

    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public void setFees(BigDecimal fees) {
        this.fees = fees;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    public void setPolicyExpirationDate(LocalDate policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }

    public Integer getPolicyYear() {
        return policyYear;
    }

    public void setPolicyYear(Integer policyYear) {
        this.policyYear = policyYear;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isQuote() {
        return quote;
    }

    public void setQuote(boolean quote) {
        this.quote = quote;
    }
}
