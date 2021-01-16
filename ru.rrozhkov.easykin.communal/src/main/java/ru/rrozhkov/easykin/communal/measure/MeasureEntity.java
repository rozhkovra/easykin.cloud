package ru.rrozhkov.easykin.communal.measure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "SERVICE_MEASURE")
@Data
@NoArgsConstructor
public class MeasureEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "READINGID")
  private Long readingId;

  @Column(name = "MEASURETYPE")
  private String measureType;

  @Column(name = "MEASUREVALUE")
  private Long measureValue;
}
