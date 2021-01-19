package ru.rrozhkov.easykin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrozhkov.easykin.entity.ModuleEntity;
import ru.rrozhkov.easykin.service.ModuleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/module")
public class ModuleRest {
  @Autowired
  ModuleService moduleService;

  @GetMapping(path = "/")
  public Iterable<ModuleEntity> findAll() {
    return moduleService.modules();
  }

  @GetMapping(path = "/{id}")
  public ModuleEntity module(@PathVariable Long id) {
    return moduleService.module(id);
  }
}
