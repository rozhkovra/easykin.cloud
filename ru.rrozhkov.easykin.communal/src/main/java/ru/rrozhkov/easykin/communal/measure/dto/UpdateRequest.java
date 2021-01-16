package ru.rrozhkov.easykin.communal.measure.dto;

import lombok.Data;

@Data
public class UpdateRequest {
  private Long id;
  private Long readingId;
  private String measureType;
  private Long measureValue;
}
