package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pojo.Anjuke;
import pojo.ShowAnjuke;
import pojo.ShowOther;
import service.UserService;
import util.GetPoint;
import util.JuliUtil;
import util.PageBean;
import util.Score;

@SessionAttributes("currentUser")
@Controller
public class UserController {

	@Resource
	private UserService userService;

	/*
	 * http://localhost:8080/perfectssm/welcome  
	 * 首页
	 */
	@RequestMapping(value = "welcome")
	public String index(Model model) {
		return "welcome";
	}

	/*
	 * http://localhost:8080/perfectssm/welcomePro  
	 * 返回首页
	 */
	@RequestMapping(value = "welcomePro")
	public String indexPro(Model model) {
		userService.deleteScore();
		return "welcome";
	}

	/*
	 * http://localhost:8080/perfectssm/showMap  
	 * 高德地图
	 * 检索的是临时表main_score的数据
	 */
	@RequestMapping("/showMap")
	public String toIndexFour(@RequestParam(value = "rentWay") String rentWay, 
			@RequestParam(value = "location") String location, Model model) {
		
		String[] arr1 = new String[2];
		Map<String, String> json1 = GetPoint.getGeocoderLatitude(location);
		arr1[0] = json1.get("lng");
		arr1[1] = json1.get("lat");
		JSONArray jsonSelf = new JSONArray();
		jsonSelf.add(arr1[0]);
		jsonSelf.add(arr1[1]);
		String jsson = JSONArray.toJSONString(jsonSelf);
		model.addAttribute("jsonSelf", jsson);// 回显数据
		
		if (rentWay.equals("均可")) {
			List<ShowOther> list = userService.findAll();
			JSONArray jsonData = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				String zuobiao = list.get(i).getRowCol();
				String[] arr = zuobiao.split("_");
				JSONArray position = new JSONArray();
				position.add(arr[0]);
				position.add(arr[1]);
				JSONObject json = new JSONObject();
				json.put("position", position);
				json.put("score", list.get(i).getScore());
				json.put("url", list.get(i).getUrl());
				jsonData.add(json);
			}
			String nvrsjson = JSONArray.toJSONString(jsonData);
			model.addAttribute("jsonData", nvrsjson);// 回显数据
		} else {
			List<ShowOther> list = userService.find(rentWay);
			JSONArray jsonData = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				String zuobiao = list.get(i).getRowCol();
				String[] arr = zuobiao.split("_");
				JSONArray position = new JSONArray();
				position.add(arr[0]);
				position.add(arr[1]);
				JSONObject json = new JSONObject();
				json.put("position", position);
				json.put("score", list.get(i).getScore());
				json.put("url", list.get(i).getUrl());
				jsonData.add(json);
			}
			String nvrsjson = JSONArray.toJSONString(jsonData);
			model.addAttribute("jsonData", nvrsjson);// 回显数据
		}
		model.addAttribute("rentWay", rentWay);
		model.addAttribute("location", location);
		return "map";
	}

	/*
	 * http://localhost:8080/perfectssm/mainPage  
	 * 分页按钮
	 * 检索的是临时表main_score的数据
	 */
	@RequestMapping(value = "mainPage")
	public String mainPage(@RequestParam(value = "city") String city,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "rentWay", defaultValue = "均可", required = false) String rentWay, 
			@RequestParam(value = "location") String location, Model model) {
		if (rentWay.equals("均可")) {
			PageBean<ShowAnjuke> pageBean = userService.findByPageAll(currentPage, city);
			model.addAttribute("pagemsg", pageBean);// 回显分页数据
		} else {
			PageBean<ShowAnjuke> pageBean = userService.findByPage(currentPage, city, rentWay);
			model.addAttribute("pagemsg", pageBean);// 回显分页数据
		}
		model.addAttribute("city", city);
		model.addAttribute("rentWay", rentWay);
		model.addAttribute("location", location);
		return "search";
	}

	/*
	 * http://localhost:8080/perfectssm/main
	 * 从首页跳转到分页界面
	 * 检索的是表main_information的数据，生成临时表main_score
	 */
	@RequestMapping(value = "main")
	public String main(@RequestParam(value = "city") String city,@RequestParam(value = "site") String site,
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "rentWay", defaultValue = "均可", required = false) String rentWay,
			@RequestParam(value = "location") String location, Model model) {
		String[] arr = new String[2];
		Map<String, String> json = GetPoint.getGeocoderLatitude(location);
		arr[0] = json.get("lng");
		arr[1] = json.get("lat");
		if (rentWay.equals("均可")) {
			List<Anjuke> listBasic;
			if(site.equals("综合")) {
				listBasic = userService.findAllBasic(city);
			}else {
			    listBasic = userService.findAllBasic(city,site);
			}
			List<ShowAnjuke> listScore = new ArrayList<ShowAnjuke>();
			for (int i = 0; i < listBasic.size(); i++) {
				ShowAnjuke showAnjuke = new ShowAnjuke();
				showAnjuke.setName(listBasic.get(i).getName());
				showAnjuke.setAddress(listBasic.get(i).getAddress());
				showAnjuke.setArea(listBasic.get(i).getArea());
				showAnjuke.setHouseType(listBasic.get(i).getHouseType());
				showAnjuke.setRentWay(listBasic.get(i).getRentWay());
				showAnjuke.setPrice(listBasic.get(i).getPrice());
				showAnjuke.setRowCol(listBasic.get(i).getRowCol());
				showAnjuke.setPaymentMethod(listBasic.get(i).getPaymentMethod());
				showAnjuke.setUrl(listBasic.get(i).getUrl());
				String juli = listBasic.get(i).getRowCol();
				String[] a = juli.split("_");
				double distance = JuliUtil.calculateLineDistance(arr, a);
				showAnjuke.setDistance(distance);
				double score = Score.getScore(listBasic.get(i).getArea(), listBasic.get(i).getHouseType(),
						listBasic.get(i).getPrice(), listBasic.get(i).getPaymentMethod(), rentWay, distance);
				showAnjuke.setScore(score);
				listScore.add(i, showAnjuke);
			}
			userService.insertScore(listScore);
			PageBean<ShowAnjuke> pageBean = userService.findByPageAll(currentPage,city);
			model.addAttribute("pagemsg", pageBean);// 回显分页数据
		} else {
			List<Anjuke> listBasic;
			if(site.equals("综合")) {
				listBasic = userService.findBasic(city,rentWay);
			}else {
				listBasic = userService.findBasic(city,rentWay,site);
			}
			List<ShowAnjuke> listScore = new ArrayList<ShowAnjuke>();
			for (int i = 0; i < listBasic.size(); i++) {
				ShowAnjuke showAnjuke = new ShowAnjuke();
				showAnjuke.setName(listBasic.get(i).getName());
				showAnjuke.setAddress(listBasic.get(i).getAddress());
				showAnjuke.setArea(listBasic.get(i).getArea());
				showAnjuke.setHouseType(listBasic.get(i).getHouseType());
				showAnjuke.setRentWay(rentWay);
				showAnjuke.setPrice(listBasic.get(i).getPrice());
				showAnjuke.setRowCol(listBasic.get(i).getRowCol());
				showAnjuke.setPaymentMethod(listBasic.get(i).getPaymentMethod());
				showAnjuke.setUrl(listBasic.get(i).getUrl());
				String juli = listBasic.get(i).getRowCol();
				String[] a = juli.split("_");
				double distance = JuliUtil.calculateLineDistance(arr, a);
				showAnjuke.setDistance(distance);
				double score = Score.getScore(listBasic.get(i).getArea(), listBasic.get(i).getHouseType(),
						listBasic.get(i).getPrice(), listBasic.get(i).getPaymentMethod(), rentWay, distance);
				showAnjuke.setScore(score);
				listScore.add(i, showAnjuke);
			}
			userService.insertScore(listScore);
			PageBean<ShowAnjuke> pageBean = userService.findByPage(currentPage,city,rentWay);
			model.addAttribute("pagemsg", pageBean);// 回显分页数据
		}
		model.addAttribute("city", city);
		model.addAttribute("rentWay", rentWay);
		model.addAttribute("location", location);
		return "search";
	}

}
