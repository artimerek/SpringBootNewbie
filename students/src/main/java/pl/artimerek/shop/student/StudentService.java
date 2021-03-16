package pl.artimerek.shop.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1L,"Konrad","konrad@mail.com", LocalDate.of(1998, Month.APRIL,5),
                        21)
        );
    }
}
