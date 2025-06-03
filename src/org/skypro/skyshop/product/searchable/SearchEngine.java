package org.skypro.skyshop.product.searchable;

import org.skypro.skyshop.product.searchable.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private HashSet<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public TreeSet<Searchable> search(String input) {
        TreeSet<Searchable> searchResult = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                int comparisonLengths = Integer.compare(o1.getName().length(), o2.getName().length());
                if (comparisonLengths != 0) {
                    return 0;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
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
        TreeSet<Searchable> mapOfSearch = search(search);
        for (Searchable result : mapOfSearch) {
            int maxMatchesInStringOfObject = 0;
            int indexStartSearch = 0;
            int indexOfMatch = result.searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            do {
                maxMatchesInStringOfObject++;
                indexStartSearch = indexOfMatch + search.length();
                indexOfMatch = result.searchTerm().toLowerCase().indexOf(search.toLowerCase(), indexStartSearch);
            } while (indexOfMatch != -1);
            if (maxMatchesInStringOfObject > maxMatchesInString) {
                maxMatchesInString = maxMatchesInStringOfObject;
                bestResult = result;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("<" + search + ">" + " is not found. ");
        }
        return bestResult;
    }

    public void printSetOfSearch(TreeSet<Searchable> search) {
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