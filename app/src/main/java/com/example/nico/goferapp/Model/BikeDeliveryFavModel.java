package com.example.nico.goferapp.Model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Nico on 2/28/2017.
 */

public class BikeDeliveryFavModel extends SugarRecord {

    public String nameto;
    public String addressto;
    public String contactnumberto;
    public String namefrom;
    public String addressfrom;
    public String contactnumberfrom;
    public String notes;
    public String name;

    public BikeDeliveryFavModel() {
    }

    public String getNameTo() {
        return nameto;
    }

    public String getAddressTo() {
        return addressto;
    }

    public String getContactnumberTo() {
        return contactnumberto;
    }

    public String getNameFrom() {
        return namefrom;
    }

    public String getAddressFrom() {
        return addressfrom;
    }

    public String getContactnumberFrom() {
        return contactnumberfrom;
    }

    public String getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }

    public BikeDeliveryFavModel(String nameto, String addressto, String contactnumberto, String namefrom, String addressfrom, String contactnumberfrom, String notes, String name) {
        this.nameto = nameto;
        this.addressto = addressto;
        this.contactnumberto = contactnumberto;
        this.namefrom = namefrom;
        this.addressfrom = addressfrom;
        this.contactnumberfrom = contactnumberfrom;
        this.notes = notes;
        this.name = name;
    }

    public static List<BikeDeliveryFavModel> getFavorites() {
        return BikeDeliveryFavModel.findWithQuery(BikeDeliveryFavModel.class, "SELECT * FROM bike_delivery_fav_model ORDER BY name ASC");
    }

    public static List<BikeDeliveryFavModel> getListNameTo() {
        return BikeDeliveryFavModel.findWithQuery(BikeDeliveryFavModel.class, "SELECT nameto FROM bike_delivery_fav_model");
    }

}
