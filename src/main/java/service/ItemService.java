package service;

import daointerface.ItemDAO;
import impl.ItemDaoImpl;
import model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemService {
    private final ItemDAO itemDAO;

    // Constructor
    public ItemService() {
        this.itemDAO = new ItemDaoImpl();
    }
    // Get All the items from database
    public void getAll_Items() {
        List<Item> item = itemDAO.getAllItems();
        System.out.println("All Items\n");

        for (Item i : item) {
            System.out.println("Item Name: " + i.getName() + " | " + "Item Price: " + i.getPrice());
        }
    }

    // Add Items to the database
    public void addItem(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Item> itemList = new ArrayList<Item>();

        System.out.println("Enter the number of Items to add: ");
        int numberOfItems = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfItems; i++) {
            Item item = new Item();

            System.out.println("Enter the Name of Item " + (i + 1) + ":");
            item.setName(scanner.nextLine());

            System.out.println("Enter the Price of Item " + (i + 1) + ":");
            item.setPrice(scanner.nextDouble());
            scanner.nextLine();

            itemList.add(item);
        }
        itemDAO.addItem(itemList);
        System.out.println("Item(s) added successfully!");
    }

    // Delete Item by Id
    public void deleteItem(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the id of the Item you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        itemDAO.removeItemById(id);
        System.out.println("Item Id : " + id + " deleted successfully!");
    }
}
