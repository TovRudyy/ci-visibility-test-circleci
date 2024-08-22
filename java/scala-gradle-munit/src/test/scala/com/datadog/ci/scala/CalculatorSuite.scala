package com.datadog.ci.scala

import munit.FunSuite

class CalculatorSuite extends FunSuite {
  test("Calculator.add") {
    assertEquals(Calculator.add(1, 2), 3)
  }

  test("Calculator.test ignored".ignore) {
    assertEquals(Calculator.add(1, 2), 4)
  }

  test("Calculator.test assumption") {
    assume(2 + 2 == 5, "this test always assumes the wrong thing")
    assertEquals(Calculator.add(1, 2), 8)
  }
}
