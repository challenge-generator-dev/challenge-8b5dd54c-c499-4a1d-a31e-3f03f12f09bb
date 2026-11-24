package com.banca.infrastructure.repositories;

import com.banca.infrastructure.entities.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad Cliente.
 * Proporciona operaciones CRUD para gestionar clientes en la base de datos.
 */
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteJpaEntity, Long> {
    /**
     * Busca un cliente por su email.
     * @param email el email del cliente a buscar
     * @return un Optional que contiene el cliente si existe, o vacío si no existe
     */
    Optional<ClienteJpaEntity> findByEmail(String email);

    /**
     * Verifica si existe un cliente con el email especificado.
     * @param email el email a verificar
     * @return true si existe un cliente con ese email, false en caso contrario
     */
    boolean existsByEmail(String email);
}