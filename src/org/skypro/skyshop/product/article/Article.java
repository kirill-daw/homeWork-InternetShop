package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.searchable.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        if (articleTitle != null && articleText != null && !articleTitle.isBlank() && !articleText.isBlank()) {
            this.articleTitle = articleTitle;
            this.articleText = articleText;
        } else {
            throw new IllegalArgumentException("The article is incomplete. ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle) && Objects.equals(articleText, article.articleText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleText);
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

    @Override
    public String getName() {
        return articleTitle;
    }
}