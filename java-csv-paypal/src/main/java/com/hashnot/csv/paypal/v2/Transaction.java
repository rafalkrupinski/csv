package com.hashnot.csv.paypal.v2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.csv.paypal.convert.BigDecimalDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import static com.hashnot.csv.paypal.v2.Transaction.*;

/**
 * @author Rafał Krupiński
 */
@JsonPropertyOrder({
        F_DATE, F_TIME, F_TIME_ZONE, F_NAME, F_TYPE, F_STATUS, F_CURRENCY, F_GROSS, F_FEE, F_NET,
        F_FROM_EMAIL_ADDRESS, F_TO_EMAIL_ADDRESS, F_TRANSACTION_ID, F_SHIPPING_ADDRESS,
        F_ADDRESS_STATUS, F_ITEM_TITLE, F_ITEM_ID, F_SHIPPING_AMOUNT, F_INSURANCE_AMOUNT, F_SALES_TAX,
        F_OPTION_1_NAME, F_OPTION_1_VALUE, F_OPTION_2_NAME, F_OPTION_2_VALUE,
        F_REFERENCE_TXN, F_INVOICE_NUMBER, F_CUSTOM_NUMBER,
        F_QUANTITY, F_RECEIPT_ID, F_BALANCE, F_ADDRESS_LINE_1, F_ADDRESS_LINE_2, F_CITY, F_REGION, F_POSTAL_CODE, F_COUNTRY,
        F_PHONE_NUMBER, F_SUBJECT, F_NOTE, F_COUNTRY_CODE, F_BALANCE_IMPACT
})
public class Transaction {
    static final String F_DATE = "Date";
    static final String F_TIME = "Time";
    static final String F_TIME_ZONE = "Time Zone";
    static final String F_NAME = "Name";
    static final String F_TYPE = "Type";
    static final String F_STATUS = "Status";
    static final String F_SUBJECT = "Subject";
    static final String F_CURRENCY = "Currency";
    static final String F_GROSS = "Gross";
    static final String F_FEE = "Fee";
    static final String F_NET = "Net";
    static final String F_NOTE = "Note";
    static final String F_FROM_EMAIL_ADDRESS = "From Email Address";
    static final String F_TO_EMAIL_ADDRESS = "To Email Address";
    static final String F_TRANSACTION_ID = "Transaction ID";
    static final String F_SHIPPING_ADDRESS = "Shipping Address";
    static final String F_ADDRESS_STATUS = "Address Status";
    static final String F_ITEM_TITLE = "Item title";
    static final String F_ITEM_ID = "Item ID";
    static final String F_SHIPPING_AMOUNT = "Shipping and Handling Amount";
    static final String F_INSURANCE_AMOUNT = "Insurance Amount";
    static final String F_SALES_TAX = "Sales Tax";
    static final String F_OPTION_1_NAME = "Option 1 Name";
    static final String F_OPTION_1_VALUE = "Option 1 Value";
    static final String F_OPTION_2_NAME = "Option 2 Name";
    static final String F_OPTION_2_VALUE = "Option 2 Value";
    static final String F_REFERENCE_TXN = "Reference Txn";
    static final String F_INVOICE_NUMBER = "Invoice Number";
    static final String F_CUSTOM_NUMBER = "Custom Number";
    static final String F_QUANTITY = "Quantity";
    static final String F_RECEIPT_ID = "Receipt ID";
    static final String F_BALANCE = "Balance";
    static final String F_ADDRESS_LINE_1 = "Address Line 1";
    static final String F_ADDRESS_LINE_2 = "Address Line 2/District/Neighborhood";
    static final String F_CITY = "Town/City";
    static final String F_REGION = "State/Province/Region/County/Territory/Prefecture/Republic";
    static final String F_POSTAL_CODE = "Zip/Postal Code";
    static final String F_COUNTRY = "Country";
    static final String F_COUNTRY_CODE = "Country Code";
    static final String F_PHONE_NUMBER = "Contact Phone Number";
    static final String F_BALANCE_IMPACT = "Balance Impact";

    private static final String DATE_FORMAT = "M/d/yyyy";

    @JsonProperty(value = F_DATE, required = true)
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDate date;

    @JsonProperty(value = F_TIME, required = true)
    private LocalTime time;

    @JsonProperty(value = F_TIME_ZONE, required = true)
    private TimeZone timeZone;

