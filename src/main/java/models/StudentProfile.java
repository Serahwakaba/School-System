package models;
import org.sql2o.*;

import java.util.List;

import java.sql.Connection;

public class StudentProfile extends Students  implements Student{


    public StudentProfile (String name, int admissionNumber, String email, String units ){
        this.name = name;
        this.admissionNumber = admissionNumber;
        this.email = email;
        this.units = units;

    }


    public void save() {
        try(Connection conn = Database.sql2o.open()) {
            String save="INSERT INTO animals (name,rangerid,age,health) VALUES (:name, :rangerId,:age,:health)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerId",this.rangerId)
                    .addParameter("age",this.age)
                    .addParameter("health",this.health)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }



    public static StudentProfile findById(int id) {
            try(Connection conn = Database.sql2o.open()) {
                String sql = "SELECT * FROM students where id=:id";
                StudentProfile student = conn.createQuery(sql)
                        .addParameter("id", id)
                        .throwOnMappingFailure(false)
                        .executeAndFetchFirst(StudentProfile.class);
                return student;
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

            String updateNewBorn = "UPDATE animals SET name=:name, rangerid=:rangerId,age=:age, health=:health WHERE id = :id";
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



    @Override
    public void removeById() {

    }

    @Override
    public void removeAll() {

    }
}
