package org.skypro.skyshop.product.type;

import org.skypro.skyshop.product.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    protected Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name of product is empty string.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
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