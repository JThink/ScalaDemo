package com.eastmoney.scala.demo.cls

import java.io.File

import scala.io.Source

/**
  * Created by qianjc on 16-8-15.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = this.gcd(n.abs, d.abs)
  val number = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = n + "/" + d

  def +(that: Rational): Rational = {
    new Rational(number * that.denom + that.number * denom, denom * that.denom)
  }

  /**
    * 重载+操作符以支持Rational和Int相加操作, 如果使用implicit进行隐含类型转换则不需要该重载方法
    * @param i
    * @return
    */
//  def + (i: Int) = new Rational (number + i * denom, denom)


  def *(that: Rational):Rational = {
    new Rational(number * that.number, denom * that.denom)
  }


  /**
    * 求最大公倍数
    * @param a
    * @param b
    */
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}


object Rational {
  def main(args: Array[String]): Unit = {
    val rational1 = new Rational(1, 2)
    val rational2 = new Rational(2, 3)


    println(rational1 + rational2)


    implicit def intToRational(x: Int) = new Rational(x)
    println(rational1 + 1)
    println(rational2 + 2)
    println(2 + rational2)

  }
}