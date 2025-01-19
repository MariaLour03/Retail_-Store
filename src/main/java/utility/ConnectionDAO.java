package utility;

import java.sql.*;

    public class ConnectionDAO {

        // Initialize
        public static Connection connection = null;
        protected PreparedStatement ps = null;
        protected ResultSet rs = null;

        public static Connection getConnection(){

            final String dburl = "jdbc:mysql://localhost:3306/retailstore";
            final String user = "root";
            final String password = "password";

            try{
                connection = DriverManager.getConnection(dburl, user, password);
                System.out.println("Connected to Database Successfully");
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();

            }
            return connection;
        }

        public void disconnect(){
            try {
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(connection != null){
                    connection.close();
                }

            }catch (Exception e) {
            }

        }

    }
