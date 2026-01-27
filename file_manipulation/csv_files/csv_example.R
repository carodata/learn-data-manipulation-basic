library(sparklyr)
sc <- spark_connect(master = "local")

df_tbl <- copy_to(sc, data.frame(id = c(1, 2), nombre = c("Caro", NA), ciudad = c("Medellín", "Islandia")))

spark_write_csv(df_tbl, path = "output_r", header = TRUE, delimiter = ",", mode = "overwrite")

df_read <- spark_read_csv(sc, name = "data_r", path = "output_r")