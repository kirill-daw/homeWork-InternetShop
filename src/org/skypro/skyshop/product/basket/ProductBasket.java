package org.skypro.skyshop.product.basket;

import org.skypro.skyshop.product.type.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private final LinkedList<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            throw new IllegalArgumentException("Product is null.");
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Product value : products) {
            totalPrice += value.getPrice();
        }
        return totalPrice;
    }

    public void printProductBasket() {
        int countOfSpecialProducts = 0;
        if (products.isEmpty()) {
            System.out.println("Product basket is empty");
            return;
        }
        for (Product value : products) {
            System.out.println(value);
            if (value.isSpecial()) {
                countOfSpecialProducts++;
            }
        }
        System.out.println("Total price: " + "<" + this.totalPrice() + ">");
        System.out.println("Special products: <" + countOfSpecialProducts + ">");
    }

    public boolean checkProduct(String product) {
        for (Product value : products) {
            if (value.getName().equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }

    public void toCleanProductBasket() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product e = iterator.next();
            iterator.remove();
        }
    }

    public LinkedList<Product> toRemoveProductFromBasket(String name) {
        LinkedList<Product> listOfDeletedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product e = iterator.next();
            if (e.getName().equalsIgnoreCase(name)) {
                listOfDeletedProducts.add(e);
                iterator.remove();
            }
        }
        return listOfDeletedProducts;
    }
}
