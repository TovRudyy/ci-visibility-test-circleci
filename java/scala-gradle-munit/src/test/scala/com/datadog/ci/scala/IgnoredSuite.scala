package com.datadog.ci.scala

import munit.FunSuite

@munit.IgnoreSuite
class IgnoredSuite extends FunSuite {
  test("Calculator.add") {
    assertEquals(Calculator.add(1, 2), 3)
  }
}
