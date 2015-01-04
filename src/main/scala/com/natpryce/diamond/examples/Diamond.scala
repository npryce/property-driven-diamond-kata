package com.natpryce.diamond.examples

object Diamond {
  def diamond(maxLetter: Char) : String = {
    val topHalf = for (letter <- 'A' to maxLetter) yield lineFor(maxLetter, letter)
    (topHalf ++ topHalf.reverse.tail).mkString("\n")
  }

  def lineFor(maxLetter: Char, letter: Char): String = {
    val halfLength = ord(maxLetter)
    val letterIndex = halfLength - ord(letter)
    val halfLine = " "*letterIndex + letter + " "*(halfLength-letterIndex)

    halfLine ++ halfLine.reverse.tail
  }

  def squareSide(c: Char) : Int = 2*ord(c) + 1

  def ord(c: Char): Int = c - 'A'
}
