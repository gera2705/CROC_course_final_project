package com.company.Model;

public class ProductAvailability {

    private int SellerID;
    private int ProductID;
    private int Price;
    private int QuantityInStock;


    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantityInStock() {
        return QuantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        QuantityInStock = quantityInStock;
    }
}
