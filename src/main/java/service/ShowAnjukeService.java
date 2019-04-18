package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import pojo.ShowAnjuke;

public interface ShowAnjukeService {
	
	List<ShowAnjuke> list(String city);
	
}
