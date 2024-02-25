package com.github.notjamesm.library.infastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

public interface BookJpaRepository extends CrudRepository<BookEntity, Long> {

    BookEntity findBookEntityById(Long aLong);
}
