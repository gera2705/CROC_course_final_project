package com.company.Model;

import java.time.LocalDate;

public class Sale {

    private int saleID;
    private int productID;
    private int sellerID;
    private int numberOfSale;

    private LocalDate date;

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getNumberOfSale() {
        return numberOfSale;
    }

    public void setNumberOfSale(int numberOfSale) {
        this.numberOfSale = numberOfSale;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
