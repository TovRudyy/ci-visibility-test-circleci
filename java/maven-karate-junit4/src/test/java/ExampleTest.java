import static org.junit.Assert.assertEquals;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.Test;

//@RunWith(Karate.class)
public class ExampleTest {

    @Test
    public void testKarate() {
        Results results = Runner.path("classpath:scenario-multiple.feature").parallel(5);
        assertEquals(results.getErrorMessages(), 0, results.getFailCount());
    }
}
