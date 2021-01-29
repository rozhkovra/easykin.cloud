package ru.rrozhkov.easykin.communal.measure;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends CrudRepository<MeasureEntity, Long>, JpaSpecificationExecutor<MeasureEntity> {
  Iterable<MeasureEntity> findByReadingId(Long readingId);
  Iterable<MeasureEntity> findByReadingIdAndMeasureType(Long readingId, String measureType);
}
