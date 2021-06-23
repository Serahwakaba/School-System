package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Hostels {
    private int id;
    public int studentId;
    public String location;
    public String name;
    public String numberOfStudents;

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfStudents() {
        return numberOfStudents;
    }

    public Hostels(int id, int studentId, String location, String name, String numberOfStudents) {
        this.id = id;
        this.studentId = studentId;
        this.location = location;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hostels hostels = (Hostels) o;
        return id == hostels.id && studentId == hostels.studentId && Objects.equals(location, hostels.location) && Objects.equals(name, hostels.name) && Objects.equals(numberOfStudents, hostels.numberOfStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, location, name, numberOfStudents);
    }

    public void save() {
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO hostels (name, numberOfStudents, studentId,password) VALUES (:username, :first_name, :hostel_id, password,email,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("studentId", this.studentId)
                    .addParameter("numberOfStudents", this.numberOfStudents)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Hostels> all() {
        String sql = "select * from hostels";
        try (Connection con = Database.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Hostels.class);
        }
    }

    public static Hostels findById(int id) {
        try (Connection conn = Database.sql2o.open()) {
            String getById = "SELECT * FROM hostels WHERE id = :id";
            Hostels hostel = conn.createQuery(getById)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Hostels.class);
            return hostel;
        }
    }

    public void update(int hostelId, String name, String location) {
        try (Connection conn = Database.sql2o.open()) {
            String sql = "UPDATE hostels SET hostelid=:hostelId, location=:location,name=:name WHERE id=:id";
            conn.createQuery(sql)
                    .addParameter("hostelId", hostelId)
                    .addParameter("location", location)
                    .addParameter("name", name)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();

        }
    }
    public void removeById()
    {
        try(Connection conn=Database.sql2o.open()) {
            String remove="DELETE FROM hostels WHERE id = :id";
            conn.createQuery(remove)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

    public void removeAll()
    {
        try(Connection conn=Database.sql2o.open()) {
            String remove="DELETE FROM hostels";
            conn.createQuery(remove)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }



}
