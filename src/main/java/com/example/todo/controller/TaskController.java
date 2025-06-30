package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Task;
import com.example.todo.service.TaskService;

// Bu sınıfın bir Spring REST Controller olduğunu belirtir
@RestController

// Tüm endpoint'lerin "/api/tasks" ile başlayacağını tanımlar
@RequestMapping("/api/tasks")
public class TaskController {

    // TaskService bağımlılığını tutacak final değişken
    private final TaskService taskService;

    // Constructor Dependency Injection ile TaskService enjekte edilir
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    // GET isteklerini işler - Tüm task'ları döner
    @GetMapping
    public List<Task> getAllTasks(){
        // TaskService üzerinden tüm task'ları getirir
        return taskService.getAllTasks();
    }

    // POST isteklerini işler - Yeni task oluşturur
    @PostMapping
    public Task createTask(@RequestBody Task task){
        // Request body'den gelen task'ı kaydeder
        return taskService.createTask(task);
    }

    // PUT isteklerini işler - Varolan task'ı günceller
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        // URL'den alınan id ve body'den gelen task ile güncelleme yapar
        return taskService.updateTask(id, task);
    }

    // DELETE isteklerini işler - Task siler
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        // Verilen id'ye göre task siler
        taskService.deleteTask(id);
    }

}