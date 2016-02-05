package com.hashnot.csv.sage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.LocalDateSerializer;
import com.hashnot.csv.sage.convert.PlainStringBigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Rafał Krupiński
 */
public class StockTransaction {
    public static final String H_TYPE = "Type";
    public static final String H_STOCK_CODE = "Stock Code";
    public static final String H_DATE = "Date";
    public static final String H_REFERENCE = "Reference";
    public static final String H_DETAILS = "Details";
    public static final String H_QUANTITY = "Quantity";
    public static final String H_COST_PRICE = "Cost Price";
    public static final String H_SALES_PRICE = "Sales Price";
    public static final String H_PROJECT_REFN = "Project Refn";
    public static final String H_COST_CODE_REFN = "Cost Code Refn";

    @JsonProperty(value = H_TYPE, required = true, index = 0)
    public StockTransactionType type;

    @JsonProperty(value = H_STOCK_CODE, required = true, index = 1)
    public String stockCode;

    @JsonProperty(value = H_DATE, required = true, index = 2)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate date;

    @JsonProperty(value = H_REFERENCE, required = false, index = 3)
    public String reference;

    @JsonProperty(value = H_DETAILS, required = false, index = 4)
    public String details;

    @JsonProperty(value = H_QUANTITY, required = true, index = 5)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    public BigDecimal quantity;

    @JsonProperty(value = H_COST_PRICE, required = false, index = 6)
    public BigDecimal costPrice;

    @JsonProperty(value = H_SALES_PRICE, required = false, index = 7)
    public BigDecimal salesPrice;

    @JsonProperty(value = H_PROJECT_REFN, required = false, index = 8)
    public String projectRefn;

    @JsonProperty(value = H_COST_CODE_REFN, required = false, index = 9)
    public String costCodeRefn;

    public StockTransactionType getType() {
        return type;
    }

    public void setType(StockTransactionType type) {
        this.type = type;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getProjectRefn() {
        return projectRefn;
    }

    public void setProjectRefn(String projectRefn) {
        this.projectRefn = projectRefn;
    }

    public String getCostCodeRefn() {
        return costCodeRefn;
    }

    public void setCostCodeRefn(String costCodeRefn) {
        this.costCodeRefn = costCodeRefn;
    }
}
