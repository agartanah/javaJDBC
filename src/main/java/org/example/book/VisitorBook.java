package org.example.book;

public class VisitorBook {
    Integer visitor_id;
    Integer book_id;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(Integer visitor_id) {
        this.visitor_id = visitor_id;
    }

    public VisitorBook(Integer visitor_id, Integer book_id) {
        this.visitor_id = visitor_id;
        this.book_id = book_id;
    }


    @Override
    public String toString() {
        return "VisitorBook{" +
                "visitor_id=" + visitor_id +
                ", book_id=" + book_id +
                "}\n";
    }
}
