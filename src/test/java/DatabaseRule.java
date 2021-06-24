import org.junit.rules.ExternalResource;
import org.sql2o.*;


public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:4567/school_system", "moringa", "password");
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteStudentQuery = "DELETE FROM student *;";
      String deleteUserQuery = "DELETE FROM users *;";
      String deleteHostelsQuery = "DELETE FROM hostel *;";
      con.createQuery(deleteAnimalQuery).executeUpdate();
      con.createQuery(deleteSightingsQuery).executeUpdate();
    }
  }

}