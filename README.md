# 📝 To-Do List Application

Modern ve kullanıcı dostu bir to-do list uygulaması. Spring Boot ile geliştirilmiş RESTful API backend'i.

## 🚀 Özellikler

- ✅ **CRUD İşlemleri**: Task oluşturma, okuma, güncelleme ve silme
- 🗄️ **PostgreSQL Veritabanı**: Güvenilir veri saklama
- 🔒 **Güvenli Konfigürasyon**: .env dosyası ile hassas bilgilerin korunması
- 📊 **JPA/Hibernate**: Otomatik veritabanı şema yönetimi
- 🕒 **Otomatik Tarih Yönetimi**: Oluşturma ve güncelleme tarihlerinin otomatik kaydı
- 🎯 **RESTful API**: Standart HTTP metodları ile API

## 🛠️ Teknolojiler

- **Backend**: Spring Boot 3.5.3
- **Veritabanı**: PostgreSQL
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven
- **Java Version**: 17
- **Konfigürasyon**: .env dosyası desteği

## 📁 Proje Yapısı

```
src/
├── main/
│   ├── java/com/example/todo/
│   │   ├── controller/
│   │   │   └── TaskController.java      # REST API endpoints
│   │   ├── model/
│   │   │   └── Task.java               # JPA Entity
│   │   ├── repository/
│   │   │   └── TaskRepository.java     # Data Access Layer
│   │   ├── service/
│   │   │   └── TaskService.java        # Business Logic
│   │   └── TodoApplication.java        # Main Application
│   └── resources/
│       └── application.properties      # Spring Boot config
├── test/
└── .env                                # Environment variables
```

## 🚀 Kurulum

### Gereksinimler

- Java 17 veya üzeri
- Maven 3.6+
- PostgreSQL 12+

### 1. Projeyi Klonlayın

```bash
git clone <repository-url>
cd to-do
```

### 2. Veritabanını Hazırlayın

PostgreSQL'de yeni bir veritabanı oluşturun:

```sql
CREATE DATABASE todo_db;
```

### 3. Environment Variables

Proje kök dizininde `.env` dosyası oluşturun:

```env
# Database Configuration
DB_HOST=localhost
DB_PORT=5432
DB_NAME=todo_db
DB_USERNAME=postgres
DB_PASSWORD=your_password

# JPA Configuration
JPA_DDL_AUTO=update
JPA_SHOW_SQL=true
JPA_FORMAT_SQL=true

# Server Configuration
SERVER_PORT=8080
```

### 4. Uygulamayı Çalıştırın

```bash
# Maven wrapper ile
./mvnw spring-boot:run

# Veya Maven ile
mvn spring-boot:run
```

Uygulama `http://localhost:8080` adresinde çalışacaktır.

## 📡 API Endpoints

### Base URL: `http://localhost:8080/api/tasks`

| Method | Endpoint | Açıklama |
|--------|----------|----------|
| `GET` | `/api/tasks` | Tüm task'ları listeler |
| `POST` | `/api/tasks` | Yeni task oluşturur |
| `PUT` | `/api/tasks/{id}` | Task günceller |
| `DELETE` | `/api/tasks/{id}` | Task siler |

### Request/Response Örnekleri

#### Task Oluşturma (POST)

```json
POST /api/tasks
Content-Type: application/json

{
    "title": "Alışveriş yap",
    "description": "Süt, ekmek ve yumurta al"
}
```

#### Response

```json
{
    "id": 1,
    "title": "Alışveriş yap",
    "description": "Süt, ekmek ve yumurta al",
    "isCompleted": false,
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
}
```

#### Task Güncelleme (PUT)

```json
PUT /api/tasks/1
Content-Type: application/json

{
    "title": "Alışveriş yap",
    "description": "Süt, ekmek ve yumurta al",
    "isCompleted": true
}
```

## 🗄️ Veritabanı Şeması

### Tasks Tablosu

| Sütun | Tip | Açıklama |
|-------|-----|----------|
| `id` | BIGINT | Primary Key, Auto Increment |
| `title` | VARCHAR | Task başlığı (NOT NULL) |
| `description` | TEXT | Task açıklaması |
| `is_completed` | BOOLEAN | Tamamlanma durumu (default: false) |
| `created_at` | TIMESTAMP | Oluşturulma tarihi |
| `updated_at` | TIMESTAMP | Son güncelleme tarihi |

## 🔧 Konfigürasyon

### application.properties

```properties
# PostgreSQL bağlantısı - .env dosyasından alınan değerler
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA ayarları
spring.jpa.hibernate.ddl-auto=${JPA_DDL_AUTO}
spring.jpa.show-sql=${JPA_SHOW_SQL}
spring.jpa.properties.hibernate.format_sql=${JPA_FORMAT_SQL}

# Server port
server.port=${SERVER_PORT}
```

## 🧪 Test

### API Test Örnekleri

#### cURL ile Test

```bash
# Tüm task'ları listele
curl -X GET http://localhost:8080/api/tasks

# Yeni task oluştur
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Test Task","description":"Test Description"}'

# Task güncelle
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Task","isCompleted":true}'

# Task sil
curl -X DELETE http://localhost:8080/api/tasks/1
```


## 🔒 Güvenlik

- `.env` dosyası `.gitignore`'da yer alır
- Hassas bilgiler (şifreler, API key'ler) environment variables olarak saklanır
- Production ortamında güvenli veritabanı bağlantısı kullanın


## 🤝 Katkıda Bulunma

1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Commit yapın (`git commit -m 'Add amazing feature'`)
4. Push yapın (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

## 📞 İletişim

Proje hakkında sorularınız için issue açabilirsiniz.

---

**Not**: Bu README dosyası projenin mevcut durumunu yansıtmaktadır ve geliştirme sürecinde güncellenebilir. # spring-boot-todo-api
