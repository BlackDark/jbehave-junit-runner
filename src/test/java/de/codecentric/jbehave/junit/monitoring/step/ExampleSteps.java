package de.codecentric.jbehave.junit.monitoring.step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.junit.Assert;

public class ExampleSteps {
    int x;
    
    @Given("a variable x with value $value")
    public void givenXValue(@Named("value") int value) {
        x = value;
    }
    
    @When("I multiply x by $value")
    public void whenImultiplyXBy(@Named("value") int value) {
        x = x * value;
    }
    
	@When("I multiply x with all of:$param")
	public void whenImultiplyXByOneOf(ExamplesTable param) {
		for (Parameters p : param.getRowsAsParameters()) {
			Integer value = p.valueAs("Value", Integer.class);
			x = x * value;
		}
	}
    
    @Then("x should equal $value")
    public void thenXshouldBe(@Named("value") int value) {
        Assert.assertEquals(value, x);
    }

    @Given("some initialization")
    public void givenSomeInitialization() {
    	System.out.println("Init");
    }
    
    @Given("a Greeting to $somebody")
    public void givenAGreetingToSomebody(@Named("somebody") String somebody) {
    	System.out.println("Hello "+somebody);
    }
}
