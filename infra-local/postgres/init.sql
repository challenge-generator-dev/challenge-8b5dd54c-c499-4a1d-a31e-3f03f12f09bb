-- DDL de ejemplo; se ejecuta al crear el volumen de PostgreSQL. Ajustalo a tu modelo.
CREATE TABLE IF NOT EXISTS items (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);