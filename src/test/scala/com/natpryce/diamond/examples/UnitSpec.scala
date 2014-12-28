package com.natpryce.diamond.examples

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FreeSpec, Matchers}

@RunWith(classOf[JUnitRunner])
abstract class UnitSpec extends FreeSpec with PropertyChecks with Matchers {
}