    @JsonProperty(value = F_NAME, required = true)
    private String name;

    @JsonProperty(value = F_TYPE, required = true)
    private String type;

    @JsonProperty(value = F_STATUS, required = true)
    private Status status;

    @JsonProperty(F_SUBJECT)
    private String subject;

    @JsonProperty(value = F_CURRENCY, required = true)
    private String currency;

    @JsonProperty(value = F_GROSS, required = true)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal gross;

    @JsonProperty(value = F_FEE, required = true)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal fee;

    @JsonProperty(value = F_NET, required = true)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal net;

    @JsonProperty(F_NOTE)
    private String note;

    @JsonProperty(F_FROM_EMAIL_ADDRESS)
    private String fromEmailAddress;

    @JsonProperty(F_TO_EMAIL_ADDRESS)
    private String toEmailAddress;

    @JsonProperty(value = F_TRANSACTION_ID, required = true)
    private String txId;

    @JsonProperty(F_SHIPPING_ADDRESS)
    private String shippingAddress;

    @JsonProperty(F_ADDRESS_STATUS)
    private String addressStatus;

    @JsonProperty(F_ITEM_TITLE)
    private String itemTitle;

    @JsonProperty(F_ITEM_ID)
    private String itemId;

    @JsonProperty(F_SHIPPING_AMOUNT)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal shipping;

    @JsonProperty(F_INSURANCE_AMOUNT)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal insurance;

    @JsonProperty(F_SALES_TAX)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal salesTax;

    @JsonProperty(F_OPTION_1_NAME)
    private String option1Name;

    @JsonProperty(F_OPTION_1_VALUE)
    private String option1Value;

    @JsonProperty(F_OPTION_2_NAME)
    private String option2Name;

    @JsonProperty(F_OPTION_2_VALUE)
    private String option2Value;

    @JsonProperty(F_REFERENCE_TXN)
    private String refTxId;

    @JsonProperty(F_INVOICE_NUMBER)
    private String invoiceNo;

    @JsonProperty(F_CUSTOM_NUMBER)
    private String customNumber;

    @JsonProperty(F_QUANTITY)
    private Integer quantity;

    @JsonProperty(F_RECEIPT_ID)
    private String receiptId;

    @JsonProperty(value = F_BALANCE, required = true)
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    @JsonFormat(pattern = "#,##0.0#")
    private BigDecimal balance;

    @JsonProperty(F_ADDRESS_LINE_1)
    private String addressLine1;

    @JsonProperty(F_ADDRESS_LINE_2)
    private String addressLine2;

    @JsonProperty(F_CITY)
    private String city;

    @JsonProperty(F_REGION)
    private String region;

    @JsonProperty(F_POSTAL_CODE)
    private String postalCode;

    @JsonProperty(F_COUNTRY)
    private String country;

    @JsonProperty(F_PHONE_NUMBER)
    private String phoneNumber;

    @JsonProperty(F_COUNTRY_CODE)
    private String countryCode;

    @JsonProperty(value = F_BALANCE_IMPACT, required = true)
    private Direction balanceImpact;

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    public void setFromEmailAddress(String fromEmailAddress) {
        this.fromEmailAddress = fromEmailAddress;
    }

    public String getToEmailAddress() {
        return toEmailAddress;
    }

    public void setToEmailAddress(String toEmailAddress) {
        this.toEmailAddress = toEmailAddress;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public String getOption1Name() {
        return option1Name;
    }

    public void setOption1Name(String option1Name) {
        this.option1Name = option1Name;
    }

    public String getOption1Value() {
        return option1Value;
    }

    public void setOption1Value(String option1Value) {
        this.option1Value = option1Value;
    }

    public String getOption2Name() {
        return option2Name;
    }

    public void setOption2Name(String option2Name) {
        this.option2Name = option2Name;
    }

    public String getOption2Value() {
        return option2Value;
    }

    public void setOption2Value(String option2Value) {
        this.option2Value = option2Value;
    }

    public String getRefTxId() {
        return refTxId;
    }

    public void setRefTxId(String refTxId) {
        this.refTxId = refTxId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getCustomNumber() {
        return customNumber;
    }

    public void setCustomNumber(String customNumber) {
        this.customNumber = customNumber;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Direction getBalanceImpact() {
        return balanceImpact;
    }

    public void setBalanceImpact(Direction balanceImpact) {
        this.balanceImpact = balanceImpact;
    }
}
