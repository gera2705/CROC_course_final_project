package com.company.Model;

import com.company.Tasks;
import com.company.Xml.XmlParser;
import com.company.Xml.XmlWriter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Класс для работы с данными (загрузка/выгрузки)
 */

public class Data {

    //константы пути до входных файлов
    private static final String PROD_AVAILABILITY_IN_PATH = "src\\In\\Products_Availability.xml";
    private static final String SELLERS_IN_PATH = "src\\In\\Sellers.xml";
    private static final String SALES_IN_PATH = "src\\In\\Sales.xml";
    private static final String PROD_IN_PATH = "src\\In\\Products.xml";

    /** Поле лист с продажами */
    private static List<Sale> salesList;
    /** Поле лист с наличием товара */
    private static List<ProductAvailability> productsAvailabilityList;

    /**
     * Метод для загрузки данных из файлов
     */
    public static void loadingData(){

        salesList = XmlParser.parsingSale(SALES_IN_PATH);
        List<Product> productsList = XmlParser.parsingProduct(PROD_IN_PATH);
        List<Seller> sellersList = XmlParser.parsingSeller(SELLERS_IN_PATH);
        productsAvailabilityList = XmlParser.parsingProdAvailability(PROD_AVAILABILITY_IN_PATH);

        for (Sale sale: salesList) {
            int SellerId = sale.getSeller().getSellerID();

            Seller seller = findSeller(SellerId , sellersList);

            sale.setSeller(seller);

            int ProductId = sale.getProduct().getProductID();

            Product product = findProduct(ProductId , productsList);

            sale.setProduct(product);
        }

        for (ProductAvailability productAvailability: productsAvailabilityList) {

            int SellerId = productAvailability.getSeller().getSellerID();

            Seller seller = findSeller(SellerId , sellersList);

            productAvailability.setSeller(seller);

            int ProductId = productAvailability.getProduct().getProductID();

            Product product = findProduct(ProductId , productsList);

            productAvailability.setProduct(product);
        }


    }

    /**
     * Метод для выгрузки данных в файлы
     */
    public static void unloadingData(){

        //задание 1
        Map<Integer, Optional<ProductAvailability>> maxProdAvailability = Tasks.getMaxProdAvailability(productsAvailabilityList);

        XmlWriter.writeXmlForFirstTask(maxProdAvailability);

        //задание 2
        Map<LocalDate, Integer> numbersOfSalePerDay = Tasks.getNumbersOfSalePerDay(salesList);

        XmlWriter.writeXmlForSecondTask(numbersOfSalePerDay);
    }

    /**
     * Метод для поиска продовца по id
     * @param id продовца
     * @param sellers лист хранящий в себе всех продоовцов
     * @return найденный продавец
     */
    public static Seller findSeller(int id , List<Seller> sellers){
        Seller foundSeller = null;
        for (Seller seller : sellers){
            if (id == seller.getSellerID()){
                foundSeller = seller;
                break;
            }
        }
        return foundSeller;
    }

    /**
     * Метод для поиска продукта по id
     * @param id продукта
     * @param products лист хранящий в себе все продукты
     * @return найденый продукт
     */
    public static Product findProduct(int id , List<Product> products){
        Product foundProduct = null;
        for (Product product: products) {
            if(id == product.getProductID()){
                foundProduct = product;
                break;
            }
        }
        return foundProduct;
    }


}
