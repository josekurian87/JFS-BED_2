package com.wipro.jfs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.jfs.entity.User;
import com.wipro.jfs.service.UserService;

@Controller
public class TestResultController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/evaluate/{topic}/test", method = RequestMethod.POST)
	public String submitTest(@PathVariable("topic") String topic, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("Question1"));
		System.out.println(request.getParameter("Question2"));
		System.out.println(request.getParameter("Question3"));
		System.out.println(request.getParameter("Question4"));
		System.out.println(request.getParameter("Question5"));
		
		User userData = userService.getUserFromSession(request.getSession());
		if(userData == null) {
			model.addAttribute("title", "Session Expired");
			model.addAttribute("message", "User Session !!!");
			model.addAttribute("sessionResult", "E");
			return "result";
		} else {
			model.addAttribute("title", "Success Page");
			model.addAttribute("message", "Congratulations !!! You have passed !!!");
			model.addAttribute("assessmentResult", "P");
			model.addAttribute("userData", userData);
			return "result";
		}
	}

}
