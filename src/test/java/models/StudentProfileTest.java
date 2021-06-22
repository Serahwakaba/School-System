package models;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StudentProfileTest {

    @Test
    public void students_instantiatesCorrectly_true() throws Exception {
       StudentProfile testStudent = createStudent();
        assertEquals(true,testStudent instanceof StudentProfile);
    }

    public StudentProfile createStudent()
    {
        return new StudentProfile("Serah",1,"saragathoni888@gmail.com","Software Development");
    }



}