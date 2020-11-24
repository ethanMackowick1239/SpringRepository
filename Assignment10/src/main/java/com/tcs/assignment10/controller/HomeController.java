package com.tcs.assignment10.controller;

import javax.swing.SwingContainer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//@GetMapping("/")
	@RequestMapping(path = {"/"},method=RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@GetMapping("/guest")
	public String getHandler(@RequestAttribute("fname") String fname, Model model) {
		
		model.addAttribute("mname", "a");
		return "guest";
		
	}
}
