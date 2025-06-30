package  com.example.todo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;


// Bu sınıfın bir Spring servis bileşeni olduğunu belirtir
// (Business logic katmanı olarak işaretler)
@Service
public class TaskService{

    // TaskRepository bağımlılığını tutan final değişken
    private final TaskRepository taskRepository;

     // Constructor Dependency Injection ile TaskRepository enjekte edilir
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // Tüm task'ları getiren servis metodu
    public List<Task> getAllTasks(){
        // Repository üzerinden tüm task'ları çeker
        return taskRepository.findAll();
    }

     // Yeni task oluşturan servis metodu
    public Task createTask(Task task){
        // Repository üzerinden task'ı kaydeder ve kaydedileni döner
        return taskRepository.save(task);
    }

    // Task güncelleyen servis metodu
    public Task updateTask(Long id, Task taskDetails){
        // Önce ilgili ID'ye sahip task'ı bulur
        // Bulamazsa RuntimeException fırlatır
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        // Yeni değerleri mevcut task'a atar
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setIsCompleted(taskDetails.getIsCompleted());

        // Güncellenmiş task'ı kaydedip döner
        return taskRepository.save(task);
    }

    // Task silen servis metodu
    public void deleteTask(Long id){
        // Verilen ID'ye göre task'ı siler
        taskRepository.deleteById(id);
    }


}
