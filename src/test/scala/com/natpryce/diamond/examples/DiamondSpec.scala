package com.natpryce.diamond.examples

import com.natpryce.diamond.examples.Diamond.squareSide
import org.scalacheck._

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  "squareness" in {
    forAll (inputChar) { c =>
      val lines = diamondLines(c)
      assert(lines forall {line => line.length == lines.length}) }
  }

  "size of square" in {
    forAll (inputChar) { c => assert(diamondLines(c).length == squareSide(c)) }
  }
  
  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }
}
