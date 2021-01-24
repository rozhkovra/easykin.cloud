package ru.rrozhkov.easykin.communal.rate;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<RateEntity, Long>, JpaSpecificationExecutor<RateEntity> {
}
