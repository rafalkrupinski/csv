package com.hashnot.csv.sage;

/**
 * @author Rafał Krupiński
 */
public enum StockTransactionType {
    /**
     * Adjustment in
     */
    AI,
    /**
     * Adjustment Out
     */
    AO,
    /**
     * Goods Returned - using credit notes
     */
    GR,
    /**
     * Goods out
     */
    GO,
    /**
     * Goods in
     */
    GI,
    /**
     * Damages In
     */
    DI,
    /**
     * Damages Out
     */
    DO,
    /**
     * Write Off
     */
    WO
}
