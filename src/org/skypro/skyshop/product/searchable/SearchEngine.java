package org.skypro.skyshop.product.searchable;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(Searchable[] objects) {
        this.searchables = objects;
    }

    public Searchable[] search(String input) {
        Searchable[] searchResult = new Searchable[5];
        int index = 0;
        for (Searchable value : searchables) {
            if (value.searchTerm().contains(input)) {
                searchResult[index] = value;
                index++;
            }
            if (index >= 5) {
                break;
            }
        }
        return searchResult;
    }

    public void printArraySearch(Searchable[] search) {
        for (Searchable value : search) {
            if (value != null) {
                System.out.println(value.getStringRepresentation());
            }
        }
    }

    public void add(Searchable object) {
        searchables = Arrays.copyOf(searchables, searchables.length + 1);
        searchables[searchables.length - 1] = object;
    }
}
