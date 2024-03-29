package com.github.notjamesm.library.helper;

import java.util.function.Supplier;

public class BookJsonBuilder implements JsonBuilder {
    private long id;
    private Supplier<Long> idSupplier;
    private String title;
    private String author;

    public static BookJsonBuilder aBook() {
        return new BookJsonBuilder();
    }

    @Override
    public String toJson() {
        if(idSupplier != null){
            id = idSupplier.get();
        }
        return BOOK_TEMPLATE.formatted(id, title, author);
    }

    public BookJsonBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BookJsonBuilder withId(Supplier<Long> id) {
        this.idSupplier = id;
        return this;
    }

    public BookJsonBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookJsonBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    private final static String BOOK_TEMPLATE = """
            {
              "id": %s,
              "title": "%s",
              "author": "%s"
            }""";
}
