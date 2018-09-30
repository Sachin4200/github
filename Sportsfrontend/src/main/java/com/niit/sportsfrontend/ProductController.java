package com.niit.sportsfrontend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.sportsbackend.dao.CategoryDao;
import com.niit.sportsbackend.dao.ProductDao;
import com.niit.sportsbackend.model.Category;
import com.niit.sportsbackend.model.Product;

@Controller
public class ProductController {
	 @Autowired
	 CategoryDao  categoryDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;

	@RequestMapping(value="/addProduct",method=RequestMethod.POST)


	public String productAdd(@ModelAttribute("pro") Product product,HttpSession httpSession)
	{
      if(product.getProductId()==0)
      {
    	 
    	if( productDao.addProduct(product))
    	{
         MultipartFile file=product.getImage();
			
			ServletContext con=httpSession.getServletContext();
			String filelocation=con.getRealPath("/resources/image/");
			System.out.println(filelocation);
			String filename=filelocation+"\\"+product.getProductId()+".jpg";
			System.out.println(filename);
			
			try{
				byte b[]=file.getBytes();
				FileOutputStream fos=new FileOutputStream(filename);
				fos.write(b);
				fos.close();
		    	}
			catch(IOException ex){}
			catch(Exception e){}
				}	
		}
      else {
    	  
    	  productDao.updateProduct(product);
    	  
      }
return"redirect:/product";


}

@RequestMapping("/deleteProduct/{id}")

public String productDelete(@PathVariable("id") int productId)
{
	productDao.deleteProduct(productId);
	return "redirect:/Product";
}


@RequestMapping("/editProduct/{id}")

public String productUpdate(@PathVariable("id") int productId,Model model)
{
Product productData=productDao.getProductById(productId);
List<Category> allCategory= categoryDao.getAllCategories();
model.addAttribute("pro",productData);
List<Product> allProduct= productDao.getAllProducts();
model.addAttribute("productList",allProduct);
model.addAttribute("categoryList",allCategory);
return "product";
}
}





