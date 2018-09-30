package com.niit.sportsbackend.dao;

import java.util.List;

import com.niit.sportsbackend.model.Product;



public interface ProductDao 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
}
