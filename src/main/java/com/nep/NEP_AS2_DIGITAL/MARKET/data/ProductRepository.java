package com.nep.NEP_AS2_DIGITAL.MARKET.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
//import org.springframework.data.repository.CrudRepository;
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
	
	 public List<Product> findByName(String name) {
		 List<Product> products = new ArrayList<Product>();
		 for(Product product : productslist) {
		 if(product.getName().toLowerCase().contains(name.toLowerCase())) {
		 products.add(product);
		 }
		 }
		 return products;
		 }
	
	public void add(Product product){
		productslist.add(product);
	}
	
	public void delete(int ID) {
		Product product = findByID(ID);
		productslist.remove(product);
	}

//	public void save(Product product) {
//		productslist.add(product);
//	}
}


//public interface ProductRepository extends CrudRepository <Product, Integer>{}
