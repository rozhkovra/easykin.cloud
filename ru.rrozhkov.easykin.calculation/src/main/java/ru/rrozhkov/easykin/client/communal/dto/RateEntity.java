package ru.rrozhkov.easykin.client.communal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RateEntity {
  private Long id;
  private String rateType;
  private Double rateValue;
  private LocalDate dateFrom;
  private LocalDate dateTo;
}
