package ru.rrozhkov.easykin.communal.reading;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends CrudRepository<ReadingEntity, Long>, JpaSpecificationExecutor<ReadingEntity> {
}
