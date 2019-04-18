package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.UserService;

@SessionAttributes("currentUser")
@Controller
public class UserController {

	@Resource
	private UserService userService;

	//	http://localhost:8080/perfectssm/main
	@RequestMapping(value = "main")  
	public String main(@RequestParam(value = "city",  required = false) String city,@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			Model model) {
		model.addAttribute("pagemsg", userService.findByPage(currentPage,city));// 回显分页数据
		model.addAttribute("city", city);
		return "search";
	}

}
