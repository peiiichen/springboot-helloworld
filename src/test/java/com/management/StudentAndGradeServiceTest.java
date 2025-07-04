package com.management;

import com.management.Service.StudentAndGradeService;
import com.management.models.CollegeStudent;
import com.management.repository.StudentDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @BeforeEach
    public void setupDatabase() {
        jdbc.execute("insert into student(firstName, lastName, email_address) " +
                "values ('Eric', 'Roby', 'eric.roby@luv2code_school.com')");}

    @Test
    public void createStudentService() {
        studentService.createStudent("Chad","Darby","ttt@111.com");

        CollegeStudent student = studentDao.findByEmailAddress("ttt@111.com");

        assertEquals("ttt@111.com", student.getEmailAddress(),"find by Email");

    }


    @Test
    public void isStudentNullCheck() {
        assertTrue(studentService.checkIfStudentNull(1));
    }

    @Test
    public void deleteStudentService() {
        studentService.createStudent("Chad", "Darby", "chad.darby@luv2code_school.com");
        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@luv2code_school.com");
        assertNotNull(student, "Student should not be null before deletion");

        studentService.deleteStudent(student.getId());
        assertFalse(studentService.checkIfStudentNull(student.getId()), "Student should be deleted");
    }

    @Test
    public void getGradebookService() {
        Iterable<CollegeStudent> iterableCollegeStudents = studentService.getGradebook();
        List<CollegeStudent> collegeStudents = new ArrayList<>();

        for (CollegeStudent collegeStudent : iterableCollegeStudents) {
            collegeStudents.add(collegeStudent);
        }assertEquals(1,collegeStudents.size());

    }


    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("DELETE FROM student");
        jdbc.execute("ALTER TABLE student ALTER COLUMN ID RESTART WITH 1");
    }
}
