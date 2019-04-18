package service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserMapper;
import pojo.ShowAnjuke;
import service.UserService;
import util.PageBean;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userDao;

	@Override
	public int selectCount(String city) {
		return userDao.selectCount(city);
	}

	@Override
	public PageBean<ShowAnjuke> findByPage(int currentPage, String city) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<ShowAnjuke> pageBean = new PageBean<ShowAnjuke>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userDao.selectCount(city);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("city", city);
		// 封装每页显示的数据
		List<ShowAnjuke> lists = userDao.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}
}
