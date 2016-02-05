package com.hashnot.csv.sage.factory;


import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.hashnot.csv.sage.AuditTrailEntry;

import static com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType.*;
import static com.hashnot.csv.sage.AuditTrailEntry.*;

/**
 * @author Rafał Krupiński
 */
public class AuditTrailEntryHandlerFactory {
    private ObjectWriter objectWriter;
    private ObjectReader objectReader;

    public AuditTrailEntryHandlerFactory() {
        this(new CsvMapper());
    }

    public AuditTrailEntryHandlerFactory(CsvMapper mapper) {
        CsvSchema.Builder builder = CsvSchema.builder();
        builder.addColumn(H_TYPE, STRING);
        builder.addColumn(H_ACCOUNT_REFERENCE, NUMBER_OR_STRING);
        builder.addColumn(H_NOMINAL_AC_REF, NUMBER);
        builder.addColumn(H_DEPARTMENT_CODE, NUMBER);
        builder.addColumn(H_DATE, STRING);
        builder.addColumn(H_REFERENCE, STRING);
        builder.addColumn(H_DETAILS, STRING);
        builder.addColumn(H_NET_AMOUNT, NUMBER);
        builder.addColumn(H_TAX_CODE, STRING);
        builder.addColumn(H_TAX_AMOUNT, NUMBER);
        builder.addColumn(H_EXCHANGE_RATE, NUMBER);
        builder.addColumn(H_EXTRA_REFERENCE, STRING);
        builder.addColumn(H_USER_NAME, STRING);
        builder.addColumn(H_PROJECT_REFN, STRING);
        builder.addColumn(H_COST_CODE_REFN, STRING);
        builder.setUseHeader(true);

        CsvSchema schema = builder.build();
        objectWriter = mapper.writerFor(AuditTrailEntry.class).with(schema);
        objectReader = mapper.readerFor(AuditTrailEntry.class).with(schema);
    }

    public ObjectWriter getObjectWriter() {
        return objectWriter;
    }

    public ObjectReader getObjectReader() {
        return objectReader;
    }
}
