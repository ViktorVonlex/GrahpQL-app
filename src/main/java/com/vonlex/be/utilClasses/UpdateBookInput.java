package com.vonlex.be.utilClasses;

public class UpdateBookInput {
    private String title;
    private String isbn;
    private int year;
    private Long author;
    private Long publisher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "UpdateBookInput{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
