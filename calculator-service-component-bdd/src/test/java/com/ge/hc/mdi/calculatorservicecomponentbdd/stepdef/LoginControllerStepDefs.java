package com.ge.hc.mdi.calculatorservicecomponentbdd.stepdef;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.hc.mdi.calculatorservicecomponentbdd.CalculatorServiceComponentBddApplicationTests;
import com.ge.hc.mdi.calculatorservicecomponentbdd.ErrorResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class LoginControllerStepDefs {

  @Autowired private ObjectMapper objectMapper;

  private final WebClient webClient;

  private ClientResponse clientResponse;

  LoginControllerStepDefs() {
    webClient = WebClient.builder().baseUrl("http://localhost:8083").build();
  }

  @Given("user has an account")
  public void userHasAnAccount() {}

  @When("user login with {string} and {string}")
  public void userLoginWithAnd(String username, String password) {
    String body = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
    clientResponse =
        webClient
            .post()
            .uri("/api/v1/login")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(body))
            .exchange()
            .block();
  }

  @Then("user should get the status code {string}")
  public void userShouldGetTheStatusCode(String arg0) {
    String res = String.valueOf(clientResponse.statusCode().value());
    Assert.assertEquals(arg0, res);
    ErrorResponse errorResponse = clientResponse.bodyToFlux(ErrorResponse.class).blockFirst();
    System.out.println(errorResponse);
    Assert.assertNotNull(errorResponse);
  }

  @And("response should contain username {string}")
  public void responseShouldContainUsername(String arg0) {}
}
