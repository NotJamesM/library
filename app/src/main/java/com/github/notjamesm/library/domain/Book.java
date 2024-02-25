package com.github.notjamesm.library.domain;

public record Book(Long id, String title, String author) {

    public static Book book(String title, String author){
        return new Book(null, title, author);
    }

}