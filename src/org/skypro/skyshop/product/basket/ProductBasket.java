package org.skypro.skyshop.product.basket;

import org.skypro.skyshop.product.type.Product;

public class ProductBasket {
    private final Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Product cannot be added");
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Product value : products) {
            if (value != null) {
                totalPrice += value.getPrice();
            }
        }
        return totalPrice;
    }

    public void printProductBasket() {
        boolean isNotTotalPriceNull = false;
        int countOfSpecialProducts = 0;
        for (Product value : products) {
            if (value != null) {
                isNotTotalPriceNull = true;
                System.out.println(value);
            }
            if (value != null && value.isSpecial()) {
                countOfSpecialProducts++;
            }
        }
        if (isNotTotalPriceNull) {
            System.out.println("Total price: " + "<" + this.totalPrice() + ">");
            System.out.println("Special products: <" + countOfSpecialProducts + ">");
        } else {
            System.out.println("Product basket is empty");
        }
    }

    public boolean checkProduct(String product) {
        for (Product value : products) {
            if (value != null && value.getName().toLowerCase().equals(product.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void toCleanProductBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
