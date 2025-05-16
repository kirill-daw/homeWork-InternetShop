package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("apple", 50);
        Product pen = new Product("pen", 20);
        Product orange = new Product("orange", 70);
        Product lamp = new Product("lamp", 520);
        Product fish = new Product("fish", 120);
        Product meet = new Product("meet", 220);

        ProductBasket productBasket1 = new ProductBasket();
        productBasket1.addProduct(meet);

        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(apple);
        productBasket2.addProduct(orange);
        productBasket2.addProduct(fish);
        productBasket2.addProduct(pen);
        productBasket2.addProduct(lamp);
        productBasket2.addProduct(meet);

        productBasket2.printProductBasket();

        System.out.println(productBasket2.checkProduct("apple"));
        System.out.println(productBasket2.checkProduct("coconut"));

        productBasket2.toCleanProductBasket();
        productBasket2.printProductBasket();
        System.out.println(productBasket2.checkProduct("orange"));
    }
}