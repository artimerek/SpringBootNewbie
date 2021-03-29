package pl.artimerek.shop.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Konrad = new Student("Konrad", "konrad@gmail.com", LocalDate.of(
                    1998, Month.APRIL, 5));
            Student Konon = new Student("Krzysztof", "konowicz@gmail.com", LocalDate.of(
                    1958, Month.DECEMBER, 2));

            studentRepository.saveAll(
                    List.of(Konrad, Konon));
        };


    }
}
