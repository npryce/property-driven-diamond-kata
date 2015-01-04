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
  
  "single letter per line" in {
    forAll (inputChar) { c =>
      val allLines = diamondLines(c)
      val topHalf = allLines.slice(0, allLines.size/2 + 1)

      for ((line, index) <- topHalf.zipWithIndex) {
        val lettersInLine = line.toCharArray.toSet diff Set(' ')
        val expectedOnlyLetter = ('A' + index).toChar
        assert(lettersInLine == Set(expectedOnlyLetter), "line " + index + ": \"" + line + "\"")
      }
    }
  }
  
  
  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }
}
