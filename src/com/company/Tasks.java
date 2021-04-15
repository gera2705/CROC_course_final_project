package com.company;

import com.company.Model.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс для выполнеия заданиний
 */
public class Tasks {

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
