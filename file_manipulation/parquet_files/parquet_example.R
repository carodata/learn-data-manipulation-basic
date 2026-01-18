library(arrow)

# Crear data frame
df <- data.frame(
  id = c(1, 2, 3),
  name = c("Alice", "Bob", "Charlie"),
  age = c(25, 30, 35)
)

# ===== Escritura a Parquet =====
write_parquet(
  df,
  "example.parquet",
  compression = "snappy"
)

cat("Archivo Parquet escrito correctamente\n")

# ===== Lectura desde Parquet =====
df_read <- read_parquet("example.parquet")

print("Datos leídos desde Parquet:")
print(df_read)
