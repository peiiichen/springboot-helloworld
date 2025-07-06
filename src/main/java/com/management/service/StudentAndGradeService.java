package com.management.service;

import com.management.models.CollegeStudent;
import com.management.repository.StudentDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class StudentAndGradeService{

    @Autowired
    private StudentDao studentDao;

    public void createStudent(String firstname, String lastname, String emailAddress) {

        CollegeStudent student = new CollegeStudent(firstname, lastname, emailAddress);
        student.setId(0);
        studentDao.save(student);
    }

    public boolean checkIfStudentNull(int id) {
        CollegeStudent student = studentDao.findById(id).orElse(null);
        if (student == null) {
            System.out.println("Student with ID " + id + " does not exist.");
            return false;
        }
        else {
            System.out.println("Student with ID " + id + " exists: " + student.getFullName());
            return true;
        }

    }

    public void deleteStudent(int id){
        CollegeStudent student = studentDao.findById(id).orElse(null);
        if (student != null) {
            studentDao.delete(student);
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("Student with ID " + id + " does not exist, cannot delete.");
        }

    }

    public Iterable<CollegeStudent> getGradebook() {
        Iterable<CollegeStudent> collegeStudents = studentDao.findAll();
//       findAll方法是由CrudRepository接口提供的，它返回一个包含所有CollegeStudent对象的可迭代集合。
        if (collegeStudents == null) {
            System.out.println("No students found in the gradebook.");
        } else {
            System.out.println("Gradebook retrieved successfully.");
        }
        return collegeStudents;

    }
}
