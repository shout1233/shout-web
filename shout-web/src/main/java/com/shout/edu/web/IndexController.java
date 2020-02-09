package com.shout.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shout.edu.config.auth.LoginUser;
import com.shout.edu.config.auth.dto.SessionUser;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser sessionUser) {

		if (sessionUser != null) {
			System.out.println(">>>>>>>> HandlerMethodArgumentResoler Session : " + sessionUser.getName());
			model.addAttribute("userName", sessionUser.getName());
		} else {
			System.out.println(">>>>>>>> 세션 없음");
		}
		
		return "index";
	}
	
	@GetMapping("post/save")
	public String postSave() {
		System.out.println(">>>>>>>>> post-save go!!!");
		return "post-save";
	}
}
