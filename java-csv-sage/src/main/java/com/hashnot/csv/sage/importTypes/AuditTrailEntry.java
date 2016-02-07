package com.hashnot.csv.sage.importTypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hashnot.csv.sage.AuditTrailEntryType;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.LocalDateSerializer;
import com.hashnot.csv.sage.convert.TaxCodeDeserializer;
import com.hashnot.csv.sage.convert.TaxCodeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hashnot.csv.sage.CommonField.*;
import static com.hashnot.csv.sage.importTypes.AuditTrailEntry.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({
        H_TYPE, H_ACCOUNT_REFERENCE, H_NOMINAL_AC_REF, H_DEPARTMENT_CODE, H_DATE, H_REFERENCE, H_DETAILS, H_NET_AMOUNT,
        H_TAX_CODE, H_TAX_AMOUNT, H_EXCHANGE_RATE, H_EXTRA_REFERENCE, H_USER_NAME, H_PROJECT_REFN, H_COST_CODE_REFN
})
public class AuditTrailEntry {
    public static final String H_ACCOUNT_REFERENCE = "Account Reference";
    public static final String H_NOMINAL_AC_REF = "Nominal A/C Ref";
    public static final String H_DEPARTMENT_CODE = "Department Code";
    public static final String H_NET_AMOUNT = "Net Amount";
    public static final String H_TAX_AMOUNT = "Tax Amount";
    public static final String H_EXCHANGE_RATE = "Exchange Rate";
    public static final String H_EXTRA_REFERENCE = "Extra Reference";
    public static final String H_USER_NAME = "User Name";
    public static final String H_PROJECT_REFN = "Project Refn";
    public static final String H_COST_CODE_REFN = "Cost Code Refn";

    @JsonProperty(value = H_TYPE, required = true)
    private AuditTrailEntryType type;

    @JsonProperty(value = H_ACCOUNT_REFERENCE, required = true)
    private String accountReference;

    @JsonProperty(value = H_NOMINAL_AC_REF, required = true)
    private int nominalACRef;

    @JsonProperty(H_DEPARTMENT_CODE)
    private Integer departmentCode;

    @JsonProperty(value = H_DATE, required = true)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty(H_REFERENCE)
    private String reference;

    @JsonProperty(H_DETAILS)
    private String details;

    @JsonProperty(value = H_NET_AMOUNT, required = true)
    private BigDecimal netAmount;

    // store as "T"+code
    @JsonProperty(value = H_TAX_CODE, required = true)
    @JsonSerialize(using = TaxCodeSerializer.class)
    @JsonDeserialize(using = TaxCodeDeserializer.class)
    private int taxCode;

    @JsonProperty(value = H_TAX_AMOUNT, required = true)
    private BigDecimal taxAmount;

    @JsonProperty(H_EXCHANGE_RATE)
    private BigDecimal exchangeRate;

    @JsonProperty(H_EXTRA_REFERENCE)
    private String extraReference;

    @JsonProperty(H_USER_NAME)
    private String userName;

    @JsonProperty(H_PROJECT_REFN)
    private String projectReference;

    @JsonProperty(H_COST_CODE_REFN)
    private String costCodeReference;

    public AuditTrailEntry() {
    }

    public AuditTrailEntry(AuditTrailEntryType type, String accountReference, int nominalACRef, LocalDate date, BigDecimal netAmount, int taxCode, BigDecimal taxAmount) {
        this.type = type;
        this.accountReference = accountReference;
        this.nominalACRef = nominalACRef;
        this.date = date;
        this.netAmount = netAmount;
        this.taxCode = taxCode;
        this.taxAmount = taxAmount;
    }

    public AuditTrailEntryType getType() {
        return type;
    }

    public void setType(AuditTrailEntryType type) {
        this.type = type;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    public int getNominalACRef() {
        return nominalACRef;
    }

    public void setNominalACRef(int nominalACRef) {
        this.nominalACRef = nominalACRef;
    }

    public Integer getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public int getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(int taxCode) {
        this.taxCode = taxCode;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getExtraReference() {
        return extraReference;
    }

    public void setExtraReference(String extraReference) {
        this.extraReference = extraReference;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(String projectReference) {
        this.projectReference = projectReference;
    }

    public String getCostCodeReference() {
        return costCodeReference;
    }

    public void setCostCodeReference(String costCodeReference) {
        this.costCodeReference = costCodeReference;
    }
}
