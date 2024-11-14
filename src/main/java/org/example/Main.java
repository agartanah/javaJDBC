package org.example;

import org.example.book.Book;
import org.example.book.BookRepository;
import org.example.book.Visitor;
import org.example.music.Music;
import org.example.music.MusicRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String url = "jdbc:postgresql://localhost:5432/testdb";
    static final String user = "postgres";
    static final String password = new Password().password;
    static final DataBase db = new DataBase(url, user, password);
    static final MusicRepository musicRepository = db.getMusicRepository();
    static final BookRepository bookRepository = db.getBookRepository();

    public static void main(String[] args) {

        // 1 задание
        System.out.println("ЗАДАНИЕ 1\n");

        List<Music> musics = musicRepository.getMusic();
        System.out.println(musics);

        // 2 задание
        System.out.println("ЗАДАНИЕ 2\n");

        List<Character> letters = new LinkedList<>();
        letters.add('m');
        letters.add('t');

        var musicWithoutLetter = musicRepository.getWithoutLettre(letters);

        System.out.println(musicWithoutLetter);

        // 3 задание
        System.out.println("ЗАДАНИЕ 3\n");

        List<String> myMusics = new LinkedList<>();
        myMusics.add("Knockin' On Heaven's Door");
        myMusics.add("Still Loving You");
        myMusics.add("Here Comes The Sun");
        myMusics.add("Stumblin' In");
        myMusics.add("New Kid in Town");

        if (musicRepository.insertMusics(myMusics)) {
            System.out.println(musicRepository.getMusic());
        }

        // 4 задание
        System.out.println("ЗАДАНИЕ 4\n");

        // create-visitor-book.sql

        // 5 задание
        System.out.println("ЗАДАНИЕ 5\n");

        List<Book> sortBooks = bookRepository.getSortBooks();
        System.out.println(sortBooks);

        // 6 Задание
        System.out.println("ЗАДАНИЕ 6\n");

        List<Book> youngerBooks = bookRepository.getYoungerBooks();
        System.out.println(youngerBooks);

        // 7 Задание
        System.out.println("ЗАДАНИЕ 7\n");

        List<Visitor> visitors = new LinkedList<>();
        visitors.add(new Visitor(0, "Vladislav", "Vyatkin", "+7(996)-414-15-21", true));

        if (bookRepository.insertVisitors(visitors)) {
            System.out.println(bookRepository.getVisitors());
        }
    }
}