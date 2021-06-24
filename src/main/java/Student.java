import org.sql2o.*;

import java.util.List;

public class Student{
    private String firstName;
    private String secondName;
    private String gmail;
    private String regNumber;
    private int id;
    private String course;
    private String units;

    public Animal(String firstName, String secondName, String gmail, String regNumber, int id, String course, String units) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gmail = gmail;
        this.regNumber = regNumber;
        this.id = id;
        this.course = course;
        this.units = units;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    


}

