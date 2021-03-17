package pl.artimerek.shop.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEMail = studentRepository
                .findStudentByEmail(student.getEmail());

        if(studentByEMail.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
         boolean exits = studentRepository.existsById(studentId);
         if(!exits){
             throw new IllegalStateException("student with id" + studentId + " doesn't exists");
         }
         studentRepository.deleteById(studentId);
    }


}
