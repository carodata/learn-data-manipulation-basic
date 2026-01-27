import org.apache.spark.sql.types._
import org.apache.spark.sql.SaveMode

val schema = StructType(List(
  StructField("id", IntegerType, false),
  StructField("nombre", StringType, true),
  StructField("ciudad", StringType, true)
))

val data = Seq(Row(1, "Caro", "Medellín"), Row(2, null, "Bogotá"))
val df = spark.createDataFrame(spark.sparkContext.parallelize(data), schema)

// Escritura optimizada
df.write
  .option("header", "true")
  .option("charset", "UTF-8")
  .option("nullValue", "NA")
  .mode(SaveMode.Overwrite)
  .csv("output_scala")