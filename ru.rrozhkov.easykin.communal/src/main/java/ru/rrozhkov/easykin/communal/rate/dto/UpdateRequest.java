package ru.rrozhkov.easykin.communal.rate.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateRequest {
  private Long id;
  private String rateType;
  private Double rateValue;
  private LocalDate dateFrom;
  private LocalDate dateTo;
}