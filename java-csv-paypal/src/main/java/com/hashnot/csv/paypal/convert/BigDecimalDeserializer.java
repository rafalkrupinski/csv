package com.hashnot.csv.paypal.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author Rafał Krupiński
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String str = p.getValueAsString();
        if (str == null || str.isEmpty())
            return null;
        DecimalFormat parser = new DecimalFormat("#,##0.0#");
        parser.setParseBigDecimal(true);
        try {
            return (BigDecimal) parser.parse(str);
        } catch (ParseException e) {
            throw new InvalidFormatException(e.getMessage(), p.getCurrentLocation(), str, BigDecimal.class);
        }
    }
}
