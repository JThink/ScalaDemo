package com.eastmoney.scala.demo.fore

import java.io.File

import scala.io.Source

/**
  * Created by qianjc on 16-8-16.
  */
object ForeDemo {


  def main(args: Array[String]): Unit = {
    val file = new File(".").listFiles()
    for (f <- file
         if f.isFile
    ) println(f)


    grep(".*JAVA_MODULE.*")
  }


  def fileLines(file: File) = Source.fromFile(file).getLines().toList

  def grep(pattern: String): Unit = {
    val filesHere = (new java.io.File(".")).listFiles
    for {
      f <- filesHere
      if f.getName.endsWith("iml")
      line <- fileLines(f)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(f + ":" + trimmed)
  }
}
