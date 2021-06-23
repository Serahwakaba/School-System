import org.sql2o.*;

import java.util.List;

public class Hostels {
    private String username;
    private String firstName;
    private String studentId;
    private String password;
    private String email;
    private int id;

    public Hostels(String username, String studentId, String firstName, String password, String email, int id) {
        this.username = username;
        this.firstName = firstName;
        this.password = password;
        this.studentId = studentId;

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
        try (Connection con = Database.sql2o.open()) {
            String sql = "INSERT INTO hostels (username, first_name, studentId,password,email) VALUES (:username, :first_name, :hostel_id, password,email,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("studentId", this.studentId)
                    .addParameter("username", this.username)
                    .addParameter("password", this.password)
                    .addParameter("email", this.email)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Hostels> all() {
        String sql = "select * from hostels";
        try (Connection con = Database.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Hostels.class);
        }
    }

    public static Hostels findById(int id) {
        try (Connection conn = Database.sql2o.open()) {
            String getById = "SELECT * FROM hostels WHERE id = :id";
            Hostels hostel = conn.createQuery(getById)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Hostels.class);
            return hostel;
        }
    }

    public void update(int hostelId, String name, String location) {
        try (Connection conn = Database.sql2o.open()) {
            String sql = "UPDATE hostels SET hostelid=:hostelId, location=:location,name=:name WHERE id=:id";
            conn.createQuery(sql)
                    .addParameter("hostelId", hostelId)
                    .addParameter("location", location)
                    .addParameter("name", name)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();

        }
    }


}