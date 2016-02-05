package com.hashnot.csv.sage.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * @author Rafał Krupiński
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            return SageDate.formatter.parse(jsonParser.getText(), LocalDate::from);
        } catch (DateTimeParseException e) {
            throw new InvalidFormatException(jsonParser, "Error while parsing date", null, LocalDate.class);
        }
    }
}
