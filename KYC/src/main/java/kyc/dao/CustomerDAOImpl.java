package kyc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import kyc.dao.CustomerDAO;
import kyc.model.Customer;
import kyc.model.Users;

public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;

	public CustomerDAOImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	@Override
	public int create(Customer customer) {
		
		 String sql = "INSERT INTO customer (firstname,lastname,gender,dob,address,city,state,country,postalcode,identificationtype,identificationnumber,occupationtype,designation,salary,kycstatus) "
                 + " VALUES (?, ?, ?,?,?,?,?,?,?,'null',0,'null','null',0,'yellow')";

			try {

				int counter = jdbcTemplate.update(sql,
						new Object[] { customer.getFirstname(),
			                    customer.getLastname(), customer.getGender(), customer.getDob(), 
			                    customer.getAddress(), customer.getCity(), customer.getState(), 
			                    customer.getCountry(), customer.getPostalcode() });

				return counter;

			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}

	@Override
	public List<Customer> read() {
		List<Customer> customerList = jdbcTemplate.query("SELECT * FROM customer", new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
                customer.setCustomerid(rs.getInt("customerid"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setGender(rs.getString("gender"));
                customer.setDob(rs.getString("dob"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setCountry(rs.getString("country"));
                customer.setPostalcode(rs.getInt("postalcode"));
                customer.setKycstatus(rs.getString("kycstatus"));

				return customer;
			}

		});

		return customerList;
	}

	@Override
	public List<Customer> findCustomerById(int customerid) {
		
		
		List<Customer> customerList = jdbcTemplate.query("SELECT * FROM customer WHERE customerid=?",
				new Object[] { customerid }, new RowMapper<Customer>() {

					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Customer customer = new Customer();

						customer.setCustomerid(rs.getInt("customerid"));
		                customer.setFirstname(rs.getString("firstname"));
		                customer.setLastname(rs.getString("lastname"));
		                customer.setGender(rs.getString("gender"));
		                customer.setDob(rs.getString("dob"));
		                customer.setAddress(rs.getString("address"));
		                customer.setCity(rs.getString("city"));
		                customer.setState(rs.getString("state"));
		                customer.setCountry(rs.getString("country"));
		                customer.setPostalcode(rs.getInt("postalcode"));
		                customer.setKycstatus(rs.getString("kycstatus"));

						return customer;
					}

				});

		return customerList;
	}

	@Override
	public int update(Customer customer) {
		String sql = "UPDATE customer SET firstname=?,lastname=?,gender=?,dob=?,address=?,city=?,state=?,country=?,postalcode=? WHERE customerid=?";
		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { customer.getFirstname(),
		                    customer.getLastname(), customer.getGender(), customer.getDob(), 
		                    customer.getAddress(), customer.getCity(), customer.getState(), 
		                    customer.getCountry(), customer.getPostalcode(), customer.getCustomerid() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Users> checkUser(String username, String password) {
		Users users = new Users();
        String sql = "select username, password from users where username='" +username + "' and password = '"+password+"'";
        List user = jdbcTemplate.queryForList(sql);
       return user;
	}

	@Override
	public int updatekyc(Customer customer) {
		String sql = "UPDATE customer SET identificationtype=?,identificationnumber=?,occupationtype=?,designation=?,salary=?,kycstatus='Green' WHERE customerid=?";
		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { customer.getIdentificationtype(),
		                    customer.getIdentificationnumber(), customer.getOccupationtype(), customer.getDesignation(), 
		                    customer.getSalary(),customer.getCustomerid() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	
}
