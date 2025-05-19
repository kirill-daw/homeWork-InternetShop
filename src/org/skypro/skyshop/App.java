package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("apple", 50);
        Product pen = new FixPriceProduct("pen");
        Product orange = new SimpleProduct("orange", 70);
        Product lamp = new DiscountedProduct("lamp", 520, 25);
        Product fish = new DiscountedProduct("fish", 120, 20);
        Product meet = new SimpleProduct("meet", 220);

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