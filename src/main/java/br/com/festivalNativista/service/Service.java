package br.com.festivalNativista.service;

import java.util.List;
import java.util.Optional;

public interface Service<E> {

    List<E> findAll();

    Optional<E> findById(Long id);

    E save(E entity);

    void deleteById(long id);

    void delete(E entity);
}
