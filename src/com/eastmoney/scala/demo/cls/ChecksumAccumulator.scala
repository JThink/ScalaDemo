package com.eastmoney.scala.demo.cls

import scala.collection.mutable.Map

/**
  * Created by qianjc on 16-8-15.
  */

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) = sum += b
  def checkSum() = ~(sum & 0xFF) + 1
}


object ChecksumAccumulator {

  private val cache = Map[String, Int]()

  def calculate(s: String) = {
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccumulator
      for( c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += ( s -> cs)
      cache
    }
  }

  def main(args: Array[String]): Unit = {
    println(ChecksumAccumulator.calculate("Welcome to Scala Chinese community"))
  }
}


