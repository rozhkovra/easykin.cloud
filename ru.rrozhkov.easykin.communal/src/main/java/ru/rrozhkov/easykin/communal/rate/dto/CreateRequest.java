package ru.rrozhkov.easykin.communal.rate.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateRequest {
  private String rateType;
  private Double rateValue;
  private LocalDate dateFrom;
  private LocalDate dateTo;
}
