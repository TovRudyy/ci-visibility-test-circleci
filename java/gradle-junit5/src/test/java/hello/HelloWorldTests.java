package hello;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTests {

    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final PrintStream ps = new PrintStream(baos);

    @BeforeEach
    public void setup() {
        System.setOut(ps);
    }

    @Test
    public void shouldPrintTimeToConsole() {
        HelloWorld.main(new String[]{});

        assertThat(output(), containsString("The current local time is"));
    }

    @Test
    public void shouldPrintHelloWorldToConsole() {
        HelloWorld.main(new String[]{});

        assertThat(output(), containsString("Hello world!"));
    }

    @Test
    public void stupidAssertTrue() {
        assertTrue(true);
    }

    private String output() {
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }
}
