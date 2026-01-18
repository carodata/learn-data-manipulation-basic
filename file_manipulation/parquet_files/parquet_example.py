# Databricks notebook source
import pandas as pd

# Crear un DataFrame de ejemplo
df = pd.DataFrame({
    "id": [1, 2, 3],
    "name": ["Alice", "Bob", "Charlie"],
    "age": [25, 30, 35]
})

# ===== Escritura a Parquet =====
df.to_parquet(
    "example.parquet",
    engine="pyarrow",
    compression="snappy",
    index=False
)

print("Archivo Parquet escrito correctamente")

# ===== Lectura desde Parquet =====
df_read = pd.read_parquet(
    "example.parquet",
    engine="pyarrow"
)

print("Datos leídos desde Parquet:")
print(df_read)