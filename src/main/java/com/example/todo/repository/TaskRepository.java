// Task entity'si için repository interface'i
package com.example.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.Task;

// JpaRepository'den extend edilir (Spring Data JPA'nın temel repository interface'i)
// <Task, Long> generic parametreleri:
// - Task: Yönetilecek entity sınıfı
// - Long: Entity'nin primary key tipi
public interface TaskRepository extends JpaRepository<Task, Long>{

    // Tamamlanma durumuna göre task'ları filtreleyen metod
    // Spring Data JPA'nın query derivation özelliği:
    // - "findBy": Sorgu başlangıcı
    // - "IsCompleted": Entity'deki alan adı (isCompleted)
    // Otomatik olarak: SELECT * FROM tasks WHERE is_completed = ? şeklinde SQL oluşturur
    List<Task> findByIsCompleted(Boolean isCompleted);

    // Başlıkta arama yapan metod (büyük/küçük harf duyarsız)
    // - "Containing": LIKE '%keyword%' sorgusu oluşturur
    // - "IgnoreCase": Büyük/küçük harf duyarsız arama yapar
    // Otomatik olarak: SELECT * FROM tasks WHERE LOWER(title) LIKE LOWER('%?%') şeklinde SQL oluşturur
    List<Task> findByTitleContainingIgnoreCase(String keyword);
}