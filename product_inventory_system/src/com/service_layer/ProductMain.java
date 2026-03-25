package com.service_layer;

import java.util.Scanner;

import com.base.Product;
import com.business_layer.Product_Business;
import com.validation_layer.Data_Validation;

public class ProductMain {

	public static void main(String[] args) throws InterruptedException 
	{
		Scanner sc=new Scanner(System.in);
		Product_Business.animateString("*-= Welcome to JSP - Product Inventory System =-*");
		System.out.println("\u001B[1;33m"+"Login to the Inventory"+"\u001B[0m");
		System.out.println("\u001B[1m"+"Enter your Mobile Number"+"\u001B[0m");
		long mobileNumber=sc.nextLong();
		
		if(Data_Validation.validateMobileNumber(mobileNumber))
		{
			int genOTP=Product_Business.generateOTP();
			System.out.println("Your OTP : "+genOTP);
			
			System.out.println("Enter the OTP");
			int enOTP=sc.nextInt();
			
			if(genOTP==enOTP)
			{
				System.out.println( "\u001B[1;32m"+"Login Successful....✔✔"+"\u001B[0m");
				while(true)
				{
					System.out.println("1. Add Product");
				    System.out.println("2. Remove Product");
				    System.out.println("3. View all Products");
				    System.out.println("4. search a Product");
				    System.out.println("5. Update a Product");
				    System.out.println("6.close");
					System.out.println("Select an option");

				    
				    int option=sc.nextInt();
				    switch(option)
				    {
				    case 1:{
				    	Product_Business.addProduct();
				    	break;
				    }
				    case 2: {
				    	Product_Business.removeProduct();
				    	break;
				    }
				    case 3:{
				    	Product_Business.viewAllProducts();
				    	break;
				    }
				    case 4:{
				    	Product_Business.searchProduct();
				    	break;
				    }
				    case 5:{
				    	Product_Business.updateProduct();			    	
				    	break;
				    }
				    case 6:{
				    	System.out.println("\u001B[35m"+"Thank You....🙏🙏"+"\u001B[0m");
				    	System.exit(0);
				    	break;
				    }
				    default:System.out.println("\u001B[1;31m"+"Invalid"+"\u001B[0m");				    
				    }				    
				}
			}
			else
				System.out.println("\u001B[1;31m"+"Invalid OTP. \nTry Again after sometime"+"\u001B[0m");
		}else
			System.out.println("\u001B[1;31m"+"Invalid Mobile Number"+"\u001B[0m");
		}
	}

	
