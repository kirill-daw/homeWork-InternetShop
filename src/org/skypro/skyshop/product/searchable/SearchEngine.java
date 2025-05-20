package org.skypro.skyshop.product.searchable;

public class SearchEngine {
    private final Searchable[] searchables;

    public SearchEngine(Searchable[] searchables) {
        this.searchables = searchables;
    }

    public Searchable[] search(String input) {
        Searchable[] searchResult = new Searchable[5];
        add(searchResult, input);
        return searchResult;
    }

    public void add(Searchable[] searchResult, String input) {
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
    }

    public void printArraySearch(Searchable[] search) {
        for (Searchable value : search) {
            if (value != null) {
                System.out.println(value.getStringRepresentation());
            }
        }
    }
}
