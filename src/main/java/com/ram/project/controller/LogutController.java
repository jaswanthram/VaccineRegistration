package com.ram.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogutController {

	@RequestMapping(value = "/goToLogout")
	public String logout() {
        return "/WEB-INF/LoginPage.jsp";
	}
}

