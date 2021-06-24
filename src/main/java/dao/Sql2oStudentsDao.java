package dao;
import models.Students;
import org.sql2o.*;

import java.util.List;

public class Sql2oStudentsDao implements StudentsDao{
    private final Sql2o sql2o;

    public Sql2oStudentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void saveTenant(Students students) {
        String save ="INSERT INTO students (name, phone, roomnumber, floor, apartmentid) VALUES (:name, :phone, :roomNumber, :floor, :apartmentId)";
        try(Connection conn=sql2o.open()) {
            int id=(int) conn.createQuery(save,true)
                    .bind(students)
                    .executeUpdate()
                    .getKey();
            students.setId(id);
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }


    @Override
    public List<Students> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM students")
                    .executeAndFetch(Students.class);
        }
    }

    @Override
    public Students findById(int id) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM students WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Students.class);
        }
    }


    @Override
    public void update(int id,String name, String phone, int roomNumber, int floor, int apartmentId) {
        String update = "UPDATE students SET (name, phone, roomnumber, floor, apartmentid)=(:name, :phone, :roomNumber, :floor, :apartmentId) WHERE id =:id";
        try(Connection conn =sql2o.open()) {
            conn.createQuery(update)
                    .addParameter("name",name)
                    .addParameter("phone",phone)
                    .addParameter("roomNumber",roomNumber)
                    .addParameter("floor",floor)
                    .addParameter("apartmentId",apartmentId)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String removeAll="DELETE FROM students";
        try(Connection conn=sql2o.open()) {
            conn.createQuery(removeAll)
                    .executeUpdate();
        }catch (Sql2oException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from students WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}