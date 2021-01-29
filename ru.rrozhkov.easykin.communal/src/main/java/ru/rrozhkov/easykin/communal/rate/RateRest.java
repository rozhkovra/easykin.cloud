package ru.rrozhkov.easykin.communal.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.communal.rate.dto.CreateRequest;
import ru.rrozhkov.easykin.communal.rate.dto.UpdateRequest;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("rate")
public class RateRest {
    @Autowired
    RateRepository rateRepository;

    @Autowired
    RateDao rateDao;

    @GetMapping("")
    public Iterable<RateEntity> rates(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                      @RequestParam(name = "type", required = false) String rateType) {
        return rateDao.findByDateAndType(date, rateType);
    }

    @GetMapping("/{id}")
    public RateEntity rate(@PathVariable Long id) {
        return rateRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public RateEntity create(@RequestBody CreateRequest request) {
        RateEntity entity = new RateEntity();
        entity.setId(-1L);
        entity.setRateType(request.getRateType());
        entity.setRateValue(request.getRateValue());
        entity.setDateFrom(request.getDateFrom());
        entity.setDateTo(request.getDateTo());
        return rateRepository.save(entity);
    }

    @PutMapping("")
    public RateEntity update(@RequestBody UpdateRequest request) {
        RateEntity entity = rateRepository.findById(request.getId()).orElse(null);
        entity.setRateType(request.getRateType());
        entity.setRateValue(request.getRateValue());
        entity.setDateFrom(request.getDateFrom());
        entity.setDateTo(request.getDateTo());
        return rateRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rateRepository.deleteById(id);
    }
}
