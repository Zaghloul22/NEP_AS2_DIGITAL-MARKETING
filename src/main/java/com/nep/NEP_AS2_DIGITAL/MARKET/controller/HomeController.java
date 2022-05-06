package com.nep.NEP_AS2_DIGITAL.MARKET.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
 @RequestMapping(value="/home")
 public String home() {
	 return "Home";
 }
 
 @RequestMapping(value="/create")
 public String addproduct() {
	 return "addProduct";
 }
 
 @RequestMapping(value="/update")
 public String editproduct() {
	 return "editProduct";
 }
 
 @RequestMapping(value="/product")
 public String product() {
	 return "Product";
 }
 
 @RequestMapping(value="/search")
 public String searchproduct() {
	 return "searchProduct";
 }
}
