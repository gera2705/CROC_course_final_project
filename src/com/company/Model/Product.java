package com.company.Model;

/**
 * Модель данных - Продукт , со свойствами <b>productID</b> и <b>name</b>
 */
public class Product {

    /**Поле id продукта*/
    private int productID;
    /**Поле наименование продукта*/
    private String name;

    /**
     * Функция получения значения поля {@link Product#productID}
     * @return возвращает id продукта
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Процедура определения id продукта {@link Product#productID}
     * @param productID - id продукта
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * Функция получения значения поля {@link Product#name}
     * @return возвращает наименование продукта
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения наименования продукта {@link Product#name}
     * @param name - наименование продукта
     */
    public void setName(String name) {
        this.name = name;
    }
}
