package org.skypro.skyshop;

import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.searchable.SearchEngine;
import org.skypro.skyshop.product.searchable.Searchable;
import org.skypro.skyshop.product.type.DiscountedProduct;
import org.skypro.skyshop.product.type.FixPriceProduct;
import org.skypro.skyshop.product.type.Product;
import org.skypro.skyshop.product.type.SimpleProduct;
import org.skypro.skyshop.product.basket.ProductBasket;

import java.util.Scanner;

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

        Article articleApple = new Article("apple", "delicious apple");
        Article articlePen = new Article("pen", "beautiful pen");
        Article articleFish = new Article("fish", "delicious fish");
        Article articleMeet = new Article("meet", "delicious meet");
        Article articleOrange = new Article("orange", "delicious orange");
        Article articleLamp = new Article("lamp", "light lamp");

        Searchable[] searchables = {apple, pen, fish, meet, orange, lamp, articleFish, articleApple, articlePen, articleLamp, articleMeet, articleOrange};
        SearchEngine searchEngine = new SearchEngine(searchables);
        System.out.println("Enter search input: ");
        Scanner scanner = new Scanner(System.in);
        searchEngine.printArraySearch(searchEngine.search(scanner.nextLine()));
    }
}