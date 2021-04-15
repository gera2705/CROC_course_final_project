package com.company.Model;

/**
 * Модель данных - Наличие товара , со свойствами <b>seller</b> и <b>product</b>  и <b>price</b> и  и <b>quantityInStock</b>
 */
public class ProductAvailability {

    /** Поле производитель */
    private Seller seller;
    /** Поле продукт*/
    private Product product;
    /** Поле цена*/
    private int price;
    /** Поле кол-во товара в наличии*/
    private int quantityInStock;

    /**
     * Функция получения значения поля {@link ProductAvailability#price}
     * @return возвращает цену продукта
     */
    public int getPrice() {
        return price;
    }

    /**
     * Процедура определения цены {@link ProductAvailability#price}
     * @param price - цена
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Функция получения значения поля {@link ProductAvailability#quantityInStock}
     * @return возвращает кол-во товара в наличии
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Процедура определения кол-ва товара в наличии {@link ProductAvailability#quantityInStock}
     * @param quantityInStock - кол-ва товара в наличии
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Функция получения значения поля {@link ProductAvailability#seller}
     * @return возвращает продовца
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Процедура определения продовца {@link ProductAvailability#seller}
     * @param seller - продавец
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Функция получения значения поля {@link ProductAvailability#product}
     * @return возвращает продукт
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Процедура определения продукта {@link ProductAvailability#product}
     * @param product - продукт
     */
    public void setProduct(Product product) {
        this.product = product;
    }


    /**
     * Функция получения значения поля {@link Product#getProductID()}
     * @return возвращает id продукта
     */
    public int getProductID() {
        return product.getProductID();
    }
}
