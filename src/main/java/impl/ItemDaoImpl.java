package impl;

import daointerface.ItemDAO;
import model.Item;
import utility.ConnectionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends ConnectionDAO implements ItemDAO {

    @Override
    public List<Item> getAllItems() {
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item");

            List<Item> itemlist = new ArrayList<Item>();

            while (rs.next()) {
                Item itm = new Item();
                itm.setId(rs.getInt("id"));
                itm.setName(rs.getString("Name"));
                itm.setPrice(rs.getDouble("Price"));
                itemlist.add(itm);
            }
            return itemlist;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public void addItem(List<Item> i) {
        try {
            Connection connection = getConnection();
            for (Item itm1 : i) {
                String sqlQuery = "INSERT INTO item(name, price) VALUES (?,?)";
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setString(1,itm1.getName());
                ps.setDouble(2, itm1.getPrice());

                int affectedRows = ps.executeUpdate();
                System.out.println(affectedRows + " row(s) affected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeItemById(int id) {
        try{
            Connection connection = getConnection();
            String sqlQuery = "DELETE FROM Item WHERE id=?";
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
