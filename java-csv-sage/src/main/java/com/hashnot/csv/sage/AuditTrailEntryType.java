package com.hashnot.csv.sage;

/**
 * @author Rafał Krupiński
 */
public enum AuditTrailEntryType {
    BR("Bank Receipt"),
    BP("Bank Payment"),
    CP("Cash Payment"),
    CR("Cash Receipt"),
    JD("Journal Debit"),
    JC("Journal Credit"),
    SI("Sales Invoice"),
    SC("Sales Credit Note"),
    SA("Sales Payment on Account"),
    SP("Sales Payment"),
    PI("Purchase Invoice"),
    PC("Purchase Credit Note"),
    PA("Purchase Payment on Account"),
    PR("Purchase Receipt")
    //VP
    //VR
    ;

    final private String description;

    AuditTrailEntryType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
