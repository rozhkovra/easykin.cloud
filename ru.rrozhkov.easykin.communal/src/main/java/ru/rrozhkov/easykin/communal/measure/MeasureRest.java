package ru.rrozhkov.easykin.communal.measure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.communal.measure.dto.CreateRequest;
import ru.rrozhkov.easykin.communal.measure.dto.UpdateRequest;

@RestController
@RequestMapping("measure")
public class MeasureRest {
    @Autowired
    MeasureRepository measureRepository;

    @GetMapping("")
    public Iterable<MeasureEntity> measures(@RequestParam("readingId") Long readingId) {
        return measureRepository.findByReadingId(readingId);
    }

    @GetMapping("/{id}")
    public MeasureEntity measure(@PathVariable Long id) {
        return measureRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public MeasureEntity create(@RequestBody CreateRequest request) {
        MeasureEntity entity = new MeasureEntity();
        entity.setId(-1L);
        entity.setReadingId(request.getReadingId());
        entity.setMeasureType(request.getMeasureType());
        entity.setMeasureValue(request.getMeasureValue());
        return measureRepository.save(entity);
    }

    @PutMapping("")
    public MeasureEntity update(@RequestBody UpdateRequest request) {
        MeasureEntity entity = measureRepository.findById(request.getId()).orElse(null);
        entity.setReadingId(request.getReadingId());
        entity.setMeasureType(request.getMeasureType());
        entity.setMeasureValue(request.getMeasureValue());
        return measureRepository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        measureRepository.deleteById(id);
    }
}
