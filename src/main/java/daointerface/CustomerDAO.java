package daointerface;

import model.Customer;

import java.util.List;

public interface CustomerDAO {

    // Returns the customer object for the given id.
    Customer getCustomerById(int id);

    // Adds a customer with given information.
    void addCustomer(List<Customer> c);

    // Removes a customer with the given id.
    boolean removeCustomerById(int id);

}
