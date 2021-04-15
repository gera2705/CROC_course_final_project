package com.company.Xml;

import com.company.Model.ProductAvailability;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

/**
 * Запись в xml файл
 */
public class XmlWriter {

    private static final String OUT_DIR_PATH = "src\\out\\";

    /**
     * метод для записи в xml результатов выполнения первого задания
     * @param map слоарь хранящий , ключ - id товара, значение - объект с информацией о товаре.
     */
    public static void writeXmlForFirstTask(Map<Integer , Optional<ProductAvailability>> map){
        Document document = new Document();

        document.setRootElement(new Element("PRODUCTS"));

        for(Map.Entry<Integer, Optional<ProductAvailability>> products : map.entrySet()) {
            Optional<ProductAvailability> value = products.getValue();
            ProductAvailability productAvailability = value.get();

            Element product = new Element("PRODUCT");

            Element productID = new Element("PRODUCT_ID");
            productID.addContent(String.valueOf(productAvailability.getProduct().getProductID()));
            product.addContent(productID);

            Element productName = new Element("PRODUCT_NAME");
            productName.addContent(productAvailability.getProduct().getName());
            product.addContent(productName);

            Element productPrice = new Element("PRODUCT_PRICE");
            productPrice.addContent(String.valueOf(productAvailability.getPrice()));
            product.addContent(productPrice);

            Element maxQuantityInStock = new Element("MAX_QUANTITY_IN_STOCK");
            maxQuantityInStock.addContent(String.valueOf(productAvailability.getQuantityInStock()));
            product.addContent(maxQuantityInStock);

            Element sellerID = new Element("SELLER_ID");
            sellerID.addContent(String.valueOf(productAvailability.getSeller().getSellerID()));
            product.addContent(sellerID);

            Element surname = new Element("SURNAME");
            surname.addContent(productAvailability.getSeller().getSurname());
            product.addContent(surname);

            Element name = new Element("NAME");
            name.addContent(productAvailability.getSeller().getName());
            product.addContent(name);

            document.getRootElement().addContent(product);

            Format format = Format.getPrettyFormat();

            XMLOutputter xmlOutputter = new XMLOutputter(format);
            try {
                xmlOutputter.output(document, new FileOutputStream(new File(OUT_DIR_PATH + "firstTaskOut.xml") ));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * метод для записи в xml результатов выполнения второго задания
     * @param numbersOfSalePerDay словарь хранящий , ключ - дата , значение - кол-во продаж в этот день
     */
    public static void writeXmlForSecondTask(Map<LocalDate, Integer> numbersOfSalePerDay ){
        Document document = new Document();

        document.setRootElement(new Element("DAYS"));

        for (Map.Entry<LocalDate, Integer> map: numbersOfSalePerDay.entrySet()) {

            LocalDate d = map.getKey();
            Integer n = map.getValue();

            Element day = new Element("DAY");

            Element date = new Element("DATE");
            date.addContent(d.toString());
            day.addContent(date);

            Element numberOfSale = new Element("NUMBER_OF_SALE");
            numberOfSale.addContent(n.toString());
            day.addContent(numberOfSale);

            document.getRootElement().addContent(day);

            Format format = Format.getPrettyFormat();

            XMLOutputter xmlOutputter = new XMLOutputter(format);

            try {
                xmlOutputter.output(document, new FileOutputStream(new File(OUT_DIR_PATH + "secondTaskPath.xml") ));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}
