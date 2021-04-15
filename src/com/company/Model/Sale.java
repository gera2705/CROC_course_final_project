package com.company.Model;

import java.time.LocalDate;

/**
 * Модель данных - Продажа ,
 * со свойствами <b>saleID</b> и <b>numberOfSale</b> и <b>seller</b> и <b>product</b> и <b>date</b>
 */
public class Sale {

    /** Поле id продажи */
    private int saleID;
    /** Поле кол-во продаж */
    private int numberOfSale;
    /** Поле продавец */
    private Seller seller;
    /** Поле продукт */
    private Product product;
    /** Поле дата продажи */
    private LocalDate date;

    /**
     * Функция получения значения поля {@link Sale#saleID}
     * @return возвращает id продажи
     */
    public int getSaleID() {
        return saleID;
    }

    /**
     * Процедура определения id продажи {@link Sale#saleID}
     * @param saleID - id продажи
     */
    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    /**
     * Функция получения значения поля {@link Sale#numberOfSale}
     * @return возвращает кол-во продаж
     */
    public int getNumberOfSale() {
        return numberOfSale;
    }

    /**
     * Процедура определения кол-ва продаж {@link Sale#numberOfSale}
     * @param numberOfSale - кол-во продаж
     */
    public void setNumberOfSale(int numberOfSale) {
        this.numberOfSale = numberOfSale;
    }

    /**
     * Функция получения значения поля {@link Sale#date}
     * @return возвращает дату продажи
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Процедура определения даты {@link Sale#date}
     * @param date - дата продажи
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Функция получения значения поля {@link Sale#seller}
     * @return возвращает продовца
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Процедура определения продовца {@link Sale#seller}
     * @param seller - продавец
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Функция получения значения поля {@link Sale#product}
     * @return возвращает продукт
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Процедура определения продукта {@link Sale#product}
     * @param product - продукт
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
