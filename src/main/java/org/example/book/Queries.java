package org.example.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Queries {
    public String getBooks() {
        return "SELECT * FROM book";
    }

    public String getVisitors() {
        return "SELECT * FROM visitor";
    }

    public String getVisitorsBooks() {
        return "SELECT * FROM visitor_book";
    }

    public String getSortBooks() {
        return """
                SELECT *\s
                FROM book
                ORDER BY publishingYear;""";
    }

    public String getYoungerBooks() {
        return """
                SELECT *\s
                FROM book
                WHERE publishingYear > 2000;""";
    }

    public String getBooksByNames(List<String> names) {
        names.replaceAll(this::doubleApostrophe);

        StringBuilder query = new StringBuilder("SELECT * FROM book");

        IntStream.range(0, names.size())
                .forEach(index -> {
                    if (index == 0) {
                        query.append(" WHERE name = '")
                                .append(names.get(index))
                                .append("'");
                    } else {
                        query.append(" OR name = '")
                                .append(names.get(index))
                                .append("'");
                    }
                });

        query.append(';');

        System.out.println(query.toString());

        return query.toString();
    }

    public String getVisitorByNameSurname() {
        return "SELECT * FROM visitor WHERE name = ? AND surname = ?";
    }

    public String getBooksOfVisitor() {
        return """
                SELECT v.name AS visitor_name, v.surname AS visitor_surname, b.name AS book_name, b.author AS book_author, b.publishingYear as book_publishingYear
                FROM visitor v
                JOIN visitor_book vb ON v.id = vb.visitor_id
                JOIN book b ON vb.book_id = b.id
                WHERE v.id = ?;""";
    }

    public String insertBooks(List<Book> books) {
        books.forEach((book) -> {
            book.name = doubleApostrophe(book.name);
            book.author = doubleApostrophe(book.author);
            book.isbn = doubleApostrophe(book.isbn);
            book.publisher = doubleApostrophe(book.publisher);
        });

        StringBuilder query = new StringBuilder("INSERT INTO book (name, author, publishingYear, isbn, publisher) VALUES");

        IntStream.range(0, books.size())
                .forEach(index -> {
                    if (index == books.size() - 1) {
                        query.append(" ('")
                                .append(books.get(index).name)
                                .append("', '")
                                .append(books.get(index).author)
                                .append("', ")
                                .append(books.get(index).publishingYear)
                                .append(", '")
                                .append(books.get(index).isbn)
                                .append("', '")
                                .append(books.get(index).publisher)
                                .append("');");
                    } else {
                        query.append(" ('")
                                .append(books.get(index).name)
                                .append("', '")
                                .append(books.get(index).author)
                                .append("', ")
                                .append(books.get(index).publishingYear)
                                .append(", '")
                                .append(books.get(index).isbn)
                                .append("', '")
                                .append(books.get(index).publisher)
                                .append("'), ");
                    }
                });

        System.out.println(query.toString());

        return query.toString();
    }

    public String insertVisitors(List<Visitor> visitors) {
        visitors.forEach((visitor) -> {
            visitor.name = doubleApostrophe(visitor.name);
            visitor.phone = doubleApostrophe(visitor.phone);
            visitor.surname = doubleApostrophe(visitor.surname);
        });

        StringBuilder query = new StringBuilder("INSERT INTO visitor (name, surname, phone, subscribed) VALUES");

        IntStream.range(0, visitors.size())
                .forEach(index -> {
                    if (index == visitors.size() - 1) {
                        query.append(" ('")
                                .append(visitors.get(index).name)
                                .append("', '")
                                .append(visitors.get(index).surname)
                                .append("', '")
                                .append(visitors.get(index).phone)
                                .append("', ")
                                .append(visitors.get(index).subscribed)
                                .append(");");
                    } else {
                        query.append(" ('")
                                .append(visitors.get(index).name)
                                .append("', '")
                                .append(visitors.get(index).surname)
                                .append("', '")
                                .append(visitors.get(index).phone)
                                .append("', '")
                                .append(visitors.get(index).subscribed)
                                .append("'), ");
                    }
                });

        System.out.println(query.toString());

        return query.toString();
    }

    public String insertVisitorsBooks(List<VisitorBook> visitorsbooks) {

        StringBuilder query = new StringBuilder("INSERT INTO visitor_book (visitor_id, book_id) VALUES");

        IntStream.range(0, visitorsbooks.size())
                .forEach(index -> {
                    if (index == visitorsbooks.size() - 1) {
                        query.append(" (")
                                .append(visitorsbooks.get(index).visitor_id)
                                .append(", ")
                                .append(visitorsbooks.get(index).book_id)
                                .append(");");
                    } else {
                        query.append(" (")
                                .append(visitorsbooks.get(index).visitor_id)
                                .append(", ")
                                .append(visitorsbooks.get(index).book_id)
                                .append("), ");
                    }
                });

        System.out.println(query.toString());

        return query.toString();
    }

    public String doubleApostrophe(String word) {
        return word.replace("'", "''");
    }

    public String dropVisitorBook() {
        return "DROP TABLE visitor_book";
    }

    public String dropVisitor() {
        return "DROP TABLE visitor";
    }

    public String dropBook() {
        return "DROP TABLE book";
    }
}
