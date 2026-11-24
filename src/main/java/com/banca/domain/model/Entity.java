package com.banca.domain.model;

import java.util.Objects;

/**
 * Interfaz base para todas las entidades del dominio.
 * Proporciona métodos comunes para identificar y comparar entidades.
 */
public interface Entity<T> {
    /**
     * Obtiene el identificador único de la entidad.
     * @return el identificador de la entidad
     */
    T getId();

    /**
     * Verifica si esta entidad es igual a otra.
     * Dos entidades son iguales si tienen el mismo identificador.
     * @param other la otra entidad a comparar
     * @return true si las entidades son iguales, false en caso contrario
     */
    default boolean sameIdentityAs(Entity<T> other) {
        return other != null && Objects.equals(getId(), other.getId());
    }
}