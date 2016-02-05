package com.hashnot.csv.sage.factory;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.hashnot.csv.sage.StockTransaction;

import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.NUMBER;
import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.STRING;
import static com.hashnot.csv.sage.StockTransaction.*;

/**
 * @author Rafał Krupiński
 */
public class StockTransactionHandlerFactory {
    private final ObjectReader objectReader;
    private final ObjectWriter objectWriter;

    public StockTransactionHandlerFactory() {
        this(new CsvMapper());
    }

    public StockTransactionHandlerFactory(CsvMapper mapper) {
        CsvSchema schema = CsvSchema.builder()
                .addColumn(H_TYPE, STRING)
                .addColumn(H_STOCK_CODE, STRING)
                .addColumn(H_DATE, STRING)
                .addColumn(H_REFERENCE, STRING)
                .addColumn(H_DETAILS, STRING)
                .addColumn(H_QUANTITY, NUMBER)
                .addColumn(H_COST_PRICE, NUMBER)
                .addColumn(H_SALES_PRICE, NUMBER)
                .addColumn(H_PROJECT_REFN, STRING)
                .addColumn(H_COST_CODE_REFN, STRING).build();
        objectReader = mapper.readerFor(StockTransaction.class).with(schema);
        objectWriter = mapper.writerFor(StockTransaction.class).with(schema);
    }

    public ObjectReader getObjectReader() {
        return objectReader;
    }

    public ObjectWriter getObjectWriter() {
        return objectWriter;
    }
}
