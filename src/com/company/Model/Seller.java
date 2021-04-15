package com.company.Model;

/**
 * Модель данных - Продавец ,
 * со свойствами <b>sellerID</b> и <b>surname</b> и <b>name</b>
 */
public class Seller {

    /** Поле id продовца */
    private int sellerID;
    /** Поле фимилия */
    private String surname;
    /** Поле имя */
    private String name;

    /**
     * Функция получения значения поля {@link Seller#sellerID}
     * @return возвращает id продовца
     */
    public int getSellerID() {
        return sellerID;
    }

    /**
     * Процедура определения id продовца {@link Seller#sellerID}
     * @param sellerID - id продовца
     */
    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * Функция получения значения поля {@link Seller#surname}
     * @return возвращает фамилию
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Процедура определения фамилию {@link Seller#surname}
     * @param surname - фамилия
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Функция получения значения поля {@link Seller#name}
     * @return возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения имени {@link Seller#name}
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }
}
