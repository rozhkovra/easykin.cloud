package ru.rrozhkov.easykin.communal.reading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("reading")
public class ReadingRest {
    @Autowired
    ReadingRepository readingRepository;

    @GetMapping("")
    public Iterable<ReadingEntity> readings() {
        return readingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ReadingEntity reading(@PathVariable Long id) {
        return readingRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public ReadingEntity create(@RequestParam("readingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate readingDate) {
        ReadingEntity entity = new ReadingEntity();
        entity.setReadingDate(readingDate);
        return readingRepository.save(entity);
    }
}
