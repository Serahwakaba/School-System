package models;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StudentProfileTest {

    @Test
    public void students_instantiatesCorrectly_true() throws Exception {
       StudentProfile testStudent = createStudent();
        assertEquals(true,testStudent instanceof StudentProfile);
    }

    @Test
    public void students_instantiatesWithName_String() throws Exception {
        StudentProfile testStudent = createStudent();
        assertEquals("Serah", testStudent.getName());
    }

    @Test
    public void students_instantiatesWithStudentId_int() throws Exception {
        StudentProfile testStudent = createStudent();
        assertEquals(1,testStudent.getId());
    }

    public StudentProfile createStudent()
    {
        return new StudentProfile("Serah",1,"saragathoni888@gmail.com","Software Development");
    }



}