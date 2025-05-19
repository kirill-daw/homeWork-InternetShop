package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name);
        this.basicPrice = price;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (basicPrice - (int) (basicPrice * (discountPercent / 100f)));
    }

    @Override
    public String toString() {
        return "<" + this.getName() + ">: " + "<" + this.basicPrice + " - " + (int) (basicPrice * (discountPercent / 100f)) + "> " + "(<" + this.discountPercent + ">%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
