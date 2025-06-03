package org.skypro.skyshop.product.searchable.comparator;

import org.skypro.skyshop.product.searchable.Searchable;

import java.util.Comparator;

public class SearchableStandardOrderComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int comparisonLengths = Integer.compare(o1.getName().length(), o2.getName().length());
        if (comparisonLengths != 0) {
            return comparisonLengths;
        }
        return o1.getName().compareTo(o2.getName());
    }
}