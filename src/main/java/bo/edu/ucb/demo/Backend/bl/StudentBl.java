package bo.edu.ucb.demo.Backend.bl;

import bo.edu.ucb.demo.Backend.dao.StudentRepository;
import bo.edu.ucb.demo.Backend.model.Contact;
import bo.edu.ucb.demo.Backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentBl {
    private StudentRepository studentRepository;

    @Autowired
    public StudentBl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        Student result = studentRepository.save(student);
        return result;
    }

    public Student updateStudent(Student student) {
        Student result = studentRepository.save(student);
        return result;
    }

    public Student findStudentByPk(Integer studentId) {
        Optional<Student> result = studentRepository.findById(studentId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("No existe un contacto para la llave primaria: " + studentId);
        }
    }

    public void deleteContact(Student student) {
        studentRepository.delete(student);
    }


}
