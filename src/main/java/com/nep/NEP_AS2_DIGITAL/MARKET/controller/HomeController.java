package com.nep.NEP_AS2_DIGITAL.MARKET.controller;

import java.util.ArrayList;
import java.util.List;

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
 ProductRepository productRepository;	
 
 @RequestMapping(value="/")
 public String home() {
	 return "Home.html";
 }
 
 @RequestMapping(value="/create")
 public String addproduct() {
	 return "addProduct.html";
 }
 
 @RequestMapping(value="/add/product")
 public String add(
		 @RequestParam(required=true) int product_id,
		 @RequestParam(required=true) String product_name,
		 @RequestParam(required=true) double product_price,
		 @RequestParam(required=true) String product_type
		 ) {
	 Product product = new Product(product_id, product_name, product_price, product_type);
	 productRepository.add(product);
	 return "redirect:/read";
 }
 
 @RequestMapping(value="/update/{ProductID}")
 public String editproduct(@PathVariable int ProductID, ModelMap modelMap) {
	 Product product = productRepository.findByID(ProductID);
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
	 Product product = productRepository.findByID(product_id);
	 product.setName(product_name);
	 product.setPrice(product_price);
	 product.setType(product_type);
	 return "redirect:/update/" + product_id;
 }
 
 @RequestMapping(value="/read")
 public String product(ModelMap modelMap) {
	 ArrayList<Product> productslist = productRepository.getAllProducts();
	 modelMap.put("productslist", productslist);
	 return "Product.html";
 }
 
 @RequestMapping(value="/search")
 public String searchproduct(ModelMap modelMap) {
	 ArrayList<Product> productslist = productRepository.getAllProducts();
	 modelMap.put("productslist", productslist);
	 return "searchProduct.html";
 }
 
 @RequestMapping(value="/search/product/")
 public String search(@RequestParam(required=true) String product_name,
ModelMap modelMap) {
 List<Product> products = null;
 if(product_name == null) {
 products = productRepository.getAllProducts();
 } else {
	 products = productRepository.findContainName(product_name);
 }
 modelMap.put("products", products);
	 return "redirect:/search";
 }
 
 @RequestMapping(value="/delete/{ProductID}")
 public String deleteproduct(@PathVariable int ProductID) {
	 productRepository.delete(ProductID);
	 return "redirect:/read";
 }
}
