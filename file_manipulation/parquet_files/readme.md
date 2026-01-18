# Parquet Examples – Multi-language

Este repositorio contiene ejemplos simples y claros de **lectura y escritura de archivos Parquet**
usando diferentes lenguajes de programación.

El objetivo principal es **entender Parquet como formato columnar** y mostrar que,
independientemente del lenguaje con el que se escriba, **Spark puede leerlos sin problema**.

---

## 🧠 ¿Qué es Parquet?

Parquet es un **formato de almacenamiento columnar**, optimizado para:

- Analítica
- Big Data
- Lecturas selectivas por columnas
- Compresión eficiente
- Integración con motores como **Apache Spark**

Spark **no depende del lenguaje que generó el archivo**, solo del formato.

---

## 📂 Estructura del proyecto

learn-data-manipulation-basic/
│
├── python/
│ └── parquet_example.py
│
├── java/
│ └── ParquetExample.java
│
├── r/
│ └── parquet_example.R
│
└── README.md


---

## 🐍 Python – pandas + pyarrow

**Archivo:** `parquet_example.py`

- Escritura usando `to_parquet`
- Lectura usando `read_parquet`
- Engine: `pyarrow`
- Compresión: `snappy`

Uso típico:
- Data analysis
- ETL livianos
- Prototipado rápido

---

## ☕ Java – Apache Spark

**Archivo:** `parquet_example.java`

- Uso nativo de Spark
- Escritura y lectura en formato Parquet
- Produce una carpeta Parquet (múltiples archivos)

Uso típico:
- Pipelines de Big Data
- Lakehouse
- Procesamiento distribuido

---

## 📊 R – arrow

**Archivo:** `parquet_example.R`

- Escritura con `write_parquet`
- Lectura con `read_parquet`
- Basado en Apache Arrow

Uso típico:
- Estadística
- Investigación
- Ciencia de datos

---

## ⚡ Lectura de todos los Parquet con Spark

Independientemente del lenguaje que escribió el archivo:

```python
df = spark.read.parquet("path/to/parquet")



## 🌍 ¿En qué otros lenguajes puedes manipular Parquet?  
*(y que Spark puede leer sin problema)*

### ⭐ Lenguajes más importantes

| Lenguaje | Librería | Comentario |
|--------|--------|-----------|
| **Scala** | Spark / Parquet nativo | Lenguaje nativo de Spark |
| **Python** | pyarrow / fastparquet | El más usado |
| **Java** | Spark / parquet-avro | Enterprise |
| **R** | arrow | Estadística |
| **SQL** | Spark SQL / Hive | Lectura directa |
| **C++** | Apache Arrow | Alto rendimiento |
| **Rust** | arrow-rs | Data infra moderna |
| **Go** | parquet-go | Servicios backend |
| **Julia** | Parquet.jl | Ciencia y research |

---

### 🧠 Lo importante (para Spark)

✔ Spark **no pregunta**:
- en qué lenguaje se creó  
- en qué sistema  
- en qué librería  

✔ Spark **solo necesita**:
- Que el archivo sea **Parquet válido**
- Metadatos correctos
- Esquema consistente

---

### 🎯 Mensaje clave para tu contenido (muy CaroData)

> “No es Python vs Java vs R.  
> Es **Parquet + Spark**.”

---

Si quieres, el siguiente paso puede ser:
- 🎥 guion para un **Reel explicando esto**
- 📊 ejemplo leyendo **el mismo Parquet desde los 3**
- 🧪 demo comparando **CSV vs Parquet**
- 🧱 versión **Bronze → Silver → Gold**

Dime y lo armamos 🔥
