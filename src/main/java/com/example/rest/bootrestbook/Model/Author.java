package com.example.rest.bootrestbook.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    private String firstName;
    private String lastName;
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
