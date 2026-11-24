// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.banca.infrastructure.adapters;

import com.banca.domain.model.ClienteEntity;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Adaptador para la gestión de esquemas en PostgreSQL.
 * Genera la definición Terraform para el esquema de clientes.
 */
public final class PostgreSQLSchemaAdapter {

    private static final String SCHEMA_NAME = "clientes";
    private static final String SCHEMA_OWNER = "postgres";

    public PostgreSQLSchemaAdapter() {
    }

    /**
     * Genera la definición Terraform para el esquema de clientes.
     * @return definición Terraform del recurso postgresql_schema
     */
    public String generateSchemaDefinition() {
      throw new UnsupportedOperationException("TODO(reto): generateSchemaDefinition");
    }

    /**
     * Genera la definición Terraform para la tabla clientes dentro del esquema.
     * @return definición Terraform del recurso postgresql_table
     */
    public String generateTableDefinition() {
      throw new UnsupportedOperationException("TODO(reto): generateTableDefinition");
    }

    /**
     * Valida que la definición de la tabla incluya clave primaria.
     * @param tableDefinition definición de la tabla a validar
     * @return true si tiene clave primaria, false en caso contrario
     */
    public boolean validatePrimaryKey(String tableDefinition) {
      throw new UnsupportedOperationException("TODO(reto): validatePrimaryKey");
    }

    /**
     * Convierte una entidad de dominio a la definición de tabla.
     * @param cliente entidad de dominio ClienteEntity
     * @return definición Terraform de la tabla
     */
    public String convertEntityToTableDefinition(ClienteEntity cliente) {
      throw new UnsupportedOperationException("TODO(reto): convertEntityToTableDefinition");
    }

    /**
     * Obtiene el nombre del esquema.
     * @return nombre del esquema
     */
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /**
     * Obtiene el propietario del esquema.
     * @return propietario del esquema
     */
    public String getSchemaOwner() {
        return SCHEMA_OWNER;
    }
}