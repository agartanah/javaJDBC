package org.example.book;

public class Book {
    Integer id;
    String name;
    String author;
    Integer publishingYear;
    String isbn;
    String publisher;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book(Integer id, String name, String author, Integer publishingYear, String isbn, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingYear=" + publishingYear +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                "}\n";
    }
}
