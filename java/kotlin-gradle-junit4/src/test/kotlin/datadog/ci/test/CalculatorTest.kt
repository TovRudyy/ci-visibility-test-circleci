import datadog.ci.test.Calculator
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorTest {
    @Test
    fun `test addition()`() {
        val calculator = Calculator()
        val result = calculator.add(2, 3)
        assertEquals(5, result)
    }
}