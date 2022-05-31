package com.maiyeuem.hellospring.controller;

import com.maiyeuem.hellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/api/v1/students | GET | return list student
 * http://localhost:8080/api/v1/students | POST | create new student
 * http://localhost:8080/api/v1/students | DELETE | remove student
 * http://localhost:8080/api/v1/students/1 | GET | find student by id
 * http://localhost:8080/api/v1/students | PUT | update student
 */
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private static List<Student> list;

    public StudentController() {
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A01").fullName("Ngo Dat").build());
        list.add(Student.builder().rollNumber("A02").fullName("Ngo Thanh").build());
        list.add(Student.builder().rollNumber("A03").fullName("Ngo Tuan").build());
        list.add(Student.builder().rollNumber("A04").fullName("Ngo Tam").build());
        list.add(Student.builder().rollNumber("A05").fullName("Ngo Chi").build());
    }

    //GET-list students
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return list;
    }
    //GET-list students by id
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex) ;
    }
    //POST- students
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return student;
    }
    //DELETE- students
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public  boolean deleteById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }
    //UPDATE students by id
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@RequestBody Student updateStudent,@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        Student existing  = list.get(foundIndex);
        existing.setFullName(updateStudent.getFullName());
        return existing;
    }
}
