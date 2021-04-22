package com.ge.hc.mdi.calculatorservice.repository;

import com.ge.hc.mdi.calculatorservice.model.Result;
import org.springframework.data.repository.CrudRepository;

public interface CalculatorHistoryRepository extends CrudRepository<Result, String> {}
