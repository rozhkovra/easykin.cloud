package ru.rrozhkov.easykin.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("calculate")
public class CalculationRest {

  @Autowired
  CalculationService calculationService;

  @GetMapping("")
  public Double calculate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                    @RequestParam(name = "type", required = false) String type) {
    return calculationService.calculate(date, type);
  }
}
