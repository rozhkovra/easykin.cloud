package ru.rrozhkov.easykin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rrozhkov.easykin.entity.ModuleEntity;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long>, JpaSpecificationExecutor<ModuleEntity> {
}
