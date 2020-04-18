package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskRest {
    @Autowired
    private TaskDao taskDao;

    @RequestMapping("/tasks")
    public List<? extends ITask> getTasks() {
        return taskDao.findAll();
    }

    @RequestMapping("/task/{id}")
    public ITask getTask(@PathVariable Integer id) {
        return taskDao.findById(id);
    }
}
