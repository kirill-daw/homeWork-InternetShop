package org.skypro.skyshop;

import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.searchable.SearchEngine;
import org.skypro.skyshop.product.type.DiscountedProduct;
import org.skypro.skyshop.product.type.FixPriceProduct;
import org.skypro.skyshop.product.type.Product;
import org.skypro.skyshop.product.type.SimpleProduct;
import org.skypro.skyshop.product.basket.ProductBasket;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(3);

        Product apple = new SimpleProduct("apple", 50);
        searchEngine.add(apple);
        Article articleApple = new Article("apple", "delicious apple");
        searchEngine.add(articleApple);
        Product pen = new FixPriceProduct("pen");
        searchEngine.add(pen);
        Article articlePen = new Article("pen", "beautiful pen");
        searchEngine.add(articlePen);
        Product orange = new SimpleProduct("orange", 70);
        searchEngine.add(orange);
        Article articleOrange = new Article("orange", "delicious orange");
        searchEngine.add(articleOrange);
        Product lamp = new DiscountedProduct("lamp", 520, 25);
        searchEngine.add(lamp);
        Article articleLamp = new Article("lamp", "light lamp");
        searchEngine.add(articleLamp);
        Product fish = new DiscountedProduct("fish", 120, 20);
        searchEngine.add(fish);
        Article articleFish = new Article("fish", "delicious fish");
        searchEngine.add(articleFish);
        Product meet = new SimpleProduct("meet", 220);
        searchEngine.add(meet);
        Article articleMeet = new Article("meet", "delicious meet");
        searchEngine.add(articleMeet);

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

        System.out.println("Enter search input: ");
        Scanner scanner = new Scanner(System.in);
        searchEngine.printArraySearch(searchEngine.search(scanner.nextLine()));
    }
}