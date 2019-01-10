package first.app;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentReponsitory extends MongoRepository<Student, String>{
    Student findByid(String id);
    List<Student> findByName(String name);
    List<Student> findByAge(int age);
    List<Student> findByAddress(int address);
    
    @Query("{name:'?0'}")
    List<Student> findCustomByName(String name);
}
