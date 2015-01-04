package com.natpryce.diamond.examples

import com.natpryce.diamond.examples.Diamond.ord
import org.scalacheck._

import scala.collection.generic.CanBuildFrom

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

  "is vertically symmetrical" in {
    forAll (inputChar) { c =>
      val lines = diamondLines(c)

      assert(firstHalfOf(lines) == secondHalfOf(lines).reverse)
    }
  }
  
  "is horizontally symmetrical" in {
    forAll (inputChar) { c =>
      for ((line, index) <- diamondLines(c).zipWithIndex) {
        assert(firstHalfOf(line) == secondHalfOf(line).reverse,
          "line " + index + " should be symmetrical")
      }
    }
  }

  "position of letter in line of spaces" in {
    forAll (inputChar) { c =>
      for ((line, lineIndex) <- firstHalfOf(diamondLines(c)).zipWithIndex) {
        val firstHalf = firstHalfOf(line)
        val expectedLetter = ('A'+lineIndex).toChar
        val letterIndex = firstHalf.length - (lineIndex + 1)

        assert (firstHalf(letterIndex) == expectedLetter, firstHalf)
        assert (firstHalf.count(_==' ') == firstHalf.length-1, "number of spaces in line " + lineIndex + ": " + line)
      }
    }
  }

  def squareSide(c: Char) : Int = 2*ord(c) + 1

  def firstHalfOf[AS, A, That](v: AS)(implicit asSeq: AS => Seq[A], cbf: CanBuildFrom[AS, A, That]) = {
    v.slice(0, (v.length+1)/2)
  }

  def secondHalfOf[AS, A, That](v: AS)(implicit asSeq: AS => Seq[A], cbf: CanBuildFrom[AS, A, That]) = {
    v.slice(v.length/2, v.length)
  }
  
  def diamondLines(c : Char) = {
    Diamond.diamond(c).lines.toVector
  }
}
