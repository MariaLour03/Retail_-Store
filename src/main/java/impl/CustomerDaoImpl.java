package impl;

import daointerface.CustomerDAO;
import model.Customer;
import utility.ConnectionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl extends ConnectionDAO implements CustomerDAO {

    @Override
    public Customer getCustomerById(int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            String sqlQuery = "SELECT * FROM customer WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            ps.setInt(1,id);
            boolean i = ps.execute();
            Customer c=null ;

            if (i==true) {
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    c=new Customer();
                    c.setId(rs.getInt("id"));
                    c.setEmail(rs.getString("email"));
                    c.setfName(rs.getString("fName"));
                    c.setlName(rs.getString("lName"));
                }
                return c;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public void addCustomer(List<Customer> c) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            for (Customer c1 : c) {
                String sqlQuery = "INSERT INTO customer(email, fName, lName) VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setString(1,c1.getEmail());
                ps.setString(2, c1.getfName());
                ps.setString(3, c1.getlName());

                int affectedRows = ps.executeUpdate();
                System.out.println(affectedRows + " row(s) affected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeCustomerById(int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            String sqlQuery = "DELETE FROM customer WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            ps.setInt(1,id);
            int i = ps.executeUpdate();
            if (i==1)
             return true;
        } catch (SQLException e) {
           System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }
}
