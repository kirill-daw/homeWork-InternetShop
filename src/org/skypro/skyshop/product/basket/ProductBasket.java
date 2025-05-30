package org.skypro.skyshop.product.basket;

import org.skypro.skyshop.product.type.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ProductBasket {
    private final HashMap<String, LinkedList<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            LinkedList<Product> list = products.getOrDefault(product.getName(), new LinkedList<>());
            list.add(product);
            products.put(product.getName(), list);
        } else {
            throw new IllegalArgumentException("Product is null.");
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, LinkedList<Product>> value : products.entrySet()) {
            for (Product product : value.getValue()) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printProductBasket() {
        int countOfSpecialProducts = 0;
        if (products.isEmpty()) {
            System.out.println("Product basket is empty");
            return;
        }
        for (Map.Entry<String, LinkedList<Product>> value : products.entrySet()) {
            for (Product product : value.getValue()) {
                System.out.println(product);
                if (product.isSpecial()) {
                    countOfSpecialProducts++;
                }
            }
        }
        System.out.println("Total price: " + "<" + this.totalPrice() + ">");
        System.out.println("Special products: <" + countOfSpecialProducts + ">");
    }

    public boolean checkProduct(String product) {
        return products.containsKey(product);
    }

    public void toCleanProductBasket() {
        products.clear();
    }

    public LinkedList<Product> toRemoveProductFromBasket(String name) {
        LinkedList<Product> listOfDeletedProducts = new LinkedList<>();
        if (products.containsKey(name)) {
            Iterator<Product> iterator = products.get(name).iterator();
            while (iterator.hasNext()) {
                Product e = iterator.next();
                listOfDeletedProducts.add(e);
                iterator.remove();
            }
        }
        return listOfDeletedProducts;
    }
}
