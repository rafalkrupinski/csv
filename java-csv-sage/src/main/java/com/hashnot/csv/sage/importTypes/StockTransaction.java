package com.hashnot.csv.sage.importTypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hashnot.csv.sage.CommonField;
import com.hashnot.csv.sage.StockTransactionType;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.LocalDateSerializer;
import com.hashnot.csv.sage.convert.PlainStringBigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hashnot.csv.sage.CommonField.*;
import static com.hashnot.csv.sage.importTypes.StockTransaction.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({
        H_TYPE, H_STOCK_CODE, H_DATE, H_REFERENCE, H_DETAILS, H_QUANTITY, H_COST_PRICE, H_SALES_PRICE, H_PROJECT_REFN,
        H_COST_CODE_REFN
})
public class StockTransaction {
    final public static int PRICE_SCALE = 3;

    public static final String H_PROJECT_REFN = "Project Refn";
    public static final String H_COST_CODE_REFN = "Cost Code Refn";

    @JsonProperty(value = H_TYPE, required = true)
    public StockTransactionType type;

    @JsonProperty(value = H_STOCK_CODE, required = true)
    public String stockCode;

    @JsonProperty(value = H_DATE, required = true)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate date;

    @JsonProperty(H_REFERENCE)
    public String reference;

    @JsonProperty(H_DETAILS)
    public String details;

    @JsonProperty(value = H_QUANTITY, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    public BigDecimal quantity;

    @JsonProperty(H_COST_PRICE)
    public BigDecimal costPrice;

    @JsonProperty(H_SALES_PRICE)
    public BigDecimal salesPrice;

    @JsonProperty(H_PROJECT_REFN)
    public String projectRefn;

    @JsonProperty(H_COST_CODE_REFN)
    public String costCodeRefn;

    public StockTransaction() {
    }

    public StockTransaction(StockTransactionType type, String stockCode, LocalDate date, BigDecimal quantity) {
        this.type = type;
        this.stockCode = stockCode;
        this.date = date;
        this.quantity = quantity;
    }

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
