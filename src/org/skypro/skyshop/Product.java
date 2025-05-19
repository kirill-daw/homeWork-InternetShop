package org.skypro.skyshop;

public abstract class Product {
    private final String name;

    protected Product (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }
}