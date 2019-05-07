package com.ibnshayed.www.springdemo0.model;


import lombok.Data;

import java.util.LinkedHashMap;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String,String> countryHashMap;
    private String favoriteLanguage;
    private String[] operatingSystem;
    private String address;

    private String admissionDate;
    private String dressColor;

    public Student() {
        countryHashMap = new LinkedHashMap<>();
        countryHashMap.put("BD","Bangladesh");
        countryHashMap.put("IND","India");
        countryHashMap.put("PK","Pakistan");
        countryHashMap.put("USA","America");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryHashMap() {
        return countryHashMap;
    }

    public void setCountryHashMap(LinkedHashMap<String, String> countryHashMap) {
        this.countryHashMap = countryHashMap;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDressColor() {
        return dressColor;
    }

    public void setDressColor(String dressColor) {
        this.dressColor = dressColor;
    }
}
