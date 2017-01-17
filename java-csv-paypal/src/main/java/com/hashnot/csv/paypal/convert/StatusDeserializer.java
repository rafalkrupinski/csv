package com.hashnot.csv.paypal.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.hashnot.csv.paypal.Transaction;

import java.io.IOException;

/**
 * @author Rafał Krupiński
 */
public class StatusDeserializer extends JsonDeserializer<Transaction.Status> {
    @Override
    public Transaction.Status deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if ("Partially Refunded".equals(value))
            return Transaction.Status.PartiallyRefunded;
        else
            return Transaction.Status.valueOf(value);
    }
}
