package ru.rrozhkov.easykin.communal.measure.dto;

import lombok.Data;

@Data
public class CreateRequest {
  private Long readingId;
  private String measureType;
  private Long measureValue;
}
