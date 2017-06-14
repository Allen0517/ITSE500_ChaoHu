/**
  * Created by IT on 2017/6/1.
  */
import java.util
import java.sql.Date

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.annotation.Since
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}

case class PriceLogEntry(product_id:String, date:String,old_price:Double,new_price:Double,count:Int)
object Final {
  def average[T]( ts: Iterable[T] )( implicit num: Numeric[T] ) = {
    num.toDouble( ts.sum ) / ts.size
  }

  def mean[T](item:Traversable[T])(implicit n:Numeric[T]) = {
    n.toDouble(item.sum) / item.size.toDouble
  }
  def variance[T](items:Traversable[T])(implicit n:Numeric[T]) : Double = {
    val itemMean = mean(items)
    val count = items.size
    val sumOfSquares = items.foldLeft(0.0d)((total,item)=>{
      val itemDbl = n.toDouble(item)
      val square = math.pow(itemDbl - itemMean,2)
      total + square
    })
    sumOfSquares / count.toDouble
  }
  def stddev[T](items:Traversable[T])(implicit n:Numeric[T]) : Double = {
    math.sqrt(variance(items))
  }

  def main(args: Array[String]): Unit = {
//228
    val log = "C:/Users/IT/Desktop/test.log"
    val conf = {
      new SparkConf().setAppName("LogAnalysis").setMaster("local[2]")
    }
    val sc = new SparkContext(conf)
        sc.setLogLevel("ERROR")
    val lines = sc.textFile(log)

    val splitLine = lines.flatMap(_.split("\t")).
                    map(line => {
        val part = line.split(",")
        val regexprDate = "(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})".r
        val time = regexprDate.findAllIn(part(1)).toList
        val timeString = time.toString().replace("T", " ")
                      PriceLogEntry(part(2),timeString,part(3).toDouble ,part(4).toDouble, 1)})

      val fiteredData = splitLine.filter(words =>words.old_price <= 999.0 &&  words.new_price <= 999.0)
//                     foreach(println)
      val productTotal = fiteredData.map(product => (product.product_id,product.new_price)).groupByKey()


      val mean = productTotal.map(x =>(x._1,average(x._2)))
      val variance = productTotal.map(x =>(x._1,stddev(x._2)))


    val drop = fiteredData.map(product => (product.product_id,product.date,(product.old_price - product.new_price))).foreach(println)

  }
}
















