// Spring Boot uygulamasının temel yapılandırma sınıfı
package com.example.todo;

// Gerekli Spring Boot importları
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Bu anotasyon bir Spring Boot uygulamasını tanımlar ve 3 temel özellik içerir:
// 1. @Configuration: Bu sınıfın bir yapılandırma sınıfı olduğunu belirtir
// 2. @EnableAutoConfiguration: Spring Boot otomatik yapılandırmayı aktif eder
// 3. @ComponentScan: com.example paketi altında bileşenleri tarar
@SpringBootApplication
public class TodoApplication {

	 // Uygulamanın başlangıç noktası (main metodu)
	public static void main(String[] args) {
		// Spring uygulamasını başlatır ve iki parametre alır:
        // 1. Primary configuration class (bu sınıf)
        // 2. Komut satırı argümanları
		SpringApplication.run(TodoApplication.class, args);
	}

}
