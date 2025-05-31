package org.skypro.skyshop.product.searchable;

import org.skypro.skyshop.product.searchable.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private ArrayList<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new ArrayList<>(size);
    }

    public TreeMap<String, Searchable> search(String input) {
        TreeMap<String, Searchable> searchResult = new TreeMap<>();
        for (Searchable value : searchables) {
            if (value.searchTerm().toLowerCase().contains(input.toLowerCase())) {
                searchResult.put(value.searchTerm(), value);
            }
        }
        return searchResult;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxMatchesInString = 0;
        TreeMap<String, Searchable> mapOfSearch = search(search);
        for (Map.Entry<String, Searchable> result : mapOfSearch.entrySet()) {
            int maxMatchesInStringOfObject = 0;
            int indexStartSearch = 0;
            int indexOfMatch = result.getValue().searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            do {
                maxMatchesInStringOfObject++;
                indexStartSearch = indexOfMatch + search.length();
                indexOfMatch = result.getValue().searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            } while (indexOfMatch != -1);
            if (maxMatchesInStringOfObject > maxMatchesInString) {
                maxMatchesInString = maxMatchesInStringOfObject;
                bestResult = result.getValue();
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("<" + search + ">" + " is not found. ");
        }
        return bestResult;
    }

    public void printMapSearch(TreeMap<String, Searchable> search) {
        for (Map.Entry<String, Searchable> value : search.entrySet()) {
            if (value != null) {
                System.out.println(value.getValue().getStringRepresentation());
            }
        }
    }

    public void add(Searchable object) {
        searchables.add(object);
    }
}