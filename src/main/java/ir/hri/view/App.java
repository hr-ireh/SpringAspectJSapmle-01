package ir.hri.view;

import ir.hri.business.CustomerBusiness;
import ir.hri.util.SpringUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CustomerBusiness customer = (CustomerBusiness) SpringUtil.getApplicationContext().getBean("CustomerBusiness");
        customer.addCustomer();
        customer.addCustomerReturnValue();

        try {
            customer.addCustomerThrowException();
        } catch (Exception e) {
            // TODO: 11/9/2016  ;
        }

        customer.addCustomerAround("Hamid");
    }
}
