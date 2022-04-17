package com.springboot.jpamapping.Controller;


import com.springboot.jpamapping.model.Student;
import com.springboot.jpamapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studentDetails")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        Integer id=studentService.saveStudent(student);
        return new ResponseEntity<String>("Student with 'id' " +id+ " has been saved", HttpStatus.OK);
    }
    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> getAllStudentDetail(){
        List<Student> list=studentService.getAllStudents();
        return  new ResponseEntity<List<Student>>(list , HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public  ResponseEntity<Student> getStudentByID(@PathVariable Integer id){

        Student sid= studentService.getStudentById(id);
        return new ResponseEntity<Student>(sid,HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer id , @RequestBody Student student){
        Student studentFromDb = studentService.getStudentById(id);
        studentFromDb.setName(student.getName());
        studentFromDb.setSchoolName(student.getSchoolName());
        studentFromDb.setStudentClass(student.getStudentClass());
        Integer sid=studentService.saveStudent(studentFromDb);

        return new ResponseEntity<String>("Student with 'id' "+id+" has been updated",HttpStatus.OK);

    }

    @DeleteMapping("deleteStudent/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student with 'id'"+id+" has been deleted",HttpStatus.OK);
    }

}
