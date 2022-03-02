package kyc.dao;

import java.util.List;

import kyc.model.Customer;
import kyc.model.Users;


public interface CustomerDAO {
    
    public int create(Customer customer);

	public List<Customer> read();

	public List<Customer> findCustomerById(int customerid);

	public int update(Customer customer);
	
	public int updatekyc(Customer customer);
	
	public List<Users> checkUser(String username, String password);

}