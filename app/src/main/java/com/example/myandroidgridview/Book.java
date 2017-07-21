package com.example.myandroidgridview;

public class Book {
    private final String name;
    private final String author;
    private final int imageResource;
    private boolean isFavorite = false;
    private final String imageUrl;

    public Book(String name, String author, int imageResource, String imageUrl) {
        this.name = name;
        this.author = author;
        this.imageResource = imageResource;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
