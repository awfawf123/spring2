package co.company.spring.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/login")//로그인페이지이동
	public String loginForm() {
		return "user/login";
	}



	@PostMapping("/login")//로그인처리
	public String login(HttpSession session) {
		session.setAttribute("loginId", "user");
		return "redirect:/empSelect";
	}
	@GetMapping("/logout")//로그아웃처리
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}

}
