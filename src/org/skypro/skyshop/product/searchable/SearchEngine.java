package org.skypro.skyshop.product.searchable;

import org.skypro.skyshop.product.searchable.exceptions.BestResultNotFound;

import java.util.ArrayList;

public class SearchEngine {
    private ArrayList<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public ArrayList<Searchable> search(String input) {
        ArrayList<Searchable> searchResult = new ArrayList<>();
        for (Searchable value : searchables) {
            if (value.searchTerm().toLowerCase().contains(input.toLowerCase())) {
                searchResult.add(value);
            }
        }
        return searchResult;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxMatchesInString = 0;
        ArrayList<Searchable> arrayOfSearch = search(search);
        for (int i = 0; i < arrayOfSearch.size() && arrayOfSearch.get(i) != null; i++) {
            int maxMatchesInStringOfObject = 0;
            int indexStartSearch = 0;
            int indexOfMatch = arrayOfSearch.get(i).searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            do {
                maxMatchesInStringOfObject++;
                indexStartSearch = indexOfMatch + search.length();
                indexOfMatch = arrayOfSearch.get(i).searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            } while (indexOfMatch != -1);
            if (maxMatchesInStringOfObject > maxMatchesInString) {
                maxMatchesInString = maxMatchesInStringOfObject;
                bestResult = arrayOfSearch.get(i);
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("<" + search + ">" + " is not found. ");
        }
        return bestResult;
    }

    public void printArraySearch(ArrayList<Searchable> search) {
        for (Searchable value : search) {
            if (value != null) {
                System.out.println(value.getStringRepresentation());
            }
        }
    }

    public void add(Searchable object) {
        searchables.add(object);
    }
}