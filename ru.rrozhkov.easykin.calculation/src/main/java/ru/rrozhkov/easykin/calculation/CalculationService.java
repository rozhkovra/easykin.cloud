package ru.rrozhkov.easykin.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.rrozhkov.easykin.client.communal.CommunalClient;
import ru.rrozhkov.easykin.client.communal.dto.MeasureEntity;
import ru.rrozhkov.easykin.client.communal.dto.RateEntity;
import ru.rrozhkov.easykin.client.communal.dto.ReadingEntity;

import java.time.LocalDate;
import java.util.Collection;

import static java.util.Collections.EMPTY_LIST;

@Service
public class CalculationService {

  @Autowired
  CommunalClient communalClient;

  public double calculate(LocalDate date, String type) {
    LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());
    LocalDate lastDayOfPrevMonth = date.withDayOfMonth(1).minusDays(1);
    Collection<MeasureEntity> currentMeasures = getMeasuresByDateAndType(lastDayOfMonth, type);
    Collection<MeasureEntity> previousMeasures = getMeasuresByDateAndType(lastDayOfPrevMonth, type);
    Collection<RateEntity> rates = (Collection<RateEntity>) communalClient.rates(lastDayOfMonth, type);
    if (CollectionUtils.isEmpty(rates)) {
      return 0.0;
    }
    RateEntity rate = rates.stream().findFirst().get();
    if (CollectionUtils.isEmpty(currentMeasures)) {
      return rate.getRateValue();
    }
    return calculateMeasures(currentMeasures, previousMeasures, rate);
  }

  private double calculateMeasures(Collection<MeasureEntity> currentMeasures, Collection<MeasureEntity> previousMeasures, RateEntity rate) {
    long currentMeasure = currentMeasures.stream().map(m -> m.getMeasureValue()).reduce(0L, Long::sum);
    long previousMeasure = previousMeasures.stream().map(m -> m.getMeasureValue()).reduce(0L, Long::sum);
    return (currentMeasure - previousMeasure)*rate.getRateValue();
  }

  private Collection<MeasureEntity> getMeasuresByDateAndType(LocalDate lastDayOfMonth, String type) {
    Collection<ReadingEntity> readings = (Collection<ReadingEntity>)communalClient.readings(lastDayOfMonth);
    if (CollectionUtils.isEmpty(readings)) {
      return EMPTY_LIST;
    }
    ReadingEntity readingEntity = readings.iterator().next();
    return (Collection<MeasureEntity>) communalClient.measures(readingEntity.getId(), type);
  }
}
