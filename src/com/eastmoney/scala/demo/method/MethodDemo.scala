package com.eastmoney.scala.demo.method

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV

/**
  * Created by qianjc on 16-8-16.
  */
object MethodDemo {

  def main(args: Array[String]): Unit = {

    // 不带参数
    val printsth = () => println("this is print test")
    // 带一个参数
    val increment = (x: Int) => x + 1
    // 带两个参数
    val sum = (x: Int, y: Int) => x + y

    println(printsth)

    println(increment(1))

    println(sum(1, 2))



    val someNumbers = List(-11, -10, - 5, 0, 5, 10)
    someNumbers.foreach(println)


    // 以下是闭包
    val more = 1
    val addMore = (x: Int) => x + more

    println(addMore(5))


    def increase(more: Int) = (x: Int) => x + more

    println(increase(5))
    println(increase(5)(10))

    echo("a", "b", "c")

    val arr = Array("this", "is", "test")
    echo(arr: _*)


    // 以下是柯理化函数
    def curriedSum(x: Int)(y: Int) = x + y
    val onePlus = curriedSum(1)_
    println(onePlus(5))


    // 闭包模拟柯理化实现
    def first(x: Int) = (y: Int) => x + y
    val second = first(1)
    println(second(5))
  }

  def echo(args: String *) = for(arg <- args) println(arg)


  def filesHere = (new java.io.File(".")).listFiles

  /**
    * 进行文件过滤
    * @param matcher　过滤的算法, 该参数为一个函数(传入1个String类型的参数, 返回布尔值)
    */
  def fileMatcher(matcher: (String) => Boolean) = {
    for(file <- filesHere; if matcher(file.getName))
      yield file
  }


  def fileEnding(query: String) = fileMatcher(_.endsWith(query))
}
