package ru.rrozhkov.easykin.client.communal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ReadingEntity {
  private Long id;
  private LocalDate readingDate;
}
