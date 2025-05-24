package org.skypro.skyshop.product.searchable;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;
    private int countFullnessSearchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.countFullnessSearchables = 0;
    }

    public Searchable[] search(String input) {
        Searchable[] searchResult = new Searchable[5];
        int index = 0;
        for (Searchable value : searchables) {
            if (value != null && value.searchTerm().contains(input)) {
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
        searchables[countFullnessSearchables] = object;
        countFullnessSearchables++;
        if (searchables.length == countFullnessSearchables) {
        searchables = Arrays.copyOf(searchables, searchables.length + 1);
        }
    }
}