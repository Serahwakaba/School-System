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
    @Test
    public void equals_returnsTrueIfNameAndStudentIddAreSame_true() {
        StudentProfile testStudent = createStudent();
        StudentProfile AnotherStudent = createStudent();
        assertTrue(testStudent.equals(anotherStudent));
    }
    @Test
    public void save_savesStudentToTheDatabase() throws Exception {
        StudentProfile testStudent = createStudent();
        testStudent.save();
        assertTrue(StudentProfile.getAll().get(0).equals(testStudent));
    }

    @Test
    public void save_assignsIdToStudent() {
        StudentProfile testStudent = createStudent();
        testStudent.save();
        StudentProfile savedStudent = StudentProfile.getAll().get(0);
        assertEquals(savedStudent.getId(), testStudent.getId());
    }

    @Test
    public void getAll_returnsAllInstancesOfStudent() {
        StudentProfile testStudent = createStudent();
        firstStudent.save();
        StudentProfile secondStudent = createSecondStudent();
        secondStudent.save();
        assertEquals(true,StudentProfile.getAll().get(0).equals(firstStudent));
        assertEquals(true,StudentProfile.getAll().get(1).equals(secondStudent));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        StudentProfile firstStudent = createStudent();
        firstStudent.save();
        StudentProfile secondAnimal = createSecondStudent();
        secondAnimal.save();
        assertEquals( StudentProfile.findById(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void update_updatesAnimalDetails() throws Exception {
        StudentProfile testStudent=createStudent();
        testStudent.save();

        testStudent.update("Buyahi",2,"4456","mobile dev");
        StudentProfile updatedAnimal=StudentProfile.findById(testStudent.getId());
        assertEquals(testStudent.getId(),updatedAnimal.getId());
        assertNotEquals(testStudent.getName(),updatedAnimal.getName());
        assertNotEquals(testStudent.getId(),updatedAnimal.getId());
        assertNotEquals(testStudent.getAdmissionNumber(),updatedAnimal.getAdmissionNumber());
        assertNotEquals(testStudent.getEmail(),updatedAnimal.getEmail());
    }

    @Test
    public void removeById_removesAnimalById() {
        StudentProfile testAnimals = createStudent();
        testAnimals.save();

        testAnimals.removeById();
        assertEquals(null,StudentProfile.findById(testAnimals.getId()));
    }

    @Test
    public void removeAll_clearsAnimalDatabase() {
        StudentProfile testAnimal = createStudent();
        testAnimal.save();
        testAnimal.removeAll();
        assertEquals(null,  StudentProfile.findById(testAnimal.getId()));
    }


    public StudentProfile createStudent() { return new StudentProfile("Serah",1,"saragathoni888@gmail.com","Software Development");
    }
    public StudentProfile createSecondStudent()
    {
        return new StudentProfile("Buyahi",2,"buyahi@gmail.com","mobile dev");
    }



}