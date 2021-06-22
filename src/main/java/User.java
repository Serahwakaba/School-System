import org.sql2o.*;

import java.util.List;

public class User{
    private String name;
    private String location;
    private int noOfStudents;
    private int id;

    public Sighting(String name, String location, int noOfStudents, int id) {
        this.name = name;
        this.location = location;
        this.noOfStudents = noOfStudents;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}