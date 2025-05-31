package org.skypro.skyshop.product.searchable;

public interface Searchable {
    String searchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "«" + searchTerm() + " – " + getContentType() + "»";
    }

    public String getName();
}
