package models;
import org.sql2o.*;

import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;

public  class StudentProfile extends Students  implements Student{


    public StudentProfile (String name, int admissionNumber, String email, String units ){
        this.name = name;
        this.admissionNumber = admissionNumber;
        this.email = email;
        this.units = units;

    }


    public void save() {
        try(Connection conn = (Connection) Database.sql2o.open()) {
            String save="INSERT INTO animals (name,id,admissionNumber,email) VALUES (:name, :id,:admissionNumber,:email)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("name", this.name)
                    .addParameter("id",this.id)
                    .addParameter("admissionNumber",this.admissionNumber)
                    .addParameter("email",this.email)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void findById() {

    }


    public static StudentProfile findById(int id) {
        try (Connection conn = (Connection) Database.sql2o.open()) {
            String sql = "SELECT * FROM students where id=:id";
            StudentProfile student = conn.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(StudentProfile.class);
            return student;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @Override
    public boolean equals(Object otherStudent){
        if (!(otherStudent instanceof StudentProfile)) {
            return false;
        } else {
            StudentProfile newAnimal = (StudentProfile) otherStudent;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getId() == newAnimal.getId();
        }
    }

    public static List<StudentProfile> getAll() {
        String getAll="SELECT * FROM students";
        try(Connection conn = Database.sql2o.open())
        {
            return conn.createQuery(getAll)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(StudentProfile.class);
        }
    }

    @Override
    public void update(String name, int Id, int admissionNumber, String units, String email) {
        try(Connection conn=Database.sql2o.open())
        {

            String updateNewBorn = "UPDATE animals SET name=:name, id=:Id,admissionNumber=:admissionNumber, email=:email WHERE id = :id";
            conn.createQuery(updateNewBorn)
                    .addParameter("name", name)
                    .addParameter("Id",Id)
                    .addParameter("email", email)
                    .addParameter("admissionNumber", admissionNumber)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }



    public void removeById() {
        try(Connection conn=Database.sql2o.open())
        {
            String remove = "DELETE FROM students WHERE id = :id";
            conn.createQuery(remove)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }


    public void removeAll() {
        try(Connection conn=Database.sql2o.open())
        {
            String remove = "DELETE FROM students";
            conn.createQuery(remove)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
}
