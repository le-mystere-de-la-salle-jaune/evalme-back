package dev.services;

import java.util.List;

import dev.entites.Sondage;

/**
 * Interface de base des services.
 *
 * @param <T> : nature de l'entité manipulée par le service.
 */
public interface CrudService<T> {
    List<T> findAll();
    void save(T entite);
    void update(T entiteAvecId);
    void delete(T entite);
}
