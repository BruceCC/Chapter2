package org.leave.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.leave.chapter2.model.Customer;
import org.leave.chapter2.service.CustomerService;

import java.util.List;

public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        //TODO 初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id );
        Assert.assertNotNull(customer);
    }
}
