package bo.edu.ucb.demo.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * http://localhost:8080/mi_ruta/
 *
 * http://localhost:8080/mi_ruta/dos
 * HOLA MUNDO
 * Esta clase no tiene HighCohesion, porque mezcla lógica de presetación API con Acceso a Datos.
 * Esta clase no tiene Loose Coupling. Por ende esta fuertemente acoplada.
 *
 */

@RestController
@RequestMapping("/mi_ruta")
public class HelloWorld {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "HOLA MUNDO";
    }

    @RequestMapping(value = "/dos", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloTwo() {
        return "DOS HOLA";
    }

//    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
//    public String findStudent() {
//        return findById(20).toString();
//    }
//
//    public Student findById(int studentId) {
//        List result = jdbcTemplate.query("SELECT * FROM student WHERE student_id = 10;",
//                new Object[]{}, (resultSet, i) -> {
//                    Student student = new Student();
//                    student.studentId =  resultSet.getInt(1);
//                    student.fullName =  resultSet.getString(2);
//                    return student;
//                });
//        return (Student) result.get(0);
//    }
//
//    private class Student {
//        public Integer studentId;
//        public String fullName;
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "studentId=" + studentId +
//                    ", fullName='" + fullName + '\'' +
//                    '}';
//        }
//    }
}
