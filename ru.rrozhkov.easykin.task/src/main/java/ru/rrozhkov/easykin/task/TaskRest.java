package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/task")
public class TaskRest {
    @Autowired
    private TaskDao taskDao;

    @PostMapping("")
    public List<? extends ITask> getTasks(@RequestBody TasksRequest request) {
        return taskDao.search(request);
    }

    @GetMapping("/{id}")
    public ITask getTask(@PathVariable Long id) {
        return taskDao.findById(id);
    }
}
