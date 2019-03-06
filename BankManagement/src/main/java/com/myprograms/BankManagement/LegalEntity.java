package com.myprograms.BankManagement;

public class LegalEntity extends Client {

    public LegalEntity(String name, String address, String regNumber, double cash) {
        this.name = name;
        this.address = address;
        this.regNumber = regNumber;
        this.cash = cash;
    }

    public LegalEntity(String name, String address, String regNumber, double cash, double percent, int days) {
        this.name = name;
        this.address = address;
        this.regNumber = regNumber;
        this.cash = cash;
        this.percent = percent;
        this.days = days;
    }

    public void getInfo() {
        printInfo(name, address, regNumber, cash, percent, days);
    }

    public String getNin() {
        return regNumber;
    }

    public double getCash() {
        return cash;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}