package com.natpryce.diamond.examples

import com.natpryce.diamond.examples.Diamond.squareSide
import org.scalacheck._

class DiamondSpec extends UnitSpec {
  val inputChar = Gen.alphaUpperChar

  "number of lines" in {
    forAll (inputChar) { c => assert(diamondLines(c).length == squareSide(c)) }
  }

  "squareness" in {
    forAll (inputChar) { c => assert(diamondLines(c) forall {_.length == squareSide(c)}) }
  }
  
  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }
}
