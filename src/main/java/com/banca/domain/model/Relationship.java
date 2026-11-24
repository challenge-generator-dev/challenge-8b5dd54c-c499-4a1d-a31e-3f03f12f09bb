package com.banca.domain.model;

/**
 * Interfaz que define una relación entre entidades del dominio.
 * @param <T> tipo de la entidad origen
 * @param <U> tipo de la entidad destino
 */
public interface Relationship<T extends Entity<?>, U extends Entity<?>> {
    /**
     * Obtiene la entidad origen de la relación.
     * @return la entidad origen
     */
    T getSource();

    /**
     * Obtiene la entidad destino de la relación.
     * @return la entidad destino
     */
    U getTarget();
}