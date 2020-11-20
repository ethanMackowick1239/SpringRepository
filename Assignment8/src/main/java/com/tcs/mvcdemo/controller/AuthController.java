package com.tcs.mvcdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.mvcdemo.model.Login;
import com.tcs.mvcdemo.repository.LoginRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {

	@Autowired
	LoginRepository loginRepository;
	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login.html")
	public ModelAndView validateLogin(@ModelAttribute @Valid Login login,BindingResult result) {
		System.out.println("hello from validatelogin"+login);
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage() + " "+ e.getField());
				
			});
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		if(login.equals(loginRepository.findById(login.getUserName()).get())) {
			System.out.println("success");
		}
		else {
			System.out.println("fail");
		}
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}
}
