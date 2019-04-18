package service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import dao.ShowAnjukeMapper;
import pojo.ShowAnjuke;
import service.ShowAnjukeService;

@Service("showAnjukeService")
public class ShowAnjukeServiceImpl implements ShowAnjukeService {
	@Autowired
	private ShowAnjukeMapper showAnjukeMapper;


	@Override
	public List<ShowAnjuke> list(String city) {
		return showAnjukeMapper.list(city);
	}
}
