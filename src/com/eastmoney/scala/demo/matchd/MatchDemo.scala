package com.eastmoney.scala.demo.matchd

/**
  * Created by qianjc on 16-8-16.
  */
object MatchDemo {


  def main(args: Array[String]): Unit = {
    val m = "s"

    val rs = m match {
      case "m" => "this is m"
      case "n" => "this is n"
      case "b" => "this is b"
      case _ => "this is default"
    }
    println(rs)

  }
}
