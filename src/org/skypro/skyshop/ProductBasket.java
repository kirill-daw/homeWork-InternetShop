package org.skypro.skyshop;

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
        for (Product value : products) {
            if (value != null) {
                System.out.println("<" + value.getName() + ">: " + "<" + value.getPrice() + ">");
            }
        }
        if (this.totalPrice() != 0) {
            System.out.println("Total price: " + "<" + this.totalPrice() + ">");
        } else {
            System.out.println("Product basket is empty");
        }
    }

    public boolean checkProduct(String product) {
        for (Product value : products) {
            if (value != null && value.getName().equals(product)) {
                return true;
            }
        }
        return false;
    }

    public void toCleanProductBasket() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                products[i] = null;
            }
        }
    }
}
