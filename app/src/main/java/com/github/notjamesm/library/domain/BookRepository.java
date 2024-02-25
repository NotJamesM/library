package com.github.notjamesm.library.domain;

public interface BookRepository {

    Book getBookByIdOrBlowUp(long id);
}
