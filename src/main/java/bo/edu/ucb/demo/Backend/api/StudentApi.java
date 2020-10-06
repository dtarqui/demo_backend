package bo.edu.ucb.demo.Backend.api;

import bo.edu.ucb.demo.Backend.bl.StudentBl;
import bo.edu.ucb.demo.Backend.model.Contact;
import bo.edu.ucb.demo.Backend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentApi {
    private final StudentBl studentBl;

    @Autowired
    public StudentApi(StudentBl studentBl) {
        this.studentBl = studentBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student create(@RequestBody Student student) {
        return studentBl.createStudent(student);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String get() {
        return studentBl.findAllStudents();
    }

    //    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
//    public String findStudent() {
//        return studentBl.findStudentByPk(11).toString();
//    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String findStudent(@PathVariable String id) {
        return studentBl.findStudentByPk(Integer.parseInt(id)).toString();
    }

}
