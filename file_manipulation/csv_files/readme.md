# CSV vs. Parquet: La Guía del Ingeniero para Proyectos de Big Data

Como profesionales de datos, la elección del formato de archivo puede determinar si un pipeline es eficiente o un agujero negro de presupuesto y tiempo. Este documento detalla por qué el **CSV** es el "peor enemigo" del rendimiento y por qué **Apache Parquet** es la solución estándar.

## 1. El Problema con el CSV (Row-Based Text)

El **CSV (Comma-Separated Values)** es un formato orientado a filas y almacenado en texto plano. Aunque es legible por humanos, tiene fallas críticas en ingeniería de datos:

### A. Inferencia de Esquema (Schema Inference)
El CSV no contiene metadatos. El motor de procesamiento debe leer las primeras filas para "adivinar" si una columna es `Integer` o `String` o otro tipo de dato. Esto consume CPU y es propenso a errores de tipado.

### B. Lectura Ineficiente de Columnas
Si tienes una tabla con 200 columnas pero solo necesitas 2 para un reporte, el motor **está obligado a leer la fila completa** y descartar el resto en memoria. Esto genera un cuello de botella masivo en el I/O del disco.

### C. Almacenamiento Pesado
Al ser texto plano, un número como `1,234,567,890` ocupa 10 bytes (uno por cada dígito). En formatos binarios, esto se almacena en apenas 4 o 8 bytes.

---

## 2. La Solución: Apache Parquet (Columnar Storage)

Parquet es un formato **binario** y **orientado a columnas** diseñado específicamente para el ecosistema de Big Data.

### Ventajas Técnicas:

1. **Proyección de Columnas (Column Projection):** Solo se leen del disco las columnas solicitadas. Si pides 2 columnas de 100, el tiempo de lectura se reduce drásticamente.
2. **Predicate Pushdown:** Los metadatos de Parquet (min/max de cada bloque) permiten que Spark descarte archivos completos sin siquiera abrirlos si los datos no cumplen con un filtro (ej. `WHERE fecha > '2024-01-01'`).
3. **Compresión Inteligente:** Al agrupar datos del mismo tipo en una columna, los algoritmos de compresión (Snappy, Gzip, Zstd) son hasta un 80% más eficientes que en CSV.
4. **Esquema Embebido:** El esquema es parte del archivo. No hay ambigüedad en los tipos de datos.

---

## 3. Tabla Comparativa de Rendimiento

| Característica | CSV | Apache Parquet |
| :--- | :--- | :--- |
| **Formato** | Texto Plano (ASCII/UTF-8) | Binario (Optimizado) |
| **Estructura** | Orientado a Filas | Orientado a Columnas |
| **Metadatos/Esquema** | No (Requiere lectura extra) | Sí (Autodescriptivo) |
| **Compresión** | Muy baja / Nula | Alta (Snappy/Gzip) |
| **Escalabilidad** | Pobre (Limitado por I/O) | Excelente (Paralelizable) |
| **Uso Ideal** | Intercambio manual pequeño | Data Lakes / Producción |

