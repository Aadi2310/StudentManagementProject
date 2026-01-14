package StudentManagementProject.StudentManagementProject.controller;


import StudentManagementProject.StudentManagementProject.Service.StudentService;
import StudentManagementProject.StudentManagementProject.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.savestudent(student);
    }
    //READ
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getall();
    }
    //Update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return "Student deleted Successfully";
    }

}
