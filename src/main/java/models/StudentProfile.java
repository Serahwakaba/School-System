package models;


public class StudentProfile extends Students  implements Student{


    public StudentProfile (String name, int admissionNumber, String email, String units ){
        this.name = name;
        this.admissionNumber = admissionNumber;
        this.email = email;
        this.units = units;

    }


    @Override
    public void save() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void update(String name, int Id, int admissionNumber, String units, String email) {

    }

    @Override
    public void removeById() {

    }

    @Override
    public void removeAll() {

    }
}
