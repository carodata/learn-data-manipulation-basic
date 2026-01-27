CREATE TABLE IF NOT EXISTS datos_viaje (
    id INT,
    nombre STRING,
    ciudad STRING
)
USING CSV
OPTIONS (
    path 'ruta/al/csv',
    header 'true',
    nullValue 'null',
    delimiter ','
);

INSERT INTO datos_viaje VALUES (1, 'Carolina', 'Medellín'), (2, NULL, 'Islandia');

SELECT * FROM datos_viaje WHERE nombre IS NOT NULL;