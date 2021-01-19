package ru.rrozhkov.easykin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.rrozhkov.easykin.dao.ModuleRepository;
import ru.rrozhkov.easykin.entity.ModuleEntity;

@Service
public class ModuleService {
  @Autowired
  ModuleRepository moduleRepository;

  @Cacheable("modules")
  public Iterable<ModuleEntity> modules() {
    return moduleRepository.findAll();
  }

  public ModuleEntity module(Long id) {
    return moduleRepository.findById(id).orElse(null);
  }
}
