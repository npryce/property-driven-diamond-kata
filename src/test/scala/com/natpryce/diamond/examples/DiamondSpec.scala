package com.natpryce.diamond.examples

import org.scalacheck._

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  "produces an odd number lines" in {
    forAll (inputChar) { c => assert(isOdd(diamondLines(c).length)) }
  }

  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }

  def isOdd(n : Int) = n % 2 == 1
}
