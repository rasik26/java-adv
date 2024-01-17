package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService psrvc;
	
	@GetMapping("/getproducts")
	public ModelAndView getproducts(HttpSession s) {
		User u = (User)s.getAttribute("user");
		if(u != null) {
			List<Product> plist = psrvc.showAll();
			for(Product p: plist)
			{
				System.out.println(p);
			}
			return new ModelAndView("Products", "plist", plist);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/addProduct")
	public String addProduct(HttpSession s) {
		User u = (User)s.getAttribute("user");
		if(u != null)
			return "AddProd";
		return "redirect:/login/";
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("price") double price, @RequestParam("qty") int qty) {
		Product p = new Product(pid, pname, price, qty);
		if(psrvc.insert(p) > 0)
			return new ModelAndView("redirect:/product/getproducts");
		return new ModelAndView("Success", "msg", "Unable to Insert Product");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid) {
		Product p = psrvc.showById(pid);
		return new ModelAndView("EditProd","p",p);
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("price") double price, @RequestParam("qty") int qty) {
		psrvc.upById(new Product(pid, pname, price, qty));
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		if(psrvc.delById(id) > 0)
			return new ModelAndView("redirect:/product/getproducts");
		return new ModelAndView("Success", "msg", "Unable to Delete The Product");
	}

}
