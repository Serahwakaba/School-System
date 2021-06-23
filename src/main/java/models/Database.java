package models;

import org.sql2o.*;
import java.net.URI; 
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Database {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-35-169-188-58.compute-1.amazonaws.com:5432/d2gvrj136a2r78", "ynkxmmwxgxmsqu", "33fbd2b96bbdd6a58c359e703e7bace66e398327c5d445e5cc58c7023681afb2");
//
//    private static URI dbUri;
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/school_system", "moringa", "password");
//    static Logger logger = LoggerFactory.getLogger(Database.class);
//    static {
//
//        try {
//            if (System.getenv("DATABASE_URL") == null) {
//                dbUri = new URI("postgres://localhost:4567/school_system");
//            } else {
//                dbUri = new URI(System.getenv("DATABASE_URL"));
//            }
//            int port = dbUri.getPort();
//            String host = dbUri.getHost();
//            String path = dbUri.getPath();
////            String username = (dbUri.getUserInfo() == "moringa") ? "moringa" : dbUri.getUserInfo().split(":")[0];
////            String password = (dbUri.getUserInfo() == "password") ? "password" : dbUri.getUserInfo().split(":")[1];
////sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
//        } catch (URISyntaxException e ) {
//            logger.error("Unable to connect to database.");
//        }
//    }
}