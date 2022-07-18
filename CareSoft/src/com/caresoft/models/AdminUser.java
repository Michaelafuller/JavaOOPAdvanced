package com.caresoft.models;

import com.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.interfaces.HIPAACompliantUser;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

//    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

    public AdminUser(Integer ID, String role) {
        this.id = ID;
        this.role = role;
    }

    public boolean assignPin(int pin) {
        if(pin > 99999) {
            System.out.println("PIN successfully set.");
            super.pin = pin;
            return true;
        }
        else {
            System.out.println("PIN must be 6 digits or more!");
            return false;
        }
    }

    public boolean accessAuthorized(Integer confirmedAuthID) {
        if(this.id.equals(confirmedAuthID)) {
            System.out.println("Identity confirmed.");
            return true;
        }
        else {
            System.out.println("Unauthorized access!");
            authIncident();
            return false;
        }
    }

    public ArrayList<String> reportSecurityIncidents() {
//        System.out.println(securityIncidents);
        return securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n Reported By ID: %s \n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n ID: %s \n Notes: %s \n",
            new Date(), this.id, "Authorization attempt failed for this user"
        );
        securityIncidents.add(report);
    }

    // getters

    @Override
    public int getPin() {
        return super.getPin();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public Integer getEmployeeID() {
        return id;
    }

    public String getRole() {
        return role;
    }

    // setters

    public void setEmployeeID(Integer employeeID) {
        this.id = employeeID;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
