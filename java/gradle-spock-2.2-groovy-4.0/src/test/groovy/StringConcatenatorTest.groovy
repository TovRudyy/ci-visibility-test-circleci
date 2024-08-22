import datadog.ci.test.StringConcatenator
import spock.lang.Specification

class StringConcatenatorTest extends Specification {

    def "Should concatenate #a and #b"() {
        expect:
        StringConcatenator.concatenate(a, b) == c

        where:
        a   | b   | c
        "1" | "2" | "12"
        "a" | "a" | "aa"
    }
}
