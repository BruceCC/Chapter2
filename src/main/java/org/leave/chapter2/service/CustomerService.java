package org.leave.chapter2.service;

import org.leave.chapter2.helper.DatabaseHelper;
import org.leave.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CustomerService  {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList(){
        Connection conn = DatabaseHelper.getConnection();
        try{
            String sql = "select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class, conn, sql);
        }  finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    public Customer getCustomer(long id){
        //TODO
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        //TODO
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        //TODO
        return false;
    }

    public boolean deleteCustomer(long id){
        //TODO
        return false;
    }
}
