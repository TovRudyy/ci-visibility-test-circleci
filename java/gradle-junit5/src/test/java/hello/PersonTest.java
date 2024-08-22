package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testNameGetter() {
        Person p = new Person("John");
        assertEquals("John", p.getName());
    }

}
