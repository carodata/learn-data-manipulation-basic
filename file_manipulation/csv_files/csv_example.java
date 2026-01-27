import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;
import java.util.Arrays;
import java.util.List;

StructType schema = new StructType(new StructField[]{
    DataTypes.createStructField("id", DataTypes.IntegerType, false),
    DataTypes.createStructField("nombre", DataTypes.StringType, true),
    DataTypes.createStructField("ciudad", DataTypes.StringType, true)
});

List<Row> data = Arrays.asList(
    RowFactory.create(1, "Carolina", "Medellín"),
    RowFactory.create(2, null, "Islandia")
);

Dataset<Row> df = spark.createDataFrame(data, schema);

df.write().mode(SaveMode.Overwrite)
    .option("header", "true")
    .option("nullValue", "null")
    .csv("path_java");