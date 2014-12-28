package com.natpryce.diamond.examples

import org.scalacheck._

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  "produces some lines" in {
    forAll (inputChar) { c => assert(diamondLines(c).nonEmpty) }
  }

  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }
}
