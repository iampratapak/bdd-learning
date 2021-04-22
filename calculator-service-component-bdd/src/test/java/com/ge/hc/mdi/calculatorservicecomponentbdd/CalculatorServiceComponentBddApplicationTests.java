package com.ge.hc.mdi.calculatorservicecomponentbdd;

import com.ge.hc.mdi.calculatorservice.CalculatorServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration
@Testcontainers
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(
    classes = CalculatorServiceApplication.class,
    loader = SpringBootContextLoader.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS) // to restart after each
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CalculatorServiceComponentBddApplicationTests {

  // @ClassRule
  @Container
  public static MSSQLServerContainer<?> mssqlServerContainer =
      new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2017-latest")
          .withPassword("Strong@Pa55word");

  @DynamicPropertySource
  static void mssqlServerProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
    mssqlServerContainer.start();
    dynamicPropertyRegistry.add("spring.datasource.url", mssqlServerContainer::getJdbcUrl);
    dynamicPropertyRegistry.add("spring.datasource.password", mssqlServerContainer::getPassword);
    dynamicPropertyRegistry.add("spring.datasource.username", mssqlServerContainer::getUsername);
  }

  @Test
  public void contextLoads() {}
}
