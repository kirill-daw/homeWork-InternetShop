package org.skypro.skyshop;

import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.searchable.SearchEngine;
import org.skypro.skyshop.product.searchable.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.type.DiscountedProduct;
import org.skypro.skyshop.product.type.FixPriceProduct;
import org.skypro.skyshop.product.type.Product;
import org.skypro.skyshop.product.type.SimpleProduct;
import org.skypro.skyshop.product.basket.ProductBasket;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(3);

        Product apple = new SimpleProduct("Apple", 50);
        searchEngine.add(apple);
        Article articleApple = new Article(apple.getName(), "delicious apple");
        searchEngine.add(articleApple);
        Product pen = new FixPriceProduct("Pen");
        searchEngine.add(pen);
        Article articlePen = new Article(pen.getName(), "beautiful pen");
        searchEngine.add(articlePen);
        Product orange = new SimpleProduct("Orange", 70);
        searchEngine.add(orange);
        Article articleOrange = new Article(orange.getName(), "delicious orange");
        searchEngine.add(articleOrange);
        Product lamp = new DiscountedProduct("Lamp", 520, 25);
        searchEngine.add(lamp);
        Article articleLamp = new Article(lamp.getName(), "light lamp");
        searchEngine.add(articleLamp);
        Product fish = new DiscountedProduct("Fish", 120, 20);
        searchEngine.add(fish);
        Article articleFish = new Article(fish.getName(), "delicious fish");
        searchEngine.add(articleFish);
        Product meat = new SimpleProduct("Meat", 220);
        searchEngine.add(meat);
        Article articleMeat = new Article(meat.getName(), "delicious meat");
        searchEngine.add(articleMeat);

        ProductBasket productBasket1 = new ProductBasket();
        productBasket1.addProduct(meat);

        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(apple);
        productBasket2.addProduct(orange);
        productBasket2.addProduct(fish);
        productBasket2.addProduct(pen);
        productBasket2.addProduct(lamp);
        productBasket2.addProduct(meat);

        productBasket2.printProductBasket();
        System.out.println();

        System.out.println(productBasket2.checkProduct("Apple"));
        System.out.println(productBasket2.checkProduct("Coconut"));
        System.out.println();

        productBasket2.toCleanProductBasket();
        productBasket2.printProductBasket();
        System.out.println();

        System.out.println(productBasket2.checkProduct("Orange"));
        System.out.println();

        System.out.println("Enter search input: ");
        Scanner scanner = new Scanner(System.in);
        searchEngine.printMapSearch(searchEngine.search(scanner.nextLine()));
        System.out.println();

        try {
            Product appleJuice = new DiscountedProduct("Apple juice", 99, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product orangeJuice = new SimpleProduct("Orange juice", -200);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product table = new SimpleProduct("", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            System.out.println(searchEngine.searchBestResult("PEN"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Search is done. ");
            System.out.println();
        }

        try {
            System.out.println(searchEngine.searchBestResult("Apple juice"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Search is done. ");
        }
        System.out.println();

        productBasket1.addProduct(meat);
        productBasket1.addProduct(fish);
        productBasket1.addProduct(meat);
        productBasket1.addProduct(orange);
        productBasket1.addProduct(pen);
        productBasket1.printProductBasket();
        System.out.println();

        System.out.println(productBasket1.toRemoveProductFromBasket("Meat") + " was deleted.");
        System.out.println();

        productBasket1.printProductBasket();
        System.out.println();

        System.out.println(productBasket1.toRemoveProductFromBasket("Coconut") + " list is empty.");
        System.out.println();

        productBasket1.printProductBasket();
    }
}