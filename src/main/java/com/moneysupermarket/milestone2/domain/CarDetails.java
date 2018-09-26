package com.moneysupermarket.milestone2.domain;

public class CarDetails{
    private String carReg;
    private String carMake;
    private String carModel;
    private Double engSize;

    public CarDetails(String reg, String make, String model, Double size){
        setCarReg(reg);
        setCarMake(make);
        setCarModel(model);
        setEngSize(size);
    }

    public String getCarReg() {
        return carReg;
    }

    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getEngSize() {
        return engSize;
    }

    public void setEngSize(Double engSize) {
        this.engSize = engSize;
    }

}
