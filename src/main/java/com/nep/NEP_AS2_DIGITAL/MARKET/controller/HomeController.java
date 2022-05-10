package com.nep.NEP_AS2_DIGITAL.MARKET.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nep.NEP_AS2_DIGITAL.MARKET.data.ProductRepository;
import com.nep.NEP_AS2_DIGITAL.MARKET.model.Product;


@Controller
public class HomeController {
 @Autowired
 ProductRepository productRepo;	
 
 @RequestMapping(value="/")
 public String home() {
	 return "Home.html";
 }
 
 @RequestMapping(value="/create")
 public String addproduct() {
	 return "addProduct.html";
 }
 
 @RequestMapping(value="/update/{ProductID}")
 public String editproduct(@PathVariable int ProductID, ModelMap modelMap) {
	 Product product = productRepo.findByID(ProductID);
	 if(product != null) {
		 modelMap.put("product", product);
		 return "editProduct.html";
	 }else {
		 return "redirect:/read";
	 }
 }
 
 @RequestMapping(value="/edit/product/{product_id}")
 public String edit(
		 @PathVariable int product_id,
		 @RequestParam(required=true) String product_name,
		 @RequestParam(required=true) double product_price,
		 @RequestParam(required=true) String product_type
		 ) {
	 Product product = productRepo.findByID(product_id);
	 product.setName(product_name);
	 product.setPrice(product_price);
	 product.setType(product_type);
	 return "redirect:/update/" + product_id;
 }
 
 @RequestMapping(value="/read")
 public String product(ModelMap modelMap) {
	 ArrayList<Product> productslist = ProductRepository.getAllProducts();
	 modelMap.put("productslist", productslist);
	 return "Product.html";
 }
 
 @RequestMapping(value="/search")
 public String searchproduct() {
	 return "searchProduct.html";
 }
 
 @RequestMapping(value="/delete/{ProductID}")
 public String deleteproduct(@PathVariable int ProductID) {
	 productRepo.delete(ProductID);
	 return "redirect:/read";
 }
}
