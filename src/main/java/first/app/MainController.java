package first.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private StudentReponsitory studentReponsitory;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Student add(@RequestBody Student student) {

        return studentReponsitory.insert(student);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Student update(@RequestBody Student student) {
        if(studentReponsitory.findById(student.getId()).get() != null){
            return studentReponsitory.save(student);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id) {
        studentReponsitory.deleteById(id);
        return "delete id =" + id;
    }
    
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student add(@PathVariable String id) {
        return studentReponsitory.findByid(id);
    }

    @GetMapping("/student")
    public List<Student> allStudent() {
        return studentReponsitory.findAll();
    }
}
