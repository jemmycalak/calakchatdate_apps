package com.jemmy.calak.chatdate.Model;

import java.io.Serializable;

/**
 * Created by JEMMY CALAK on 4/5/2018.
 */

public class User implements Serializable{
    String idUser, nmUser, emailUser, birthDateUser, fotoUser, bioUser, userNameUser, ageUser, genderUser, addressUser, longitudeUser, latitudeUser, tokenFirebaseUser, isOnline;

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getBirthDateUser() {
        return birthDateUser;
    }

    public void setBirthDateUser(String birthDateUser) {
        this.birthDateUser = birthDateUser;
    }

    public String getFotoUser() {
        return fotoUser;
    }

    public void setFotoUser(String fotoUser) {
        this.fotoUser = fotoUser;
    }

    public String getBioUser() {
        return bioUser;
    }

    public void setBioUser(String bioUser) {
        this.bioUser = bioUser;
    }

    public String getUserNameUser() {
        return userNameUser;
    }

    public void setUserNameUser(String userNameUser) {
        this.userNameUser = userNameUser;
    }

    public String getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(String ageUser) {
        this.ageUser = ageUser;
    }

    public String getGenderUser() {
        return genderUser;
    }

    public void setGenderUser(String genderUser) {
        this.genderUser = genderUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getLongitudeUser() {
        return longitudeUser;
    }

    public void setLongitudeUser(String longitudeUser) {
        this.longitudeUser = longitudeUser;
    }

    public String getLatitudeUser() {
        return latitudeUser;
    }

    public void setLatitudeUser(String latitudeUser) {
        this.latitudeUser = latitudeUser;
    }

    public String getTokenFirebaseUser() {
        return tokenFirebaseUser;
    }

    public void setTokenFirebaseUser(String tokenFirebaseUser) {
        this.tokenFirebaseUser = tokenFirebaseUser;
    }
}
