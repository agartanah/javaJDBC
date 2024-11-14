package org.example.music;

public class Music {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Music(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}\n";
    }
}
