package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    val side: Int = squareSide(c)

    val topHalf = for (letter <- 'A' to c) yield lineFor(side, letter)
    (topHalf ++ topHalf.reverse.tail).mkString("\n")
  }

  def lineFor(length: Int, letter: Char): String = {
    val halfLength = length/2
    val letterIndex = halfLength - ord(letter)
    val halfLine = " "*letterIndex + letter + " "*(halfLength-letterIndex)

    halfLine ++ halfLine.reverse.tail
  }

  def squareSide(c: Char) : Int = 2*ord(c) + 1

  def ord(c: Char): Int = c - 'A'
}
