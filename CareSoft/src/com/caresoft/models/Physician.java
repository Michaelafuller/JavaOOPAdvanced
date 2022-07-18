package com.caresoft.models;

import com.caresoft.interfaces.HIPAACompliantUser;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        this.id = id;
    }

    public boolean assignPin(int pin) {
        if(pin < 10000 && pin > 999) {
            System.out.println("PIN successfully set.");
            this.pin = pin;
            return true;
        }
        else {
            System.out.println("PIN must be exactly 4 digits!");
            return false;
        }
    }

    public boolean accessAuthorized(Integer confirmedAuthID) {
        return this.id.equals(confirmedAuthID);
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
                "Datetime Submitted: %s \n", date
        );
        report += String.format("Reported by ID: %s \n", this.id);
        report += String.format("Patient Name: %s \n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // getters
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public int getPin() {
        return super.getPin();
    }

    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    // setters

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }

}
