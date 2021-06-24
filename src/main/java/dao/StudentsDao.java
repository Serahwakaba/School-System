package dao;

import models.Apartment;
import models.Students;

import java.util.List;

public interface StudentsDao {

    //    CREATE

    void saveTenant(Students students);

    //    READ
    List<Students> getAll();
    Students findById(int id);

    //    UPDATE
    void update(int id,String name, String phone, int roomNumber, int floor, int apartmentId);

    //    DESTROY
    void clearAll();
    void deleteById(int id);

}