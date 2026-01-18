-- Crear tabla Parquet
CREATE TABLE parquet_example (
  id INT,
  name STRING,
  age INT
)
USING PARQUET;

-- Insertar datos
INSERT INTO parquet_example VALUES
(1, 'Alice', 25),
(2, 'Bob', 30),
(3, 'Charlie', 35);

-- Leer datos
SELECT * FROM parquet_example;
