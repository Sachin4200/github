package com.niit.sportsbackend.model;


	import java.io.Serializable;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


	@Component
	@Entity
	@Table

	public class Product implements Serializable

	{
	       @Id //primary key
	       @GeneratedValue(strategy=GenerationType.SEQUENCE)
	       
		  private int productId;
	      private String productName;
	      private int productPrice;
	      private int productQuantity;
	      private String productDescription;
	      private int categoryId;
	      @Transient
		  private MultipartFile image;
		  
	      @JoinColumn(name="categoryId",updatable=false,insertable=false,nullable=false)
	      @ManyToOne
	      @Autowired
	      Category category;
	      
	    public int getCategoryId() {
	    	return categoryId;
	    }
	      
	    public void setCategoryId(int categoryId) {
	    	this.categoryId =categoryId;
	    }
	      
	      
	     public int getProductId() {
	    	  return productId;
	      }
	     public void setProductId(int productId) {
	    	  this.productId=productId;
	      }
	    
	      
	    public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		public int getProductQuantity() {
			return productQuantity;
		}
		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		
		
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public MultipartFile getImage() {
			return image;
		}

		public void setImage(MultipartFile image) {
			this.image = image;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}
		
		
		
	}


