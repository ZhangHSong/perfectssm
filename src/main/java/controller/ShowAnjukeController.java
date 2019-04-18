package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ShowAnjukeService;
import service.ShowMapService;
import util.AddressChange;

//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class ShowAnjukeController {
	@Autowired
	ShowAnjukeService showAnjukeService;

	@Autowired
	ShowMapService showMapService;

	// 测试http://localhost:8080/perfectssm/showMap?city="合肥"
	// 高德地图
	@RequestMapping("/showMap")
	public String toIndexFour(HttpServletRequest request, Model model) {

		String city = request.getParameter("city");
		List<String> cs = showMapService.listMap(city);
		for (int i = 0; i < cs.size(); i++) {
			System.out.println(cs.get(i) + "");
			AddressChange.httpURLConnectionPOST(cs.get(i) + "");
		}

		// List<String> position = new ArrayList<>();
		// position.add("extImgUrl1");
		// position.add("extImgUrl2");
		// AdsVo adsVo = new AdsVo();
		// adsVo.setExtImgUrl(extImgUrlList);
		// //对象转json
		// Gson gson =new Gson();
		// String json = gson.toJson(adsVo);
		// }

		return "map";
	}

}
