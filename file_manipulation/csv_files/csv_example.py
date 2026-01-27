# Databricks notebook source
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

spark = SparkSession.builder.appName("DataExpert").getOrCreate()

schema = StructType([
    StructField("id", IntegerType(), False),
    StructField("nombre", StringType(), True),
    StructField("ciudad", StringType(), True)
])

data = [(1, "Carolina", "Medellín"), (2, None, "Islandia"), (3, "Rina", None)]
df = spark.createDataFrame(data, schema)

df.coalesce(1).write.format("csv") \
    .option("header", "true") \
    .option("sep", ",") \
    .option("nullValue", "null") \
    .option("encoding", "UTF-8") \
    .mode("overwrite") \
    .save("datos_exportados")

df_read = spark.read.format("csv") \
    .option("header", "true") \
    .schema(schema) \
    .load("datos_exportados")