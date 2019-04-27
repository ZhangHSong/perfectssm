package service;

import java.util.List;

import pojo.Anjuke;
import pojo.ShowAnjuke;
import pojo.ShowOther;
import util.PageBean;

public interface UserService {

	// 检索爬虫数据表的数据（生成临时表）
	List<Anjuke> findAllBasic(String city);

	// 检索爬虫数据表的数据（生成临时表）
	List<Anjuke> findAllBasic(String city, String site);

	// 检索爬虫数据表的数据（生成临时表）
	List<Anjuke> findBasic(String city, String rentWay);

	// 检索爬虫数据表的数据（生成临时表）
	List<Anjuke> findBasic(String city, String rentWay, String site);

	// 检索临时表的数据（高德地图）
	List<ShowOther> findAll();

	// 检索临时表的数据，分整/合租（高德地图）
	List<ShowOther> find(String rentWay);

	// 检索临时表的数据（分页）
	PageBean<ShowAnjuke> findByPageAll(int currentPage, String city);

	// 检索临时表的数据，分整/合租（分页）
	PageBean<ShowAnjuke> findByPage(int currentPage, String city, String rentWay);

	// 向临时表插入数据
	int insertScore(List<ShowAnjuke> list);
	
	// 删除临时表
	int deleteScore();

}
