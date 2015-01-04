package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    val side: Int = squareSide(c)

    val topHalf = for (lc <- 'A' to c) yield lineFor(side, lc)
    val bottomHalf = topHalf.slice(0, topHalf.length-1).reverse
    (topHalf ++ bottomHalf).mkString("\n")
  }

  def lineFor(side: Int, lc: Char): String = {
    lc.toString * side
  }

  def squareSide(c: Char) : Int = 2*(c - 'A') + 1
}
