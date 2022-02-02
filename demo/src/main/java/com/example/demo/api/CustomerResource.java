package com.example.demo.api;

import com.example.demo.customer.cust;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer")
public class CustomerResource {
    @Autowired
    private CustomerService customerservice;
    @PostMapping
    public cust addCustomer(@RequestBody cust custom){
          return customerservice.addCustomer(custom);
    }
    @GetMapping
    public List<cust> getCustomers(){
        return customerservice.getCustomers();
    }
    @GetMapping(value="/{customerId}")
    public cust getCustomer(@PathVariable("customerId") int customerId){
        return customerservice.getCustomer(customerId);
    }
    @PutMapping(value="/{customerId}")
    public cust updateCustomer(@PathVariable("customerId") int customerId, @RequestBody cust customer){
         return customerservice.updateCustomer(customerId,customer);
    }
    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerservice.deleteCustomer(customerId);
    }
}
