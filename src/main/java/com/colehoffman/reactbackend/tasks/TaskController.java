package com.colehoffman.reactbackend.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping
    public Task newTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/all")
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Map<String, String> getAll(@PathVariable String id) {
        Long idL = Long.parseLong(id);
        Task task = taskRepository.getById(idL);
        Map<String, String> taskMap = new HashMap<>();
        taskMap.put("status", task.getStatus());
        taskMap.put("name", task.getName());
        taskMap.put("description", task.getDescription());
        taskMap.put("priority", task.getPriority());

        return taskMap;

    }

    @GetMapping("/id/{id}/status")
    public String getStatus(@PathVariable Long id) {
        return taskRepository.getById(id).getStatus();
    }

    @GetMapping("/id/{id}/name")
    public String getName(@PathVariable Long id) {
        return taskRepository.getById(id).getName();
    }

    @GetMapping("/id/{id}/description")
    public String getDescription(@PathVariable Long id) {
        return taskRepository.getById(id).getDescription();
    }

    @PutMapping("/id/{id}/setstatus/{status}")
    public Task putStatus(@PathVariable String id, @PathVariable String status) {
        Long lID = Long.parseLong(id);
        Task currentTask = taskRepository.getById(lID);
        currentTask.setStatus(status);
        return taskRepository.save(currentTask);
    }

    @DeleteMapping("/id/{id}/delete")
    public void deleteTask(@PathVariable String id) {
        taskRepository.deleteById(Long.parseLong(id));
    }

}
