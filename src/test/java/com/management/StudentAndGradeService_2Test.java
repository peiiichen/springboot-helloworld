package com.management;

import com.management.service.StudentAndGradeService;
import com.management.repository.StudentDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@TestPropertySource("/application.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class StudentAndGradeService_2Test {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Mock
    private StudentAndGradeService studentCreateServiceMock;

    @Autowired
    private MockMvc mockMvc;



    @BeforeEach
    public void setupDatabase() {
        jdbc.execute("insert into student(firstName, lastName, email_address) " +
                "values ('Eric', 'Roby', 'eric.roby@luv2code_school.com')");}



    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("DELETE FROM student");
        jdbc.execute("ALTER TABLE student ALTER COLUMN ID RESTART WITH 1");
    }
}
