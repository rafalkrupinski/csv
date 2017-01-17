package com.hashnot.csv.sage.importTypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hashnot.csv.sage.convert.LocalDateDeserializer;
import com.hashnot.csv.sage.convert.LocalDateSerializer;
import com.hashnot.csv.sage.convert.PlainStringBigDecimalSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hashnot.csv.sage.CommonField.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({H_STOCK_CODE, H_DATE, H_REFERENCE, H_ACTUAL})
public class StockTakeEntry {

    @JsonProperty(value = H_STOCK_CODE, required = true)
    private String stockCode;

    @JsonProperty(value = H_DATE, required = true)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty(H_REFERENCE)
    private String reference;

    @JsonProperty(value = H_ACTUAL, required = true)
    @JsonSerialize(using = PlainStringBigDecimalSerializer.class)
    private BigDecimal actual;

    public StockTakeEntry() {
    }

    public StockTakeEntry(String stockCode, LocalDate date, BigDecimal actual) {
        this.stockCode = stockCode;
        this.date = date;
        this.actual = actual;
    }

    public StockTakeEntry(String stockCode, LocalDate date, String reference, BigDecimal actual) {
        this.stockCode = stockCode;
        this.date = date;
        this.reference = reference;
        this.actual = actual;
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

    public BigDecimal getActual() {
        return actual;
    }

    public void setActual(BigDecimal actual) {
        this.actual = actual;
    }
}
