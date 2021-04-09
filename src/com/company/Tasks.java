package com.company;

import com.company.Model.Product;
import com.company.Model.ProductAvailability;
import com.company.Model.Sale;
import com.company.Model.Seller;
import com.company.Xml.XmlParser;
import com.company.Xml.XmlWriter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Колосов Вячеслав
 * Итоговый проект
 * Вариант - 0 , 0 , 0
 * @version v1
 */
public class Tasks {

    private static final String PROD_AVAILABILITY_IN_PATH = "src\\In\\Products_Availability.xml";
    private static final String SELLERS_IN_PATH = "src\\In\\Sellers.xml";
    private static final String SALES_IN_PATH = "src\\In\\Sales.xml";
    private static final String PROD_IN_PATH = "src\\In\\Products.xml";

    public static void main(String[] args) {

        List<ProductAvailability> productsAvailabilityList = XmlParser.parsingProdAvailability(PROD_AVAILABILITY_IN_PATH);
        List<Seller> sellersList = XmlParser.parsingSeller(SELLERS_IN_PATH);
        List<Sale> salesList = XmlParser.parsingSale(SALES_IN_PATH);
        List<Product> productsList = XmlParser.parsingProduct(PROD_IN_PATH);


        //задание 1
        Map<Integer, Optional<ProductAvailability>> maxProdAvailability = getMaxProdAvailability(productsAvailabilityList);

        XmlWriter.writeXmlForFirstTask(maxProdAvailability , sellersList);

        //задание 2
        Map<LocalDate, Integer> numbersOfSalePerDay = getNumbersOfSalePerDay(salesList);

        XmlWriter.writeXmlForSecondTask(numbersOfSalePerDay);


    }

    /**
     * метод для определения продовца с максимальным кол-вом товара одного наиминования , и кол-ва этого товара
     * @param productAvailabilities лист хранящий в себе информацию про налицие товаров
     * @return словарь хранящий в себе , ключ -  id товара, значение - объект с информацией о товаре.
     */
    public static Map<Integer , Optional<ProductAvailability>> getMaxProdAvailability(List<ProductAvailability> productAvailabilities){
        Map<Integer , Optional<ProductAvailability>> max;

        max = productAvailabilities.stream()
                .collect(Collectors.groupingBy(ProductAvailability::getProductID,
                        Collectors.maxBy(Comparator.comparing(ProductAvailability::getQuantityInStock))));

        return max;
    }

    /**
     * метод для подсчета общего количества продаж по датам
     * @param saleList лист хранящий информацию о продажах
     * @return словарь хранящий , ключ - дата , значение - кол-во продаж в этот день
     */
    public static Map<LocalDate, Integer> getNumbersOfSalePerDay(List<Sale> saleList){
        Map<LocalDate, Integer> numbersOfSale;
        numbersOfSale = saleList.stream().collect(Collectors
                .groupingBy(Sale::getDate, Collectors.summingInt(Sale::getNumberOfSale)));
        return numbersOfSale;
    }



}
