package com.example;


import java.util.List;
import java.util.Objects;

class Person {
    String name;
    String surname;
    String phone;
    List<Book> favoriteBooks;
    boolean subscribed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(List<Book> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", favoriteBooks=" + favoriteBooks +
                ", subscribed=" + subscribed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return subscribed == person.subscribed && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(phone, person.phone) && Objects.equals(favoriteBooks, person.favoriteBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, favoriteBooks, subscribed);
    }
}
