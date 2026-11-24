# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/banca/infrastructure/adapters/PostgreSQLSchemaAdapter.java` — La pieza p2 (Implementación de esquemas normalizados en PostgreSQL, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/com/banca/infrastructure/adapters/PostgreSQLTableAdapter.java` — La pieza p3 (Implementación de relaciones normalizadas en PostgreSQL, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/banca/infrastructure/entities/ClienteJpaEntity.java` — `CuentaJpaEntity.setCliente`: Se invoca `setCliente` sobre `CuentaJpaEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

### Reto
- Tema: Diseño e Implementación de un Modelo de Datos Normalizado
- Seniority: advanced-l2
- Tipo: practical
- Título: Normalización de Modelo de Datos en una Aplicación de Banca
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Diseño del Modelo Entidad-Relación — objetivo: Crear un modelo Entidad-Relación coherente con los requerimientos del negocio. — entregable (NO resolver): Diagrama Entidad-Relación en formato físico o digital (ej. draw.io, Lucidchart, PlantUML)
- Fase 2: Implementación del Modelo en PostgreSQL — objetivo: Implementar el modelo normalizado en una base de datos PostgreSQL. — entregable (NO resolver): Base de datos PostgreSQL con las tablas Clientes y Cuentas implementadas según el modelo normalizado.
- Fase 3: Integración con Spring Data JPA — objetivo: Integrar el modelo de datos con Spring Data JPA para gestionar las operaciones CRUD. — entregable (NO resolver): Aplicación Spring Boot con las clases de entidad y repositorios implementados para gestionar las operaciones CRUD en las tablas Clientes y Cuentas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: src/main/java/Application.java ===
package com.banca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.banca"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banca/domain/model/Entity.java ===
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

// === ARCHIVO: src/main/java/com/banca/domain/model/Relationship.java ===
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

// === ARCHIVO: src/main/java/com/banca/domain/model/ClienteEntity.java ===
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

// === ARCHIVO: src/main/java/com/banca/infrastructure/entities/ClienteJpaEntity.java ===
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

// === ARCHIVO: src/main/java/com/banca/infrastructure/repositories/ClienteJpaRepository.java ===
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

// === ARCHIVO: src/main/java/com/banca/infrastructure/adapters/PostgreSQLSchemaAdapter.java ===
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

// === ARCHIVO: src/main/java/com/banca/infrastructure/adapters/PostgreSQLTableAdapter.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.banca.infrastructure.adapters;


import java.util.Objects;
import java.util.StringJoiner;

/**
 * Adaptador para la gestión de tablas en PostgreSQL.
 * Genera la definición Terraform para la tabla de cuentas con relaciones.
 */
public final class PostgreSQLTableAdapter {

    private static final String TABLE_NAME = "cuentas";
    private static final String SCHEMA_REFERENCE = "postgresql_schema.clientes.name";
    private static final String TABLE_OWNER = "postgres";

    private final PostgreSQLSchemaAdapter schemaAdapter;

    public PostgreSQLTableAdapter(PostgreSQLSchemaAdapter schemaAdapter) {
        this.schemaAdapter = Objects.requireNonNull(schemaAdapter, "El adaptador de esquema no puede ser nulo");
    }

    /**
     * Genera la definición Terraform para la tabla cuentas.
     * @return definición Terraform del recurso postgresql_table
     */
    public String generateTableDefinition() {
      throw new UnsupportedOperationException("TODO(reto): generateTableDefinition");
    }

    /**
     * Valida que la definición de la tabla incluya clave foránea válida.
     * @param tableDefinition definición de la tabla a validar
     * @return true si tiene clave foránea válida, false en caso contrario
     */
    public boolean validateForeignKey(String tableDefinition) {
      throw new UnsupportedOperationException("TODO(reto): validateForeignKey");
    }

    /**
     * Valida que la clave foránea referencie una tabla existente.
     * @param tableDefinition definición de la tabla
     * @param referencedSchema esquema referenciado
     * @return true si la referencia es válida
     */
    public boolean validateForeignKeyReference(String tableDefinition, String referencedSchema) {
      throw new UnsupportedOperationException("TODO(reto): validateForeignKeyReference");
    }

    /**
     * Genera la definición de constraints de integridad referencial.
     * @return definición de constraints
     */
    public String generateReferentialConstraints() {
      throw new UnsupportedOperationException("TODO(reto): generateReferentialConstraints");
    }

    /**
     * Genera la definición de índices para la tabla cuentas.
     * @return definición de índices
     */
    public String generateIndexes() {
      throw new UnsupportedOperationException("TODO(reto): generateIndexes");
    }

    /**
     * Obtiene el nombre de la tabla.
     * @return nombre de la tabla
     */
    public String getTableName() {
        return TABLE_NAME;
    }

    /**
     * Obtiene la referencia al esquema.
     * @return referencia al esquema
     */
    public String getSchemaReference() {
        return SCHEMA_REFERENCE;
    }

    /**
     * Genera el script completo de creación de la tabla cuentas.
     * @return script completo de creación
     */
    public String generateFullTableScript() {
      throw new UnsupportedOperationException("TODO(reto): generateFullTableScript");
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: banca-app
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/banca}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  sql:
    init:
      mode: never
      schema-locations: classpath:schema.sql
      data-locations: classpath:data.sql

server:
  port: ${SERVER_PORT:8080}
  servlet:
    context-path: /api
  compression:
    enabled: true

logging:
  level:
    root: INFO
    com.banca: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: when_authorized
  health:
    db:
      enabled: true

// === ARCHIVO: docker-compose.yml ===
# Infraestructura local del reto. SOLO desarrollo: credenciales de ejemplo (local-dev-only), puertos en loopback.
# Levantar: docker compose up -d --wait
name: infra-local
services:
  postgres:
    image: "postgres:16.4-alpine"
    ports:
      - "127.0.0.1:5432:5432"
    environment:
      POSTGRES_USER: "app"
      POSTGRES_PASSWORD: "local-dev-only"
      POSTGRES_DB: "app"
    volumes:
      - "./infra-local/postgres/init.sql:/docker-entrypoint-initdb.d/init.sql:ro"
    healthcheck:
      test: ["CMD-SHELL","pg_isready -U app -d app"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 10s


// === ARCHIVO: infra-local/README.md ===
# Infraestructura local

Servicios de soporte para el reto, definidos en `docker-compose.yml` (raiz del repo).

```bash
docker compose up -d --wait
```

| Servicio | Imagen | Puertos (host) |
|---|---|---|
| PostgreSQL | `postgres:16.4-alpine` | 5432 |

Credenciales: solo de desarrollo local (`local-dev-only`, `local`). No son secretos ni deben reutilizarse.
Los scripts de `infra-local/` (tablas, topics) se ejecutan con el compose en estado healthy.


// === ARCHIVO: infra-local/postgres/init.sql ===
-- DDL de ejemplo; se ejecuta al crear el volumen de PostgreSQL. Ajustalo a tu modelo.
CREATE TABLE IF NOT EXISTS items (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

```
