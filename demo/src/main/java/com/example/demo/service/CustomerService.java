package com.example.demo.service;

import com.example.demo.customer.cust;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {
    private int customerIdCount=1;
    private List<cust>customerList = new CopyOnWriteArrayList<>();
    public cust addCustomer(cust custom){
        custom.setCustomerId(customerIdCount);
        customerList.add(custom);
        customerIdCount++;
        return custom;
    }
   public List<cust> getCustomers(){
        return customerList;
   }
   public cust getCustomer(int customerId){
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
   }
    public cust updateCustomer(int customerId, cust custom){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId()==customerId){
                        c.setCustomerFirstName(custom.getCustomerFirstName());
                        c.setCustomerLastName(custom.getCustomerLastName());
                        c.setCustomerEmail(custom.getCustomerEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }
    public void deleteCustomer(int customerId){
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId()==customerId){
                        customerList.remove(c);
                    }
                });

    }
}
