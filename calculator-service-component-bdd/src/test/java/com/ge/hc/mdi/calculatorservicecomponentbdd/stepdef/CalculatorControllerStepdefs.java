package com.ge.hc.mdi.calculatorservicecomponentbdd.stepdef;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.hc.mdi.calculatorservicecomponentbdd.CalculatorServiceComponentBddApplicationTests;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class CalculatorControllerStepdefs extends CalculatorServiceComponentBddApplicationTests {

  @Autowired
  private ObjectMapper objectMapper;

  private final WebClient webClient;

  private ClientResponse clientResponse;

  CalculatorControllerStepdefs() {
    webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
  }

  @Given("calculator service is running")
  public void calculatorServiceIsRunning() {}

  @When("invoke get api with {string} and {string}")
  public void invokeCalculatorAPIWithInput1AndInput2(String a, String b) {
    clientResponse =
        webClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/api/v1/calculator")
                        .queryParam("input1", a)
                        .queryParam("input2", b)
                        .build())
            .exchange()
            .block();

    Assert.assertNotNull(objectMapper);
  }

  @Then("verify the response {string}")
  public void verifyResponse(String response) {
    String res = String.valueOf(clientResponse.statusCode().value());
    Assert.assertEquals(response, res);
  }

  @Then("verify result {string}")
  public void verifyResult(String result) {
    Integer res = clientResponse.bodyToFlux(Integer.class).blockFirst();
    Assert.assertEquals(result, String.valueOf(res));
  }

  @And("verify error message {string}")
  public void verifyErrorMessage(String errorMessage) {
    String message = clientResponse.bodyToFlux(String.class).blockFirst();
    assert message != null;
    Assert.assertTrue(message.contains(errorMessage));
  }
}
