package org.example.music;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Queries {
    public String getMusics() {
        return "SELECT * FROM music;";
    }

    public String getMusicsWithoutLetters(List<Character> letters) {
        StringBuilder query = new StringBuilder("SELECT id, name FROM music");

        IntStream.range(0, letters.size())
            .forEach(index -> {
                if (index == 0) {
                    query.append(" WHERE LOWER(name) NOT LIKE '%")
                            .append(letters.get(index))
                            .append("%'");
                } else {
                    query.append(" AND LOWER(name) NOT LIKE '%")
                            .append(letters.get(index))
                            .append("%'");
                }
            });

        query.append(';');

        System.out.println(query.toString());

        return query.toString();
    }

    public String insertMusics(List<String> musics) {
        musics.replaceAll(this::doubleApostrophe);

        StringBuilder query = new StringBuilder("INSERT INTO music (name) VALUES");

        IntStream.range(0, musics.size())
                .forEach(index -> {
                    if (index == musics.size() - 1) {
                            query.append(" ('")
                                    .append(musics.get(index))
                                    .append("');");
                    } else {
                        query.append(" ('")
                                .append(musics.get(index))
                                .append("'), ");
                    }
                });

        System.out.println(query.toString());

        return query.toString();
    }

    public String doubleApostrophe(String word) {
        return word.replace("'", "''");
    }
}
