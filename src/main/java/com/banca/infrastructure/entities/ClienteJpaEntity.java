package com.banca.infrastructure.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad JPA de clientes. La relacion 1:N con cuentas se mantiene desde la cuenta
 * (clave foranea cliente_id), y la cascada con orphanRemoval controla el ciclo de vida.
 */
@Entity
@Table(name = "clientes")
public class ClienteJpaEntity {

    /**
     * Entidad JPA de cuentas, anidada para la relacion con clientes.
     */
    @Entity
    @Table(name = "cuentas")
    public static class CuentaJpaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "numero_cuenta", nullable = false, unique = true)
        private String numeroCuenta;

        @Column(nullable = false, precision = 19, scale = 2)
        private BigDecimal saldo;

        @Column(name = "tipo_cuenta", nullable = false)
        private String tipoCuenta;

        @Column(name = "fecha_apertura", nullable = false)
        private LocalDate fechaApertura;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cliente_id", nullable = false)
        private ClienteJpaEntity cliente;

        protected CuentaJpaEntity() {
        }

        public CuentaJpaEntity(String numeroCuenta, BigDecimal saldo, String tipoCuenta, LocalDate fechaApertura) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            this.tipoCuenta = tipoCuenta;
            this.fechaApertura = fechaApertura;
        }

        public Long getId() {
            return id;
        }

        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public BigDecimal getSaldo() {
            return saldo;
        }

        public String getTipoCuenta() {
            return tipoCuenta;
        }

        public LocalDate getFechaApertura() {
            return fechaApertura;
        }

        public ClienteJpaEntity getCliente() {
            return cliente;
        }

        public void setSaldo(BigDecimal saldo) {
            this.saldo = saldo;
        }

        void setCliente(ClienteJpaEntity cliente) {
            this.cliente = cliente;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CuentaJpaEntity> cuentas = new ArrayList<>();

    protected ClienteJpaEntity() {
    }

    public ClienteJpaEntity(String nombre, String apellido, String email,
                            LocalDate fechaNacimiento, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

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

    public List<CuentaJpaEntity> getCuentas() {
        return List.copyOf(cuentas);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void addCuenta(CuentaJpaEntity cuenta) {
        cuentas.add(cuenta);
        cuenta.setCliente(this);
    }

    public void removeCuenta(CuentaJpaEntity cuenta) {
        cuentas.remove(cuenta);
        cuenta.setCliente(null);
    }
}