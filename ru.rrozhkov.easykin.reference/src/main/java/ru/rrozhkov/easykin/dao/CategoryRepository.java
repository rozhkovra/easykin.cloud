package ru.rrozhkov.easykin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rrozhkov.easykin.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>, JpaSpecificationExecutor<CategoryEntity> {
}
