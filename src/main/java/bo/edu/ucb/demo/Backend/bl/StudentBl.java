package bo.edu.ucb.demo.Backend.bl;

import bo.edu.ucb.demo.Backend.HelloWorld;
import bo.edu.ucb.demo.Backend.dao.StudentRepository;
import bo.edu.ucb.demo.Backend.model.Contact;
import bo.edu.ucb.demo.Backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentBl {
    private StudentRepository studentRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    public String findAllStudents() {
//        Optional<Student> result = studentRepository.findById(studentId);
//        if (result.isPresent()) {
//            return result.get();
//        } else {
//            throw new RuntimeException("No existe un contacto para la llave primaria: " + studentId);
//        }
        List result = jdbcTemplate.query("SELECT * FROM student",
                new Object[]{}, (resultSet, i) -> {
                    Student student = new Student();
                    student.setContactId(resultSet.getInt(1));
                    student.setFullName(resultSet.getString(2));
                    return student;
                });
        return  result.toString();

    }

    public void deleteContact(Student student) {
        studentRepository.delete(student);
    }


}
