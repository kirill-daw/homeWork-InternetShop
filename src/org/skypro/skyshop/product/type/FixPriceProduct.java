package org.skypro.skyshop.product.type;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return "<" + this.getName() + ">: Fix price " + "<" + FIX_PRICE + "> ";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
