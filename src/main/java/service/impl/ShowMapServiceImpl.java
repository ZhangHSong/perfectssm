package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ShowAnjukeMapper;
import pojo.JSONMap;
import service.ShowMapService;

@Service("showMapService")
public class ShowMapServiceImpl implements ShowMapService {

	@Autowired
	private ShowAnjukeMapper showAnjukeMapper;

	@Override
	public List<String> listMap(String city) {
		return showAnjukeMapper.listMap(city);
	}

}
