package org.skypro.skyshop.product.basket;

import org.skypro.skyshop.product.type.Product;

import java.util.*;

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
        return products.values().stream()
                .flatMap
                        (Collection::stream)
                .mapToInt
                        (Product::getPrice)
                .sum();
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap
                        (Collection::stream)
                .filter
                        (Product::isSpecial)
                .count();
    }

    public void printProductBasket() {
        if (products.isEmpty()) {
            System.out.println("Product basket is empty");
            return;
        }
        products.values().stream()
                .flatMap
                        (Collection::stream)
                .forEach
                        (System.out::println);
        System.out.println("Total price: " + "<" + this.totalPrice() + ">");
        System.out.println("Special products: <" + getSpecialCount() + ">");
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