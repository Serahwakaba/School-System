package models;

import java.util.Objects;

public abstract class Students {
    public int id;
    public String name;
    public int admissionNumber;
    public String units;
    public String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(int admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && email == students.email && admissionNumber == students.admissionNumber && Objects.equals(name, students.name) && Objects.equals(units, students.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, admissionNumber, units);
    }


}
