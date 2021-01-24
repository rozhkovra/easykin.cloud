package ru.rrozhkov.easykin.communal.rate;

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
@Table(name = "SERVICE_RATE")
@Data
@NoArgsConstructor
public class RateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "RATETYPE")
  private String rateType;

  @Column(name = "RATEVALUE")
  private Double rateValue;

  @Column(name = "DATEFROM")
  private LocalDate dateFrom;

  @Column(name = "DATETO")
  private LocalDate dateTo;
}
