package com.ge.hc.mdi.calculatorservice.controller;

import com.ge.hc.mdi.calculatorservice.model.Result;
import com.ge.hc.mdi.calculatorservice.repository.CalculatorHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

  @Autowired
  private CalculatorHistoryRepository calculatorHistoryRepository;

  @GetMapping
  public int add(@RequestParam("input1") int a, @RequestParam("input2") int b) throws Exception {
    if (a == 5) {
      throw new IllegalArgumentException("I am not supporting 5");
    }
    int res = a + b;
    Result result = new Result(a, b, res);
    calculatorHistoryRepository.save(result);
    return a + b;
  }
}
