import org.sql2o.*;

import java.util.List;

public class Hostels{
    private String username;
    private String firstName;
    private String password;
    private String email;
    private int id;

    public Sighting(String username, String firstName, String password, String email, int id) {
        this.username = username;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
           String sql = "INSERT INTO hostels (username, first_name, hostel_id,password,email) VALUES (:username, :first_name, :hostel_id, password,email,now())";
           this.id = (int) con.createQuery(sql, true)
           .addParameter("username", this.username)
           .addParameter("first_name", this.first_name)
           .addParameter("hostel_id", this.hostel_id)
           .addParameter("password", this.password)
           .addParameter("email", this.email)
           .executeUpdate()
           .getKey();
        }
     }
     
     public static List<Sighting> all() {
        String sql = "select * from hostels";
        try(Connection con = DB.sql2o.open()) {
           return con.createQuery(sql)
           .executeAndFetch(Hostels.class);
        }
     }


}