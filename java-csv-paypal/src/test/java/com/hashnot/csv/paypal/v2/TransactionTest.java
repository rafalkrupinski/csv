package com.hashnot.csv.paypal.v2;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * @author Rafał Krupiński
 */
public class TransactionTest {
    @Test
    public void testDeserialize() throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.findAndRegisterModules();
        CsvSchema schema = mapper.typedSchemaFor(Transaction.class).withHeader();
        ObjectReader objectReader = mapper.readerFor(Transaction.class).with(schema);
        MappingIterator<Transaction> mappingIterator = objectReader.readValues(getClass().getResourceAsStream("paypal.csv"));

        Transaction tx = mappingIterator.next();
        assertEquals(LocalDate.of(2016, 3, 18), tx.getDate());
        assertEquals(LocalTime.of(21, 12, 4), tx.getTime());
        assertEquals(TimeZone.getTimeZone("GMT"), tx.getTimeZone());
        Assert.assertEquals(Direction.Credit, tx.getBalanceImpact());
    }
}
