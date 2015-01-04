package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    val side: Int = squareSide(c)

    ("A" * side + "\n") * side
  }

  def squareSide(c: Char) : Int = (c - 'A')+1
}
