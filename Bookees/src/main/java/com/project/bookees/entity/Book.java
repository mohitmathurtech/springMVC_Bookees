package com.project.bookees.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_id;
    private String b_name;
    private String genre;
    private String author;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public Book() {
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String b_name, String genre, String author) {
        this.b_name = b_name;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
