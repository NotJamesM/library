package com.github.notjamesm.library.helper;

public class BookJsonBuilder {
    private String id;
    private String title;
    private String author;

    private BookJsonBuilder() {
        throw new IllegalCallerException("Should not be instantiated.");
    }

    public static BookJsonBuilder aBook() {
        return new BookJsonBuilder();
    }

    public String toJson() {
        return BOOK_TEMPLATE.formatted(id, title, author);
    }

    public BookJsonBuilder withId(String id) {
        this.id = id;
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
              "id": "%s",
              "title": "%s",
              "author": "%s"
            }""";
}
