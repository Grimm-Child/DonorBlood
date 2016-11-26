package com.styx.gta.donorblood.models;

import com.styx.gta.donorblood.constants.Constants;

import java.io.Serializable;

/**
 * Created by amal.george on 25-11-2016.
 */

public class Donor implements Serializable {
    private String address, bloodGroup, contact, dob, name, sex;

    public Donor() {
    }

    public String getAddress() {
        return address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getContact() {
        return contact;
    }

    public String getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
}
