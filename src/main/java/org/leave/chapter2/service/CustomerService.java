package org.leave.chapter2.service;

import org.leave.chapter2.helper.DatabaseHelper;
import org.leave.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CustomerService  {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList(){
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(long id){
        String sql = "select * from customer where id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
