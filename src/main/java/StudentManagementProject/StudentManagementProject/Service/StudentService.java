package StudentManagementProject.StudentManagementProject.Service;

import StudentManagementProject.StudentManagementProject.Repository.StudentRepository;
import StudentManagementProject.StudentManagementProject.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student savestudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getall() {
        return studentRepository.findAll();
    }

    public Student findStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student update(Long id, Student student) {
    Student existing=studentRepository.findById(id).orElse(null);
    if(existing!=null){
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setCourse(student.getCourse());
        return studentRepository.save(existing);
    }
    return null;
    }

    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }



}
