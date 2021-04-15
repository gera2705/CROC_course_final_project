package com.company.Xml;

import com.company.Model.Product;
import com.company.Model.ProductAvailability;
import com.company.Model.Sale;
import com.company.Model.Seller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Методы для парсинга входный xml фалов
 */
public class XmlParser {

    /**
     * Парсинг файла хращего в себе информацию о продуктах
     * @param filePath путь до входного xml файла
     * @return лист храняций в себе объекты типа Product
     */
    public static List<Product> parsingProduct(String filePath){
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<Product> productList = new ArrayList<>();

        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("PRODUCT");

            for (int i = 0; i < nodeList.getLength(); i++) {
                productList.add(getProduct(nodeList.item(i)));

            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * метод получения объекта типа Product
     * @param node узел дерева документа
     * @return объекта типа Product
     */
    private static Product getProduct(Node node) {
        Product product = new Product();

        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            product.setProductID(Integer.parseInt(getTagValue("PRODUCT_ID" , element)));
            product.setName(getTagValue("NAME" , element));

        }

        return product;

    }

    /**
     * Парсинг файла хращего в себе информацию о продажах
     * @param filePath путь до входного xml файла
     * @return лист храняций в себе объекты типа Sale
     */
    public static List<Sale> parsingSale(String filePath){
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<Sale> saleList = new ArrayList<>();

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("SALE");

            for (int i = 0; i < nodeList.getLength(); i++) {
                saleList.add(getSale(nodeList.item(i)));

            }



        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return saleList;
    }

     /**
     * метод получения объекта типа Sale
     * @param node узел дерева документа
     * @return объекта типа Sale
     */
    private static Sale getSale(Node node) {
      Sale sale = new Sale();
      Seller seller = new Seller();
      Product product = new Product();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            sale.setSaleID(Integer.parseInt(getTagValue("SALE_ID" , element)));
            seller.setSellerID(Integer.parseInt(getTagValue("SELLER_ID" , element)));
            sale.setSeller(seller);
            product.setProductID(Integer.parseInt(getTagValue("PRODUCT_ID" , element)));
            sale.setProduct(product);
            sale.setNumberOfSale(Integer.parseInt(getTagValue("NUMBER_OF_SALES" , element)));
            sale.setDate(LocalDate.parse(getTagValue("DATE" , element)));

        }

        return sale;
    }

    /**
     * Парсинг файла хращего в себе информацию о продовцах
     * @param filePath путь до входного xml файла
     * @return лист храняций в себе объекты типа Seller
     */
    public static List<Seller> parsingSeller(String filePath){
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<Seller> sellerList = new ArrayList<>();

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("SELLER");

            for (int i = 0; i < nodeList.getLength(); i++) {
                sellerList.add(getSeller(nodeList.item(i)));

            }



        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return sellerList;
    }

    /**
     * метод получения объекта типа Seller
     * @param node узел дерева документа
     * @return объекта типа Seller
     */
    private static Seller getSeller(Node node){
        Seller seller = new Seller();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            seller.setSellerID(Integer.parseInt(getTagValue("SELLER_ID" , element)));
            seller.setSurname(getTagValue("SURNAME" , element));
            seller.setName(getTagValue("NAME" , element));

        }

        return seller;
    }

    /**
     * Парсинг файла хращего в себе информацию о наличие товаров у продавцов
     * @param filePath путь до входного xml файла
     * @return лист храняций в себе объекты типа ProductAvailability
     */
    public static List<ProductAvailability> parsingProdAvailability(String filePath){
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        List<ProductAvailability> productAvailabilities = new ArrayList<>();

        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("PRODUCT_AVAILABILITY");


            for (int i = 0; i < nodeList.getLength(); i++) {
                productAvailabilities.add(getProductAvailability(nodeList.item(i)));

            }


        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return productAvailabilities;
    }

    /**
     * метод получения объекта типа ProductAvailability
     * @param node узел дерева документа
     * @return объекта типа ProductAvailability
     */
    private static ProductAvailability getProductAvailability(Node node){
        ProductAvailability productAvailability = new ProductAvailability();
        Seller seller = new Seller();
        Product product = new Product();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;

            seller.setSellerID(Integer.parseInt(getTagValue("SELLER_ID" , element)));
            productAvailability.setSeller(seller);

            product.setProductID(Integer.parseInt(getTagValue("PRODUCT_ID" , element)));
            productAvailability.setProduct(product);

            productAvailability.setPrice(Integer.parseInt(getTagValue("PRICE" , element)));
            productAvailability.setQuantityInStock(Integer.parseInt(getTagValue("QUANTITY_IN_STOCK" , element)));

        }

        return productAvailability;
    }

    /**
     * метод получения значения тега
     * @param tag тег
     * @param element элемент
     * @return строка со значение переданого тега
     */
    private static String getTagValue(String tag , Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
