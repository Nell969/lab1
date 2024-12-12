package com.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader reader = null;
            try {
                reader = new FileReader("books.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Gson gson = new Gson();
            Person[] visitors = gson.fromJson(reader, Person[].class);

            // Задание 1
            List<Person> visitorList = List.of(visitors);
            System.out.println("Visitors:");
            visitorList.forEach(System.out::println);
            System.out.println("Total visitors: " + visitorList.size());

            // Задание 2
            Set<Book> uniqueBooks = visitorList.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .collect(Collectors.toSet());

            System.out.println("Unique books: " + uniqueBooks);
            System.out.println("Total unique books: " + uniqueBooks.size());

            //Задание 3
            List<Book> sortedBooks = uniqueBooks.stream()
                    .sorted(Comparator.comparingInt(Book::getPublishingYear))
                    .toList();

            System.out.println("Books sorted by publishing year: " + sortedBooks);

            // Задание 4
            boolean hasBook = visitorList.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .anyMatch(book -> "Jane Austen".equals(book.getAuthor()));

            System.out.println("Is there a book by Jane Austen: " + hasBook);
        } finally {
        }
        }
    }