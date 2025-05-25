package org.skypro.skyshop.product.searchable;

import org.skypro.skyshop.product.searchable.exceptions.BestResultNotFound;

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
            if (value != null && value.searchTerm().toLowerCase().contains(input.toLowerCase())) {
                searchResult[index] = value;
                index++;
            }
            if (index >= 5) {
                break;
            }
        }
        return searchResult;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxMatchesInString = 0;
        Searchable[] ArrayOfSearch = search(search);
        for (int i = 0; i < ArrayOfSearch.length && ArrayOfSearch[i] != null; i++) {
            int maxMatchesInStringOfObject = 0;
            int indexStartSearch = 0;
            int indexOfMatch = ArrayOfSearch[i].searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            do {
                maxMatchesInStringOfObject++;
                indexStartSearch = indexOfMatch + search.length();
                indexOfMatch = ArrayOfSearch[i].searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            } while (indexOfMatch != -1);
            if (maxMatchesInStringOfObject > maxMatchesInString) {
                maxMatchesInString = maxMatchesInStringOfObject;
                bestResult = ArrayOfSearch[i];
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("<" + search + ">" + " is not found. ");
        }
        return bestResult;
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