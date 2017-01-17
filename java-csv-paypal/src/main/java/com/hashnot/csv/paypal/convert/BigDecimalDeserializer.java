package com.hashnot.csv.paypal.convert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Rafał Krupiński
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> implements ContextualDeserializer {

    private String pattern;

    public BigDecimalDeserializer(String pattern) {
        this.pattern = pattern;
    }

    public BigDecimalDeserializer() {
    }

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String str = p.getValueAsString();
        if (str == null || str.isEmpty())
            return null;
        if (pattern == null)
            return new BigDecimal(str);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
        DecimalFormat parser = (DecimalFormat)nf;
        parser.applyPattern(pattern);

        parser.setParseBigDecimal(true);
        try {
            return (BigDecimal) parser.parse(str);
        } catch (ParseException e) {
            throw new InvalidFormatException(e.getMessage(), p.getCurrentLocation(), str, BigDecimal.class);
        }
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonFormat.Value formatOverrides = property.findFormatOverrides(ctxt.getAnnotationIntrospector());
        if (formatOverrides != null) {
            String pattern = formatOverrides.getPattern();
            if (pattern != null && !pattern.isEmpty())
                return new BigDecimalDeserializer(pattern);
        }
        return this;
    }
}
