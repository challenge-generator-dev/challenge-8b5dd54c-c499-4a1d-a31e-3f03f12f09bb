# Normalización de Modelo de Datos en una Aplicación de Banca

Como desarrollador backend en una aplicación de banca, necesitas diseñar e implementar un modelo de datos normalizado para gestionar la información de clientes y sus cuentas. El modelo debe ser coherente con los requerimientos del negocio y debe aplicar las formas normales para reducir redundancias y prevenir anomalías de inserción, actualización y eliminación. Las entidades principales son Clientes y Cuentas, con una relación uno a muchos. Debes identificar entidades, atributos y relaciones, y aplicar las formas normales.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño e Implementación de un Modelo de Datos Normalizado |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Diseño del Modelo Entidad-Relación

**Objetivo:** Crear un modelo Entidad-Relación coherente con los requerimientos del negocio.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- El diagrama debe incluir entidades (Clientes, Cuentas), atributos, relaciones y cardinalidades.
- Debe demostrar la aplicación de al menos la 3FN (Tercera Forma Normal) mediante la eliminación de dependencias transitivas.
- Incluir una breve justificación escrita de las decisiones de normalización (máximo 1 página).
- Validar que el modelo cumpla con los casos de aceptación de la pieza p1.

**Entregable:** Diagrama Entidad-Relación en formato físico o digital (ej. draw.io, Lucidchart, PlantUML)

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que la primera forma normal implica que cada tabla debe tener una clave primaria.
- La segunda forma normal requiere que todas las columnas no clave dependan de la clave primaria.
- La tercera forma normal implica que no haya dependencias transitivas.

</details>

### Fase 2: Implementación del Modelo en PostgreSQL

**Objetivo:** Implementar el modelo normalizado en una base de datos PostgreSQL.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crea las tablas Clientes y Cuentas en PostgreSQL.
- Aplica las restricciones de clave primaria y relaciones de clave foránea según el modelo normalizado.
- Inserta datos de prueba para verificar la integridad del modelo.

**Entregable:** Base de datos PostgreSQL con las tablas Clientes y Cuentas implementadas según el modelo normalizado.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza las sentencias CREATE TABLE y ALTER TABLE para definir las tablas y sus relaciones.
- Asegúrate de que las restricciones de clave primaria y foránea se apliquen correctamente.

</details>

### Fase 3: Integración con Spring Data JPA

**Objetivo:** Integrar el modelo de datos con Spring Data JPA para gestionar las operaciones CRUD.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Configura Spring Data JPA para conectar con la base de datos PostgreSQL.
- Crea las clases de entidad Cliente y Cuenta en Java.
- Implementa los repositorios para gestionar las operaciones CRUD.
- Realiza pruebas unitarias para verificar el funcionamiento de los repositorios.

**Entregable:** Aplicación Spring Boot con las clases de entidad y repositorios implementados para gestionar las operaciones CRUD en las tablas Clientes y Cuentas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza las anotaciones @Entity y @Table para definir las clases de entidad.
- Implementa los métodos de los repositorios utilizando las interfaces CrudRepository o JpaRepository.
- Utiliza JUnit y Mockito para realizar pruebas unitarias.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo Entidad-Relación y por qué es importante en el diseño de bases de datos?
- **paraQueSirve**: ¿Para qué sirve la normalización de datos y cuáles son sus beneficios?
- **comoSeUsa**: ¿Cómo se aplican las formas normales en un modelo de datos?
- **erroresComunes**: ¿Cuáles son los errores comunes al diseñar un modelo de datos y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño de un modelo de datos normalizado y cómo se pueden justificar?

## Criterios de Evaluacion

- Diseño de un modelo Entidad-Relación coherente con los requerimientos.
- Aplicación adecuada de las formas normales para reducir redundancias y prevenir anomalías.
- Implementación correcta del modelo en PostgreSQL.
- Integración exitosa con Spring Data JPA para gestionar las operaciones CRUD.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Diseño del Modelo Entidad-Relación | Diseño de modelos Entidad-Relación normalizados | — | El diagrama incluye entidades, atributos y relaciones con cardinalidades correctas.; El modelo está normalizado hasta la 3FN, sin redundancias ni anomalías.; La justificación escrita explica las decisiones de normalización y su impacto en el diseño. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Implementación de esquemas normalizados en PostgreSQL | `src/main/java/com/banca/infrastructure/adapters/PostgreSQLSchemaAdapter.java:postgresql_schema.clientes` | La base de datos PostgreSQL contiene las tablas Clientes y Cuentas con sus atributos y restricciones.; Las tablas están normalizadas según el modelo diseñado en f1.; Las relaciones entre tablas están implementadas con claves foráneas y restricciones de integridad. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Implementación de relaciones normalizadas en PostgreSQL | `src/main/java/com/banca/infrastructure/adapters/PostgreSQLTableAdapter.java:postgresql_table.cuentas` | La base de datos PostgreSQL contiene las tablas Clientes y Cuentas con sus atributos y restricciones.; Las tablas están normalizadas según el modelo diseñado en f1.; Las relaciones entre tablas están implementadas con claves foráneas y restricciones de integridad. | — | — |
| f3 — Integración con Spring Data JPA | Mapeo de entidades JPA para modelos normalizados | — | La aplicación Spring Boot tiene clases de entidad para Clientes y Cuentas con anotaciones JPA.; Los repositorios Spring Data JPA implementan operaciones CRUD para ambas entidades.; Las relaciones entre entidades están mapeadas correctamente con anotaciones JPA. | — | — |
| f3 — Integración con Spring Data JPA | Mapeo de relaciones JPA para modelos normalizados | — | La aplicación Spring Boot tiene clases de entidad para Clientes y Cuentas con anotaciones JPA.; Los repositorios Spring Data JPA implementan operaciones CRUD para ambas entidades.; Las relaciones entre entidades están mapeadas correctamente con anotaciones JPA. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Diseñó un modelo Entidad‑Relación coherente con los requerimientos y normalizó las tablas de manera adecuada. Identificó entidades, atributos y relaciones, y aplicó las formas normales para reducir redundancias y prevenir anomalías de inserción, actualización y eliminación | sin ubicar | Restriccion no verificada en sin ubicar |

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
