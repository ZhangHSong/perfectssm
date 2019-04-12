package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.AnjukeMainInformation;
import service.AnjukeMainInformationService;

@Controller
@RequestMapping("/anjukeMainInformation")
public class AnjukeMainInformationController {
	@Resource
	private AnjukeMainInformationService anjukeMainInformationService;

	//测试http://localhost:8080/perfectssm/anjukeMainInformation/showAnjukeMainInformation?id=785831445349377
	@RequestMapping("/showAnjukeMainInformation")
	public String toIndex(HttpServletRequest request, Model model) {
		long userId = Long.parseLong(request.getParameter("id"));
		AnjukeMainInformation anjukeMainInformation = this.anjukeMainInformationService.getUserById(userId);
		model.addAttribute("anjukeMainInformation", anjukeMainInformation);
		return "showAnjukeMainInformation";
	}
}
