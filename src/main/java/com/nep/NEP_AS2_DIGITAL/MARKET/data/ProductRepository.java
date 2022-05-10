package com.nep.NEP_AS2_DIGITAL.MARKET.data;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.nep.NEP_AS2_DIGITAL.MARKET.model.Product;

@Component
public class ProductRepository {
	private static ArrayList<Product> productslist = new ArrayList<Product>(
			Arrays.asList(
					new Product(001, "IPhone 11", 656.0, "phone"),
					new Product(002, "Dell Inpiron 15", 500, "Laptop")
					)
			);
	
	public static ArrayList<Product> getAllProducts(){
		return productslist;
	}

	public Product findByID(int ID) {
		for(Product product : productslist) {
			if (product.getID() == ID) {
				return product;
			}
		}
		return null;
	}
	
	public void add(Product product){
		productslist.add(product);
	}
	
	public void delete(int ID) {
		Product product = findByID(ID);
		productslist.remove(product);
	}
}
