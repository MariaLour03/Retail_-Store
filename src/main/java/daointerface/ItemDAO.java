package daointerface;

import model.Item;

import java.util.List;

public interface ItemDAO {

    // Returns a list of all item objects in the database.
    List<Item> getAllItems();

    // Adds an item with given information.
    void addItem(List<Item> i);

    // Removes an item with the given id.
    boolean removeItemById(int id);

}
