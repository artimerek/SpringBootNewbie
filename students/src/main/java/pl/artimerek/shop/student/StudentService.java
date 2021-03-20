package pl.artimerek.shop.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {


        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with "+studentId + "does not exits"));

        if(name != null && name.length() > 0)
            student.setName(name);
        else
            throw new IllegalStateException("Given name is wrong");



        if(email!= null && email.length() > 0){
            Optional<Student> studentOptional =
                    studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Given email is wrong");
            }
        }
            student.setEmail(email);

    }
}
