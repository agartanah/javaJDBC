package org.example.music;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Queries {
    public String create() {
        return """
                DROP TABLE IF EXISTS music;
                
                CREATE TABLE IF NOT EXISTS music
                (
                    id   SERIAL PRIMARY KEY,
                    name TEXT NOT NULL
                );
                
                INSERT INTO music (name)
                SELECT * FROM (VALUES\s
                       ('Bohemian Rhapsody'),
                       ('Stairway to Heaven'),
                       ('Imagine'),
                       ('Sweet Child O Mine'),
                       ('Hey Jude'),
                       ('Hotel California'),
                       ('Billie Jean'),
                       ('Wonderwall'),
                       ('Smells Like Teen Spirit'),
                       ('Let It Be'),
                       ('I Want It All'),
                       ('November Rain'),
                       ('Losing My Religion'),
                       ('One'),
                       ('With or Without You'),
                       ('Sweet Caroline'),
                       ('Yesterday'),
                       ('Dont Stop Believin'),
                       ('Crazy Train'),
                       ('Always')) AS new_data(name)
                WHERE NOT EXISTS (SELECT 1 FROM music);""";
    }

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
