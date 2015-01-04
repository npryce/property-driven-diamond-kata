package com.natpryce.diamond.examples

object DiamondApp extends App {
  import Diamond.diamond

  println(diamond(args.lift(0).getOrElse("Z").charAt(0)))
}
