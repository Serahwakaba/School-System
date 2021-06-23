package models;

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





}
