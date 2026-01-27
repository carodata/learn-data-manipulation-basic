import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ParquetExample {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("Parquet Example")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> df = spark.createDataFrame(
                java.util.Arrays.asList(
                        new Person(1, "Alice", 25),
                        new Person(2, "Bob", 30),
                        new Person(3, "Charlie", 35)
                ),
                Person.class
        );

        df.write()
          .mode("overwrite")
          .parquet("example_parquet");

 
        Dataset<Row> dfRead = spark.read()
                                   .parquet("example_parquet");

        dfRead.show();

        spark.stop();
    }

    public static class Person {
        public int id;
        public String name;
        public int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }
}
