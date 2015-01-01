package com.natpryce.diamond.examples

object Diamond {
  def diamond(c: Char) : String = {
    "A\n" * (ord(c)+1)
  }

  def ord(c: Char) : Int = c - 'A'

}
