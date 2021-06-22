package models;

import java.util.Objects;

public class Student {
    public int id;
    public String name;
    public int email;
    public int admissionNumber;
    public String units;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && email == student.email && admissionNumber == student.admissionNumber && Objects.equals(name, student.name) && Objects.equals(units, student.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, admissionNumber, units);
    }


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


}
