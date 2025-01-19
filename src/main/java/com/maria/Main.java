package com.maria;

import service.CustomerService;
import service.ItemService;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        customerService.add();
        customerService.delete();
        customerService.getCustomer();

        ItemService itemService = new ItemService();
        itemService.addItem();
        itemService.getAll_Items();
        itemService.deleteItem();
    }
}