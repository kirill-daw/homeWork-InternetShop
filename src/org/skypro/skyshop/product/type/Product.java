package org.skypro.skyshop.product.type;

import org.skypro.skyshop.product.searchable.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    protected Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return name;
    }
}