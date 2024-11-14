package org.example.book;



import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository {
    private final String url, user, password;

    public BookRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public List<Book> getBooks() {
        List<Book> books = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getBooks();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String author = resultSet.getString("author");;
                    Integer publishingYear = resultSet.getInt("publishingYear");
                    String isbn = resultSet.getString("isbn");
                    String publisher = resultSet.getString("publisher");

                    books.add(new Book(id, name, author, publishingYear, isbn, publisher));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }

    public List<Visitor> getVisitors() {
        List<Visitor> visitors = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getVisitors();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");;
                    String phone = resultSet.getString("phone");
                    Boolean subscribed = resultSet.getBoolean("subscribed");

                    visitors.add(new Visitor(id, name, surname, phone, subscribed));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return visitors;
    }

    public List<Book> getSortBooks() {
        List<Book> books = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getSortBooks();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String author = resultSet.getString("author");;
                    Integer publishingYear = resultSet.getInt("publishingYear");
                    String isbn = resultSet.getString("isbn");
                    String publisher = resultSet.getString("publisher");;

                    books.add(new Book(id, name, author, publishingYear, isbn, publisher));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }

    public List<Book> getYoungerBooks() {
        List<Book> books = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getYoungerBooks();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String author = resultSet.getString("author");;
                    Integer publishingYear = resultSet.getInt("publishingYear");
                    String isbn = resultSet.getString("isbn");
                    String publisher = resultSet.getString("publisher");;

                    books.add(new Book(id, name, author, publishingYear, isbn, publisher));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }

    public Boolean insertVisitors(List<Visitor> visitors) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().insertVisitors(visitors);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

            return false;
        }

        return true;
    }

    public Boolean insertBooks(List<Book> books) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().insertBooks(books);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

            return false;
        }

        return true;
    }
}
