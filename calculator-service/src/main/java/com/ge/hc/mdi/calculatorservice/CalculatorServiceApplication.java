package com.ge.hc.mdi.calculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalculatorServiceApplication {

  private static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    context = SpringApplication.run(CalculatorServiceApplication.class, args);
  }

  public static void restart(String[] args) {
    context.close();
    // Starting the Springboot application
    context = SpringApplication.run(CalculatorServiceApplication.class, args);
  }
}
