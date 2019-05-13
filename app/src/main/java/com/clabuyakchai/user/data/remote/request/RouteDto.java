package com.clabuyakchai.user.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteDto {
    @SerializedName("routeID")
    @Expose
    private Long routeID;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("price")
    @Expose
    private Float price;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("stations")
    @Expose
    private List<StationDto> stations;
    @SerializedName("bus")
    @Expose
    private BusDto bus;

    public RouteDto() {
    }

    public RouteDto(String from, String to, Float price) {
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public RouteDto(Long routeID, String from, String to, Float price, String datetime) {
        this.routeID = routeID;
        this.from = from;
        this.to = to;
        this.price = price;
        this.datetime = datetime;
    }

    public RouteDto(String from, String to, Float price, String datetime, List<StationDto> stations) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.datetime = datetime;
        this.stations = stations;
    }

    public Long getRouteID() {
        return routeID;
    }

    public void setRouteID(Long routeID) {
        this.routeID = routeID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public List<StationDto> getStations() {
        return stations;
    }

    public void setStations(List<StationDto> stations) {
        this.stations = stations;
    }

    public BusDto getBus() {
        return bus;
    }

    public void setBus(BusDto bus) {
        this.bus = bus;
    }
}
