package bank;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

    String contents;
    String parsed;

    @Given("^I have an account file with contents:$")
    public void i_have_an_account_file_with_contents(String contents) throws Throwable {
        this.contents = contents;
    }

    @When("^I parse the file$")
    public void i_parse_the_file() throws Throwable {
        parsed = contents.replaceAll("[^0-9]", "");
    }

    @Then("^the first account number is \"([^\"]*)\"$")
    public void the_first_account_number_is(String expected) throws Throwable {
        assertEquals(expected, parsed);
    }


}
