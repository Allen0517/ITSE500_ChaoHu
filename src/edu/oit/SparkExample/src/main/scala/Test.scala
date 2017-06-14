/**
  * Created by IT on 2017/6/1.
  */
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.annotation.Since
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}


object Test {
  def main(args: Array[String]): Unit = {
    val bible = "C:/Users/IT/Desktop/pg10.txt"
    val conf = new SparkConf().setAppName("CountbibleWords").setMaster("local[2]")
    val sc = new SparkContext(conf)
//    sc.setLogLevel("ERROR")
    val lines = sc.textFile(bible)
    val words = lines.flatMap(_.split(" ")).
                      map(_.replaceAll("""\W""", "").toLowerCase()).
                      filter(_.matches("""[A-Za-z]+""")).
                      map(word => (word,1)).
                      reduceByKey((a,b)=> a+b).
                      map(item => item.swap).
                      sortByKey(false, 1).
                      map(item => item.swap)

    System.out.println(words.take(10).mkString("\n"))
//    words.foreach(println)
  }
}
















