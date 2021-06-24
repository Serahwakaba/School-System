package models;

import models.Database;
import org.junit.rules.ExternalResource;
import org.sql2o.*;


public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    Database.sql2o = new Sql2o("jdbc:postgresql://localhost:4567/school_system", "moringa", "password");
  }

  @Override
  protected void after() {
    try(Connection con = Database.sql2o.open()) {
      String deleteStudentQuery = "DELETE FROM students *;";
      String deleteUserQuery = "DELETE FROM users *;";
      String deleteHostelsQuery = "DELETE FROM hostels *;";
      con.createQuery(deleteStudentQuery).executeUpdate();
      con.createQuery(deleteHostelsQuery).executeUpdate();
    }
  }

}