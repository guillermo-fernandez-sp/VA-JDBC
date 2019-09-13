
import java.sql.*;

public class Main {
        public static void main(String[] args) throws Exception {

            String  ip = args[0];
            String  port = args[1];
            String  user = args[2];
            String  pass = args[3];

            String  sqlQuery = "SELECT * FROM PRISM.USERS";
            System.out.println("MySQL JDBC Connection Testing ...");

            try {
                Class.forName("com.mysql.jdbc.Driver");

            } catch (ClassNotFoundException e) {
                System.out.println("ERROR: Driver not found");
                e.printStackTrace();
                return;
            }

            System.out.println("MySQL JDBC Driver Registered!");
            Connection conn = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" +   port + "/ASS?autoReconnect=false&useSSL=false&allowMultiQueries=true",user, pass);
                
            } catch (SQLException e) {
                System.out.println("ERROR: Connection Failed!");
                e.printStackTrace();
                return;
            }

            if (conn != null) {
                System.out.println("SUCCESS: Connection to database established");
                System.out.println(sqlQuery);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sqlQuery);

                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("first");
                    String lastName = rs.getString("last");
                    String login = rs.getString("login");
                    Date lastLogin = rs.getDate("lastLogin");

                    System.out.format("id: %s, First Name: %s, Last Name: %s, Login: %s, Last Login: %s\n", id, firstName, lastName, login, lastLogin);
                }
                st.close();
                conn.close();
        }
    }
}
