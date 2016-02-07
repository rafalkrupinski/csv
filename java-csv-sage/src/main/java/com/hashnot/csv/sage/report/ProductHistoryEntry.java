package com.hashnot.csv.sage.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hashnot.csv.sage.StockTransactionType;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.PlainStringBigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hashnot.csv.sage.CommonField.*;
import static com.hashnot.csv.sage.report.ProductHistoryEntry.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({
        H_STOCK_CODE, H_DESCRIPTION, H_TYPE, H_DATE, H_REFERENCE, H_DETAILS, H_QUANTITY, H_QUANTITY_USED, H_COST_PRICE,
        H_SALES_PRICE, H_QUANTITY_IN_STOCK, H_QUANTITY_ON_ORDER, H_QUANTITY_ALLOCATED
})
public class ProductHistoryEntry {
    public static final String H_QUANTITY_USED = "Quantity used";
    public static final String H_QUANTITY_ON_ORDER = "Quantity on Order";
    public static final String H_QUANTITY_ALLOCATED = "Quantity Allocated";

    @JsonProperty(value = H_STOCK_CODE, required = true)
    private String stockCode;

    @JsonProperty(value = H_DESCRIPTION, required = true)
    private String description;

    @JsonProperty(H_TYPE)
    private StockTransactionType type;

    @JsonProperty(H_DATE)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty(H_REFERENCE)
    private String reference;

    @JsonProperty(H_DETAILS)
    private String details;

    @JsonProperty(value = H_QUANTITY, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal quantity;

    @JsonProperty(H_QUANTITY_USED)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal quantityUsed;

    @JsonProperty(H_COST_PRICE)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal costPrice;

    @JsonProperty(H_SALES_PRICE)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal salesPrice;

    @JsonProperty(value = H_QUANTITY_IN_STOCK, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal quantityInStock;

    @JsonProperty(value = H_QUANTITY_ON_ORDER, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal quantityOnOrder;

    @JsonProperty(value = H_QUANTITY_ALLOCATED, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal quantityAllocated;

    public ProductHistoryEntry() {
    }

    public ProductHistoryEntry(String stockCode, String description, BigDecimal quantity, BigDecimal quantityInStock, BigDecimal quantityOnOrder, BigDecimal quantityAllocated) {
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.quantityInStock = quantityInStock;
        this.quantityOnOrder = quantityOnOrder;
        this.quantityAllocated = quantityAllocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductHistoryEntry that = (ProductHistoryEntry) o;

        if (!stockCode.equals(that.stockCode)) return false;
        if (!description.equals(that.description)) return false;
        if (type != that.type) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (!quantity.equals(that.quantity)) return false;
        if (quantityUsed != null ? !quantityUsed.equals(that.quantityUsed) : that.quantityUsed != null) return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (salesPrice != null ? !salesPrice.equals(that.salesPrice) : that.salesPrice != null) return false;
        if (!quantityInStock.equals(that.quantityInStock)) return false;
        if (!quantityOnOrder.equals(that.quantityOnOrder)) return false;
        return quantityAllocated.equals(that.quantityAllocated);

    }

    @Override
    public int hashCode() {
        int result = stockCode.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + quantity.hashCode();
        result = 31 * result + (quantityUsed != null ? quantityUsed.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (salesPrice != null ? salesPrice.hashCode() : 0);
        result = 31 * result + quantityInStock.hashCode();
        result = 31 * result + quantityOnOrder.hashCode();
        result = 31 * result + quantityAllocated.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductHistoryEntry{" +
                "stockCode='" + stockCode + '\'' +
                ", type=" + type +
                ", date=" + date +
                ", reference='" + reference + '\'' +
                ", details='" + details + '\'' +
                ", quantity=" + quantity +
                ", costPrice=" + costPrice +
                ", salesPrice=" + salesPrice +
                '}';
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StockTransactionType getType() {
        return type;
    }

    public void setType(StockTransactionType type) {
        this.type = type;
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

    public BigDecimal getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(BigDecimal quantityUsed) {
        this.quantityUsed = quantityUsed;
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

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getQuantityOnOrder() {
        return quantityOnOrder;
    }

    public void setQuantityOnOrder(BigDecimal quantityOnOrder) {
        this.quantityOnOrder = quantityOnOrder;
    }

    public BigDecimal getQuantityAllocated() {
        return quantityAllocated;
    }

    public void setQuantityAllocated(BigDecimal quantityAllocated) {
        this.quantityAllocated = quantityAllocated;
    }
}
