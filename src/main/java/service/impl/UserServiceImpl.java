package service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.UserMapper;
import pojo.Anjuke;
import pojo.ShowAnjuke;
import pojo.ShowOther;
import service.UserService;
import util.PageBean;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userDao;

	@Override
	public int selectCountOne(String city,String rentWay) {
		return userDao.selectCountOne(city,rentWay);
	}

	@Override
	public PageBean<ShowAnjuke> findByPage(int currentPage, String city,String rentWay) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<ShowAnjuke> pageBean = new PageBean<ShowAnjuke>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userDao.selectCountOne(city,rentWay);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("city", city);
		map.put("rentWay", rentWay);
		// 封装每页显示的数据
		List<ShowAnjuke> lists = userDao.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public int selectCountTwo(String city) {
		return userDao.selectCountTwo(city);
	}

	@Override
	public PageBean<ShowAnjuke> findByPageAll(int currentPage, String city) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<ShowAnjuke> pageBean = new PageBean<ShowAnjuke>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userDao.selectCountTwo(city);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("city", city);
		// 封装每页显示的数据
		List<ShowAnjuke> lists = userDao.findByPageAll(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public List<Anjuke> findAllBasic(String city) {
		return userDao.findAllBasic(city);
	}

	@Override
	public List<Anjuke> findBasic(String city, String rentWay) {
		return userDao.findBasic(city,rentWay);
	}
	
	@Override
	public int insertScore(List<ShowAnjuke> list) {
		return userDao.insertScore(list);
	}

	@Override
	public List<ShowOther> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<ShowOther> find(String rentWay) {
		return userDao.find(rentWay);
	}

	@Override
	public PageBean<ShowAnjuke> findByPageAllScore(int currentPage, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<ShowAnjuke> findByPageScore(int currentPage, String city, String rentWay) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageBean<ShowAnjuke> pageBean = new PageBean<ShowAnjuke>();

		// 封装当前页数
		pageBean.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = userDao.selectCountOne(city,rentWay);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("city", city);
		map.put("rentWay", rentWay);
		// 封装每页显示的数据
		List<ShowAnjuke> lists = userDao.findByPage(map);
		pageBean.setLists(lists);

		return pageBean;
	}

	@Override
	public int deleteScore() {
		return userDao.deleteScore();
	}

	@Override
	public List<Anjuke> findAllBasic(String city, String site) {
		return userDao.findAllBasicSite(city,site);
	}

	@Override
	public List<Anjuke> findBasic(String city, String rentWay, String site) {
		return userDao.findBasicSite(city,rentWay,site);
	}


}
