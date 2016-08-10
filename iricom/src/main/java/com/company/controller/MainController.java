package com.company.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.model.UserVo;

@Controller
public class MainController {

	//���� ������
	@RequestMapping("/main")
	public String mainPage(Authentication auth, Model model) {

		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal != null && principal instanceof UserVo) {
				UserVo userVo = (UserVo) principal;
				model.addAttribute("userVo", userVo);
			}
		}
		return "/main";
	}
	//�α��� ������
	@RequestMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	//�귣�� ������
	@RequestMapping("/brands")
	public String brands(){
		return "/brands";
	}
	//���� ���� ������
	@RequestMapping("/accessDenied")
	public String accessDenied(){
		return "/accessDenied";
	}
}
