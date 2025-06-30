package com.example.todo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

// Bu sınıfın bir JPA Entity olduğunu belirtir (Veritabanı tablosuyla eşleşecek)
@Entity

// Veritabanında "tasks" tablosuna map edileceğini belirtir
@Table(name = "tasks")
public class Task {

    // Primary key alanı
    @Id
    // ID'nin otomatik artan bir değer olacağını belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Null değer kabul etmeyen zorunlu alan
    @Column(nullable = false)
    private String title;

    // Veritabanında "description" sütunuyla eşleşecek
    @Column(name = "description") 
    private String description; 

    // Veritabanında snake_case formatında "is_completed" sütunuyla eşleşecek
    @Column(name = "is_completed") 
    // Boolean tipinde ve default değeri false
    private Boolean isCompleted = false; 

    // Oluşturulma zamanı (güncellenemez)
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    // Son güncelleme zamanı
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // JPA callback methods
    // Kayıt oluşturulurken otomatik tarih ataması yapar
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now(); // Oluşturma anında updatedAt de set ediliyor
    }

    // Kayıt güncellenirken otomatik tarih güncellemesi yapar
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // --- GETTER METODLARI ---
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCompleted() { // Boolean için standart getter ismi
        return isCompleted;
    }

    public LocalDateTime getCreatedAt() { // createdAt için getter eklendi
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() { // updatedAt için getter eklendi
        return updatedAt;
    }

    // --- SETTER METODLARI ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}