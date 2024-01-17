package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.*;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService usrvc;
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/check")
	public ModelAndView check(@RequestParam("uname") String uname, @RequestParam("pass") String pass, HttpSession s) {
		User u = usrvc.validate(uname, pass);
		if(u != null) {
			s.setAttribute("user",u);
			return new ModelAndView("redirect:/product/getproducts");
		}
		return new ModelAndView("Success","msg","Unsuccessful login");
	}
}
