package ru.rrozhkov.easykin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.dao.ModuleRepository;
import ru.rrozhkov.easykin.entity.ModuleEntity;

@RestController
@RequestMapping(path = "/module")
public class ModuleRest {
  @Autowired
  ModuleRepository moduleRepository;

  @GetMapping(path = "/")
  public Iterable<ModuleEntity> findAll() {
    return moduleRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ModuleEntity module(@PathVariable Long id) {
    return moduleRepository.findById(id).orElse(null);
  }
}
