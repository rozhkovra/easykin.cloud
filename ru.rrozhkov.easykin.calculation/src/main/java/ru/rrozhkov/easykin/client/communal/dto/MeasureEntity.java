package ru.rrozhkov.easykin.client.communal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MeasureEntity {
  private Long id;
  private Long readingId;
  private String measureType;
  private Long measureValue;
}
