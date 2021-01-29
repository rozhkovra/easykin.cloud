package ru.rrozhkov.easykin.client.communal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rrozhkov.easykin.client.communal.dto.MeasureEntity;
import ru.rrozhkov.easykin.client.communal.dto.RateEntity;
import ru.rrozhkov.easykin.client.communal.dto.ReadingEntity;

import java.time.LocalDate;

@FeignClient("CommunalService")
public interface CommunalClient {
  @GetMapping("/reading")
  Iterable<ReadingEntity> readings(@RequestParam(name = "readingDate", required = false)
                                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate readingDate);

  @GetMapping("/measure")
  Iterable<MeasureEntity> measures(@RequestParam("readingId") Long readingId,
                                          @RequestParam(name = "type", required = false) String type);

  @GetMapping("/rate")
  Iterable<RateEntity> rates(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                    @RequestParam(name = "type", required = false) String rateType);
}
