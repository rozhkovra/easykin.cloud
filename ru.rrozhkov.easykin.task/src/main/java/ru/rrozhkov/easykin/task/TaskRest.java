package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskRest {
    @Autowired
    private TaskDao taskDao;

    @PostMapping("/tasks")
    public List<? extends ITask> getTasks(@RequestParam Map<String, String> params) {
        return taskDao.search(params);
    }

    @GetMapping("/task/{id}")
    public ITask getTask(@PathVariable Integer id) {
        return taskDao.findById(id);
    }
}
