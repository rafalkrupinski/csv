package com.hashnot.csv.sage.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.TaxCodeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hashnot.csv.sage.CommonField.*;
import static com.hashnot.csv.sage.report.ProductDetails.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({
        H_STOCK_CODE, H_IGNORED0, H_DESCRIPTION, H_CATEGORY, H_QUANTITY_IN_STOCK, H_UNIT_OF_SALE, H_CATEGORY_DESCRIPTION,
        H_IGNORED1, H_PART_NUMBER, H_IGNORED2, H_IGNORED3, H_SUPPLIER, H_TAX_CODE, H_IGNORED4, H_COST_PRICE,
        H_SALES_NOMINAL_CODE, H_SALES_PRICE, H_IGNORED5,H_IGNORED6, H_IGNORED7, H_LAST_SALE_DATE
})
public class ProductDetails {
    public static final String H_IGNORED0 = "ignored0";
    public static final String H_CATEGORY = "Category";
    public static final String H_UNIT_OF_SALE = "Unit of sale";
    public static final String H_CATEGORY_DESCRIPTION = "Category Description";
    public static final String H_IGNORED1 = "Ignored1";
    public static final String H_PART_NUMBER = "Part Number";
    public static final String H_IGNORED2 = "Ignored2";
    public static final String H_IGNORED3 = "Ignored3";
    public static final String H_SUPPLIER = "Supplier";
    public static final String H_IGNORED4 = "Ignored4";
    public static final String H_SALES_NOMINAL_CODE = "Sales Nominal Code";
    public static final String H_IGNORED5 = "Ignored5";
    public static final String H_IGNORED6 = "Ignored6";
    public static final String H_IGNORED7 = "Ignored7";
    public static final String H_IGNORED8 = "Ignored8";
    public static final String H_LAST_SALE_DATE = "Last Sale Date";

    @JsonProperty(value = H_STOCK_CODE, required = true)
    private String stockCode;

    @JsonProperty(H_IGNORED0)
    private String ignored0;

    @JsonProperty(H_DESCRIPTION)
    private String description;

    @JsonProperty(value = H_CATEGORY, required = true)
    private int category;

    @JsonProperty(value = H_QUANTITY_IN_STOCK, required = true)
    private BigDecimal quantityInStock;

    @JsonProperty(H_UNIT_OF_SALE)
    private String unitsOfSale;

    @JsonProperty(value = H_CATEGORY_DESCRIPTION, required = true)
    private String categoryDescription;

    @JsonProperty(H_IGNORED1)
    private BigDecimal ignored1;

    @JsonProperty(H_PART_NUMBER)
    private String partNumber;

    @JsonProperty(H_IGNORED2)
    private int ignored2;

    @JsonProperty(H_IGNORED3)
    private BigDecimal ignored3;

    @JsonProperty(H_SUPPLIER)
    private String supplier;

    @JsonProperty(H_TAX_CODE)
    @JsonDeserialize(using = TaxCodeDeserializer.class)
    private int taxCode;

    @JsonProperty(H_IGNORED4)
    private String ignored4;

    @JsonProperty(H_COST_PRICE)
    private BigDecimal lastCostPrice;

    @JsonProperty(value = H_SALES_NOMINAL_CODE)
    private int salesNominalCode;

    @JsonProperty(H_SALES_PRICE)
    private BigDecimal lastSalesPrice;

    @JsonProperty(H_IGNORED5)
    private BigDecimal ignored5;

    @JsonProperty(H_IGNORED6)
    private BigDecimal ignored6;

    @JsonProperty(H_IGNORED7)
    private String ignored7;

    @JsonProperty(H_IGNORED8)
    private BigDecimal ignored8;

    @JsonProperty(H_LAST_SALE_DATE)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate lastSaleDate;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getUnitsOfSale() {
        return unitsOfSale;
    }

    public void setUnitsOfSale(String unitsOfSale) {
        this.unitsOfSale = unitsOfSale;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(int taxCode) {
        this.taxCode = taxCode;
    }

    public BigDecimal getLastCostPrice() {
        return lastCostPrice;
    }

    public void setLastCostPrice(BigDecimal lastCostPrice) {
        this.lastCostPrice = lastCostPrice;
    }

    public int getSalesNominalCode() {
        return salesNominalCode;
    }

    public void setSalesNominalCode(int salesNominalCode) {
        this.salesNominalCode = salesNominalCode;
    }

    public LocalDate getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(LocalDate lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    public BigDecimal getLastSalesPrice() {
        return lastSalesPrice;
    }

    public void setLastSalesPrice(BigDecimal lastSalesPrice) {
        this.lastSalesPrice = lastSalesPrice;
    }
}
