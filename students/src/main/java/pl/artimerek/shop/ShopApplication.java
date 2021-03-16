package pl.artimerek.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.artimerek.shop.student.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);

    }

    @GetMapping
    public List<Student> hello(){
        return List.of(
                new Student(1L,"Konrad","konrad@mail.com", LocalDate.of(1998, Month.APRIL,5),
                        21)
        );
    }

}
