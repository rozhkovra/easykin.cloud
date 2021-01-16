package ru.rrozhkov.easykin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.dao.CategoryRepository;
import ru.rrozhkov.easykin.entity.CategoryEntity;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/category")
public class CategoryRest {
  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping(path = "/")
  public Iterable<CategoryEntity> findAll() {
    return categoryRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  public CategoryEntity category(@PathVariable Long id) {
    return categoryRepository.findById(id).orElse(null);
  }
}
