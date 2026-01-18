import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder()
  .appName("Scala Parquet Example")
  .master("local[*]")
  .getOrCreate()

import spark.implicits._

// Crear DataFrame
val df = Seq(
  (1, "Alice", 25),
  (2, "Bob", 30),
  (3, "Charlie", 35)
).toDF("id", "name", "age")

// Escritura Parquet
df.write.mode("overwrite").parquet("example_parquet_scala")

// Lectura Parquet
val dfRead = spark.read.parquet("example_parquet_scala")
dfRead.show()

spark.stop()
