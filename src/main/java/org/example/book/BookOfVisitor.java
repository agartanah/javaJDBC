package org.example.book;

public class BookOfVisitor {
    String visitorName;
    String visitorSurname;
    String bookName;
    String bookAuthor;
    Integer bookPublishingYear;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorSurname() {
        return visitorSurname;
    }

    public void setVisitorSurname(String visitorSurname) {
        this.visitorSurname = visitorSurname;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookPublishingYear() {
        return bookPublishingYear;
    }

    public void setBookPublishingYear(Integer bookPublishingYear) {
        this.bookPublishingYear = bookPublishingYear;
    }

    @Override
    public String toString() {
        return "BooksOfVisitors{" +
                "visitorName='" + visitorName + '\'' +
                ", visitorSurname='" + visitorSurname + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublishingYear=" + bookPublishingYear +
                "}\n";
    }

    public BookOfVisitor(String visitorName, String visitorSurname, String bookName, String bookAuthor, Integer bookPublishingYear) {
        this.visitorName = visitorName;
        this.visitorSurname = visitorSurname;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublishingYear = bookPublishingYear;
    }
}
