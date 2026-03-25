package com.business_layer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.base.Product;

public class Product_Business 
{
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Product> productList=new ArrayList<Product>();
	public static int generateOTP()
	{
		Random r=new Random();
		int genOTP=r.nextInt(99999);
		return genOTP;
	}
		
    public static String generateProductId(String productType,String productBrand)
    {
    	String productId=""+productType.substring(0,3);
    	Random r=new Random();
    	productId=productId+r.nextInt(999)+
    			  productBrand.substring(productBrand.length()-3);
    	return productId.toUpperCase();   	
    }
	public static void addProduct()
	{
		System.out.println("Enter the Product Type");
		String productType=sc.next();
		
		System.out.println("Enter the Product Brand");
		String productBrand=sc.next();

		System.out.println("Enter the Product Price");
		double productPrice=sc.nextDouble();

		System.out.println("Enter the Product Quantity");
		int productQuantity=sc.nextInt();
		String productId=generateProductId(productType, productBrand);
		Product p = new Product(productType,productBrand,productPrice,productQuantity,productId);
		productList.add(p);
		System.out.println(p);
		System.out.println("\u001B[1;32m"+"Product added Successfully....."+"\u001B[0m");
	
	}

    
    public static void  viewAllProducts()
    {  
    	if(productList.isEmpty()) 
    		System.out.println("List is Empty");
    	else {
    		System.out.println("--------------------------------------------------------------------------------------------");
    		System.out.printf("|\u001B[1;35m"+" %-15s | %-15s | %-15s | %-15s | %-15s | %n","Product ID",
    				          "Product Type","Product Brand","Product Price","Product Quantity"+"\u001B[0m");
    		System.out.println("--------------------------------------------------------------------------------------------");

    	    for(Product p: productList)
    	    {
    		   System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-16s | %n"
    	                           ,p.getProductId(),p.getProductType(),p.getProductBrand(),p.getProductPrice(),p.getProductQuantity());
    	   }
    	}
    }
    
    public static void removeProduct()
    {
    	if(productList.isEmpty())
		     System.out.println("\u001B[1;34m"+"No Product Added..\nAdd a Product"+"\u001B[0m");
	    else {
    	   System.out.println("Enter thr Product Id");
    	   String productId=sc.next();
    	   Iterator<Product> itr=productList.iterator();
    	   Product product =null;
    	   while(itr.hasNext())
    	   {
    		 Product cp=itr.next();
    		 if(cp.getProductId().equalsIgnoreCase(productId)){
    			product=cp;	
    			itr.remove();
    	      }    		
    	   }
    	   if(product==null)
    		   System.out.println("\u001B[1;31m"+"Invalid Product Id.\nPlease Enter the Valid Product Id"+"\u001B[0m");
    	   else
    		   System.out.println("\u001B[1;32m"+"\nRemoved Successfully..."+"\u001B[0m");
	    }
    }
    
    public static void searchProduct()
    {
    	if(productList.isEmpty())
    		System.out.println("\u001B[1;34m"+"No Product Added..\nAdd a Product"+"\u001B[0m");
    	else {
    	    System.out.println("Enter the Product Id");
    	    String productId=sc.next();
 	        Product product =null;
    	    for(Product p:productList)
    	    {
    		   if(p.getProductId().equalsIgnoreCase(productId))
    			    product=p;
    	    }
    	
 	        if(product==null)
		       System.out.println("\u001B[1;31m"+"Invalid Product Id"+"\u001B[0m");
	        else
		       System.out.println(product);
    	}  	
    }
    
    public static void updateProduct()
    {
    	if(productList.isEmpty())
    		System.out.println("\u001B[1;34m"+"No Product Added..\nAdd a Product"+"\u001B[0m");
    	else {
    	    System.out.println("Enter the Product Id");
    	    String productId=sc.next();
    	    Product product=null;
    	    for(Product p:productList)
    	    {
    		   if(p.getProductId().equals(productId))
    		   {
    			System.out.println("Enter the Updated Price");
    			double updatedPrice=sc.nextDouble();
    			p.setProductPrice(updatedPrice);
    			product=p;
    		   }   		
    	    }
    	}    	
    } 
    
    public static void animateString(String st) throws InterruptedException
    {
    	for(int i=0;i<=st.length()-1;i++)
    	{
    		System.out.print("\u001B[1;35m"+st.charAt(i));
    		Thread.sleep(150);
    	}
    	System.out.println("\u001B[0m");
    }
}
