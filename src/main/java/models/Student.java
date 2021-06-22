package models;

public interface Student {
    //    CREATE Student
    void save();

 //READ   Student
     void findById();
      void getAll();

    //UPDATE Student
    void update(String name, int Id, int admissionNumber, String units, String email);


    //DESTROY Student
    void  removeById();
    void removeAll();
}
