package com.janegl.junit.demo.model;

/**
 * Created by jl on 19/6/16.
 */
public class CabUnit {

    /**
     * ctor.
     * @param cabNumber
     * @param driverName
     * @param driverLicence
     * @param seatsAvailable
     * @param cabLocation
     */
    public CabUnit(String cabNumber,
                   String driverName,
                   String driverLicence,
                   int seatsAvailable,
                   String cabLocation,
                   boolean hasUsbCharger) {

        this.cabLocation = cabLocation;
        this.cabNumber = cabNumber;
        this.driverLicence = driverLicence;
        this.driverName = driverName;
        this.seatsAvailable = seatsAvailable;
        this.hasUsbCharger = hasUsbCharger;
    }

    public CabUnit() {

    }

    public String cabNumber;
    public String driverName;
    public String driverLicence;
    public int seatsAvailable;

    public String cabLocation;
    public boolean hasUsbCharger = false;


    @Override
    public String toString() {
        return "CabUnit{" +
                "cabNumber='" + cabNumber + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverLicence='" + driverLicence + '\'' +
                ", seatsAvailable=" + seatsAvailable +
                ", cabLocation='" + cabLocation + '\'' +
                ", hasUsbCharger='" + hasUsbCharger + '\'' +
                '}';
    }
}

