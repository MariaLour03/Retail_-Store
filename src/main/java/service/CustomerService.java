package service;

import daointerface.CustomerDAO;
import impl.CustomerDaoImpl;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

    private final CustomerDAO customerDAO;

    // Constructor
    public CustomerService() {
        this.customerDAO = new CustomerDaoImpl();
    }

    // Get Customer by Id
    public Customer getCustomer(){
        Scanner scanner = new Scanner(System.in);

        Customer customer ;

        System.out.println("Enter the id of the Customer you want to get: ");
        int id = Integer.parseInt(scanner.nextLine());

        customer = customerDAO.getCustomerById(id);
        if(customer == null){
            System.out.println("Customer not found!");
        }
        else {
            System.out.println("Customer Email: " + customer.getEmail());
            System.out.println("Customer First Name: " + customer.getfName());
            System.out.println("Customer Last Name: " + customer.getlName());
        }
        return customer;
    }

    // Add Customers to the database
    public void add(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Customer> customerList = new ArrayList<Customer>();

        System.out.println("Enter the number of Customers to add: ");
        int numberOfRecords = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRecords; i++) {
            Customer customer = new Customer();

            System.out.println("Enter the Email address of Customer " + (i + 1) + ":");
            customer.setEmail(scanner.nextLine());

            System.out.println("Enter the First Name of Customer " + (i + 1) + ":");
            customer.setfName(scanner.nextLine());

            System.out.println("Enter the Last Name of Customer " + (i + 1) + ":");
            customer.setlName(scanner.nextLine());

            customerList.add(customer);
        }
        customerDAO.addCustomer(customerList);
        System.out.println("Customer(s) added successfully!");
    }

    // Delete Customer by Id
     public void delete(){
        Scanner scanner = new Scanner(System.in);

         System.out.println("Enter the id of the Customer you want to delete: ");
         int id = Integer.parseInt(scanner.nextLine());

         customerDAO.removeCustomerById(id);
         System.out.println("Customer Id : " + id + " deleted successfully!");
     }
}
