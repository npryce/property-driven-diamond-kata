package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    "A\n" * lineCount(c)
  }

  def lineCount(c: Char) : Int = (c - 'A')+1
}
