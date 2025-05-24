package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.searchable.Searchable;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleTitle + "\n" + articleText;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
