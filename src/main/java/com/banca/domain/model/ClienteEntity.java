package com.banca.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Entidad de dominio que representa a un cliente del sistema bancario.
 * Es independiente de la persistencia: no conoce JPA ni tablas.
 */
public final class ClienteEntity implements Entity<Long> {

    /**
     * Vista de dominio de una cuenta asociada al cliente.
     * Se declara anidada para mantener el modelo completo dentro de este archivo.
     */
    public record CuentaEntity(
            Long id,
            String numeroCuenta,
            BigDecimal saldo,
            String tipoCuenta,
            LocalDate fechaApertura) {

        public CuentaEntity {
            Objects.requireNonNull(id, "El id de la cuenta no puede ser nulo");
            Objects.requireNonNull(numeroCuenta, "El numero de cuenta no puede ser nulo");
            Objects.requireNonNull(saldo, "El saldo no puede ser nulo");
            Objects.requireNonNull(tipoCuenta, "El tipo de cuenta no puede ser nulo");
            Objects.requireNonNull(fechaApertura, "La fecha de apertura no puede ser nula");
        }
    }

    private final Long id;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final LocalDate fechaNacimiento;
    private final String direccion;
    private final String telefono;
    private final List<CuentaEntity> cuentas;

    public ClienteEntity(Long id, String nombre, String apellido, String email,
                         LocalDate fechaNacimiento, String direccion, String telefono,
                         List<CuentaEntity> cuentas) {
        this.id = Objects.requireNonNull(id, "El id no puede ser nulo");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
        this.apellido = Objects.requireNonNull(apellido, "El apellido no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento, "La fecha de nacimiento no puede ser nula");
        this.direccion = Objects.requireNonNull(direccion, "La direccion no puede ser nula");
        this.telefono = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
        this.cuentas = List.copyOf(Objects.requireNonNull(cuentas, "La lista de cuentas no puede ser nula"));
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<CuentaEntity> getCuentas() {
        return cuentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}