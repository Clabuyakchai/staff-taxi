package com.clabuyakchai.user.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusDto {
    @SerializedName("busID")
    @Expose
    private Long busID;
    @SerializedName("busmodel")
    @Expose
    private String busmodel;
    @SerializedName("carNumber")
    @Expose
    private String carNumber;
    @SerializedName("countSeat")
    @Expose
    private Integer countSeat;

    public BusDto() {
    }

    public BusDto(Long busID, String busmodel, String carNumber, Integer countSeat) {
        this.busID = busID;
        this.busmodel = busmodel;
        this.carNumber = carNumber;
        this.countSeat = countSeat;
    }

    public Long getBusID() {
        return busID;
    }

    public void setBusID(Long busID) {
        this.busID = busID;
    }

    public String getBusmodel() {
        return busmodel;
    }

    public void setBusmodel(String busmodel) {
        this.busmodel = busmodel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getCountSeat() {
        return countSeat;
    }

    public void setCountSeat(Integer countSeat) {
        this.countSeat = countSeat;
    }
}
