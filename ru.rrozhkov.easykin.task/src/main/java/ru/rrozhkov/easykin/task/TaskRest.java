package ru.rrozhkov.easykin.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskRest {
    @Autowired
    private TaskDao taskDao;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<? extends ITask> getTasks(@RequestParam Map<String, String> params) {
        return taskDao.search(params);
    }

    @RequestMapping("/task/{id}")
    public ITask getTask(@PathVariable Integer id) {
        return taskDao.findById(id);
    }
}
