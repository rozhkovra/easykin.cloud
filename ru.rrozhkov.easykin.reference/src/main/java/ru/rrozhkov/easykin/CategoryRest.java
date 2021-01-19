package ru.rrozhkov.easykin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.entity.CategoryEntity;
import ru.rrozhkov.easykin.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/category")
public class CategoryRest {
  @Autowired
  CategoryService categoryService;

  @GetMapping(path = "/")
  public Iterable<CategoryEntity> findAll() {
    return categoryService.categories();
  }

  @GetMapping(path = "/{id}")
  public CategoryEntity category(@PathVariable Long id) {
    return categoryService.category(id);
  }
}
