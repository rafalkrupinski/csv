package com.hashnot.csv.paypal.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.hashnot.csv.paypal.Transaction.Status;

import java.io.IOException;

/**
 * @author Rafał Krupiński
 */
public class StatusDeserializer extends JsonDeserializer<Status> {
    @Override
    public Status deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        if ("Partially Refunded".equals(value))
            return Status.PartiallyRefunded;
        else
            return Status.valueOf(value);
    }
}
