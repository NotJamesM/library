package com.github.notjamesm.library.domain;

public interface BookRepository {

    public Book getBookByIdOrBlowUp(long id);
}
