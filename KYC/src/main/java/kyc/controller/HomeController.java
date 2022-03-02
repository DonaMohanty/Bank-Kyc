package kyc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kyc.dao.CustomerDAO;
import kyc.model.Customer;
import kyc.model.Users;

@Controller
public class HomeController {
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
	public ModelAndView createCustomer(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("gender") String gender,
			@RequestParam("dob") String dob, @RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("country") String country,
			@RequestParam("postalcode") int postalcode, ModelAndView mv) {

		Customer customer = new Customer();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setGender(gender);
		customer.setDob(dob);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setCountry(country);
		customer.setPostalcode(postalcode);

		int counter = customerDAO.create(customer);

		if (counter > 0) {
			mv.addObject("msg", "Customer registration successful.");
		} else {
			mv.addObject("msg", "Something Went Wrong.");
		}

		mv.setViewName("newcustomer");

		return mv;
	}

	@RequestMapping(value = "/home")
	public ModelAndView readCustomer(ModelAndView model) throws IOException {
		List<Customer> listCustomer = customerDAO.read();
		model.addObject("listCustomer", listCustomer);
		model.setViewName("home");
		return model;
	}

	@GetMapping(value = "/add")
	public ModelAndView firstView() {
		ModelAndView mav = new ModelAndView("newcustomer");
		return mav;
	}
	
	@GetMapping(value = "/log")
	public ModelAndView secondView() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@GetMapping(value = "/kycinfo")
	public ModelAndView thirdView() {
		ModelAndView mav = new ModelAndView("kyc");
		return mav;
	}
	@RequestMapping(value = "/update/{customerid}")
	public ModelAndView findCustomerById(ModelAndView model, @PathVariable("customerid") int customerid)
			throws IOException {

		List<Customer> listCustomer = customerDAO.findCustomerById(customerid);
		model.addObject("listCustomer", listCustomer);
		model.setViewName("editcustomer");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@RequestParam("customerid") int customerid,@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("gender") String gender,
			@RequestParam("dob") String dob, @RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("country") String country,
			@RequestParam("postalcode") int postalcode, ModelAndView mv) {

		Customer customer = new Customer();
		customer.setCustomerid(customerid);
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setGender(gender);
		customer.setDob(dob);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setCountry(country);
		customer.setPostalcode(postalcode);

		int counter = customerDAO.update(customer);

		if (counter > 0) {
			List<Customer> listCustomer = customerDAO.read();
			mv.addObject("listCustomer", listCustomer);
			mv.addObject("msg", "Successfully Updated Customer.");
			mv.setViewName("./home");
		} else {
			mv.addObject("msg", "Something Went Wrong.");
		}
		return mv;
	}

	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ModelAndView processForm(@RequestParam("username") String username,
	    		@RequestParam("password") String password,ModelAndView model,HttpSession session, Users users) {
	      List<Users> user = customerDAO.checkUser(users.getUsername(), users.getPassword()); 
	        if (user.size() > 0 ) {
	        	List<Customer> listCustomer = customerDAO.read();
	        	model.addObject("listCustomer", listCustomer);
	        	model.setViewName("./home");
	        	session.setAttribute("username", username);
	        	return model;
	        }else{
	        	model.addObject("msg", "invalid credentials");
	        	model.setViewName("./login");
	        	return model;
	        }   
	    }
	 
	 @RequestMapping(value = "logout", method = RequestMethod.GET)
		public String logout(HttpSession session) {
			session.removeAttribute("username");
			return "./login";
		}
	 
	 
	 @RequestMapping(value = "/updatekyc", method = RequestMethod.POST)
		public ModelAndView updateKYC(@RequestParam("customerid") int customerid,@RequestParam("identificationtype") String identificationtype,
				@RequestParam("identificationnumber") int identificationnumber, @RequestParam("occupationtype") String occupationtype,
				@RequestParam("designation") String designation, @RequestParam("salary") int salary,
				ModelAndView mv) {

			Customer customer = new Customer();
			customer.setCustomerid(customerid);
			customer.setIdentificationtype(identificationtype);
			customer.setIdentificationnumber(identificationnumber);
			customer.setOccupationtype(occupationtype);
			customer.setDesignation(designation);
			customer.setSalary(salary);

			int counter = customerDAO.updatekyc(customer);

			if (counter > 0) {
				List<Customer> listCustomer = customerDAO.read();
				mv.addObject("listCustomer", listCustomer);
				mv.addObject("msg", "Successfully Updated KYC Information.");
				mv.setViewName("./home");
			} else {
				mv.addObject("msg", "Something Went Wrong.");
			}
			return mv;
		}
}
