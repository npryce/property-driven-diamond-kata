package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    val side: Int = squareSide(c)

    (for (lc <- 'A' to c) yield lc.toString * side) mkString "\n"
  }

  def squareSide(c: Char) : Int = (c - 'A')+1
}
