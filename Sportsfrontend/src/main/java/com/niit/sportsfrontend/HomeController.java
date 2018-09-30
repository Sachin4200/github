package com.niit.sportsfrontend;
 


	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
	
import com.niit.sportsbackend.dao.CategoryDao;
import com.niit.sportsbackend.dao.CustomerDao;
import com.niit.sportsbackend.dao.ProductDao;
import com.niit.sportsbackend.model.Category;
import com.niit.sportsbackend.model.Customer;
import com.niit.sportsbackend.model.Product;
	
	
	@Controller
	public class HomeController {
	@Autowired
		Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	 Customer customer;
	
	@Autowired
	CustomerDao customerDao;
	 
	
	@RequestMapping("/")
	public String rootPage()
	{
		return "index";
		
	}
	
	
		@RequestMapping("index")
		public String homePage()
		{
			return "index";
			
		}
		
		@RequestMapping("/login")
		public String loginPage()
		{
			
			return "Login";
		}
	
	
	@RequestMapping("/logout")
	public String logoutpage()
	{
		
		return "Login";
	}
		
		@RequestMapping("/registration")
		public String registrationPage()
		{
			
			return "registration";
			
		}
		@RequestMapping("/Category")
		public String categoryPage(Model model)
		{
			List<Category> allCategory=categoryDao.getAllCategories();			
			model.addAttribute("cat", category);
			model.addAttribute("categoryList",allCategory);
			
			return "Category";
			
		}
		
		
		@RequestMapping("/Product")
		public String productPage(Model model)
		{
			List<Category> allCategory= categoryDao.getAllCategories();
			List<Product> allProducts= productDao.getAllProducts();			
			model.addAttribute("pro", product);
			model.addAttribute("productList",allProducts);
			model.addAttribute("categoryList",allCategory);
			
			return "Product";
			
		} 
		
		
     
	
	@RequestMapping("/Customer")
	public String customerPage(Model model)
	{
		List<Customer> allCustomer=customerDao.getAllCustomer();			
		model.addAttribute("cus", customer);
		model.addAttribute("customerList",allCustomer);
		
		return "Customer";
		
	}
	}