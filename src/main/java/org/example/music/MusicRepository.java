package org.example.music;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MusicRepository {
    private final String url, user, password;

    public MusicRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Boolean create() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().create();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

            return false;
        }

        return true;
    }

    public List<Music> getMusic() {
        List<Music> musics = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getMusics();

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    musics.add(new Music(id, name));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return musics;
    }

    public List<Music> getWithoutLettre(List<Character> letters) {
        List<Music> musics = new LinkedList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().getMusicsWithoutLetters(letters);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    musics.add(new Music(id, name));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return musics;
    }

    public boolean insertMusics(List<String> musics) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String query = new Queries().insertMusics(musics);

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
