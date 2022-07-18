package com.caresoft.interfaces;

import java.util.ArrayList;

public interface HIPAACompliantAdmin {
    abstract ArrayList<String> reportSecurityIncidents();

    // Default implemented methods
    // used to print security incidents
    public default void printSecurityIncidents() {
        System.out.println(reportSecurityIncidents());
    }

    // QA Test, pass / fail of reports against QA expected results
    public default boolean adminQATest(ArrayList<String> expectedIncidents) {
        if(reportSecurityIncidents().equals(expectedIncidents)) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        return reportSecurityIncidents().equals(expectedIncidents);
    }
}
