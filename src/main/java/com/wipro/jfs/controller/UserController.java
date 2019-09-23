package com.wipro.jfs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.jfs.entity.User;
import com.wipro.jfs.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/", "/index.html"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		userService.removeUserSession(request.getSession());
		model.addAttribute("user", new User());
		model.addAttribute("title", "Online Assessment - Home Page");
		return "home";
	}

	@RequestMapping(value = {"/login/do"}, method = RequestMethod.POST)
	public String login(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, HttpServletRequest request, Model model) {
		String loginResult = userService.validateLogin(user);
		if("I".equals(loginResult)) {
			model.addAttribute("title", "Invalid User Page");
			model.addAttribute("message", "Sorry you are not a registered User !!!");
			model.addAttribute("loginResult", loginResult);
			return "result";
		} else if("F".equals(loginResult)) {
			model.addAttribute("title", "Password Error Page");
			model.addAttribute("message", "Sorry your Password is Wrong !!! Login again !!!");
			model.addAttribute("loginResult", loginResult);
			return "result";
		} else if("SA".equals(loginResult)) {
			model.addAttribute("title", "Select Reports");
			model.addAttribute("link1", "View list of all candidates");
			model.addAttribute("link2", "View list of all tests taken");
			model.addAttribute("link3", "Logout");
			model.addAttribute("loginResult", loginResult);
			userService.saveUserSession(request.getSession(), user);
			return "userHome";
		} else if("SC".equals(loginResult)) {
			model.addAttribute("title", "Select Tests");
			model.addAttribute("link1", "Spring Assessment");
			model.addAttribute("link2", "Hibernate Assessment");
			model.addAttribute("link3", "Logout");
			model.addAttribute("loginResult", loginResult);
			userService.saveUserSession(request.getSession(), user);
			return "userHome";
		}
		return "home";
	}

	@RequestMapping(value = {"/register/do", "register.html"}, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Registration Page");
		return "register";
	}

	@RequestMapping(value = "/registration/do", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, Model model) {
		String fullName = user.getFirstName()+" "+user.getLastName();
		user.setType("C");
		String registrationResult = userService.registerUser(user);
		if("D".equals(registrationResult)) {
			model.addAttribute("title", "Email Already Registered Page");
			model.addAttribute("message", "Sorry Email Already Registered !!!");
			model.addAttribute("registrationResult", registrationResult);
			return "result";
		} else if("S".equals(registrationResult)) {
			model.addAttribute("title", "Registration Confirmation");
			model.addAttribute("message", "Registered Successfully!!!");
			model.addAttribute("message2", fullName);
			model.addAttribute("registrationResult", registrationResult);
			return "result";
		}
		return "home";
	}
	
	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public String getUsers(Model model) {
		List<User> userList = userService.getUsers();
		model.addAttribute("title", "All User Details");
		model.addAttribute("userList", userList);
		model.addAttribute("reportType", "UR");
		return "report";
	}

	@RequestMapping(value = "/logout/do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		userService.removeUserSession(request.getSession());
		return "home";
	}

}
