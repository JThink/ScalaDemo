package com.eastmoney.scala.demo.exception

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * Created by qianjc on 16-8-16.
  */
object ExceptionDemo {


  def main(args: Array[String]): Unit = {

    val n = 10

    val half = if (n % 2 == 0) n / 2 else throw new IllegalArgumentException

    println(half)

    try {
      val f = new FileReader("s.iml")
    } catch {
      case ex: FileNotFoundException => {
        println("找不到该文件")
        println(ex)
//        throw ex
      }
      case ex: IOException => println("io exception")
    } finally {
      println("finally")
    }

  }
}
