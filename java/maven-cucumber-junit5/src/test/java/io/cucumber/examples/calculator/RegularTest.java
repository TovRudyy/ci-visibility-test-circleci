package io.cucumber.examples.calculator;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;

/**
 * Work around. Surefire does not use JUnits Test Engine discovery
 * functionality. Alternatively execute the
 * org.junit.platform.console.ConsoleLauncher with the maven-antrun-plugin.
 */
@Suite
public class RegularTest {

    @Test
    void thisAlwaysPasses() {
        assert(true);
    }

}
