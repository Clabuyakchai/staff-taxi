package com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter;

public class StationItemWithSwitch {
    private Long stationID;
    private String name;
    private String city;
    private String lat;
    private String lng;
    private Boolean isShow;

    public StationItemWithSwitch() {
    }

    public StationItemWithSwitch(Long stationID, String name, String city, String lat, String lng) {
        this.stationID = stationID;
        this.name = name;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.isShow = false;
    }

    public Long getStationID() {
        return stationID;
    }

    public void setStationID(Long stationID) {
        this.stationID = stationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }
}
