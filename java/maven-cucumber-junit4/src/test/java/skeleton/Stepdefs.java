package skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

    Belly belly = new Belly();

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        belly.eat(cukes);
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
        belly.digest();
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        assert(belly.isHungry());
    }


}
