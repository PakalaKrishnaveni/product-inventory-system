package com.base;

import com.business_layer.Product_Business;

public class Product 
{
    private  String productId;;
	private String productType;
	private String productBrand;
	private double productPrice;
	private int productQuantity;
	
	public Product(String productType,String productBrand,double productPrice,int productQuantity,String productId) 
	{	
		this.productType = productType;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productId=Product_Business.generateProductId(productType, productBrand);		
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productBrand=" + productBrand
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + 	"]";
	}

	public String getProductId() {
		return productId;
	}

	public String getProductType() {
		return productType;
	}

	public String getProductBrand() {
		return productBrand;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
