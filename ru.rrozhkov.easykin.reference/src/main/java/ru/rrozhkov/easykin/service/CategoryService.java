package ru.rrozhkov.easykin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.rrozhkov.easykin.dao.CategoryRepository;
import ru.rrozhkov.easykin.entity.CategoryEntity;

@Service
public class CategoryService {
  @Autowired
  CategoryRepository categoryRepository;

  @Cacheable("categories")
  public Iterable<CategoryEntity> categories() {
    return categoryRepository.findAll();
  }

  public CategoryEntity category(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }
}
