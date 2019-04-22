package service;

import java.util.List;

import pojo.Anjuke;
import pojo.ShowAnjuke;
import pojo.ShowOther;
import util.PageBean;

public interface UserService {

	int selectCountTwo(String city);
	
	int selectCountOne(String city,String rentWay);

	PageBean<ShowAnjuke> findByPageAll(int currentPage, String city);
	
	PageBean<ShowAnjuke> findByPage(int currentPage, String city,String rentWay);
	
	PageBean<ShowAnjuke> findByPageAllScore(int currentPage, String city);
	
	PageBean<ShowAnjuke> findByPageScore(int currentPage, String city,String rentWay);
	
	//main找到所有
	List<Anjuke> findAllBasic(String city);
	
	List<Anjuke> findAllBasic(String city,String site);
	
	List<Anjuke> findBasic(String city,String rentWay);
	
	List<Anjuke> findBasic(String city,String rentWay,String site);
	
	List<ShowOther> findAll();
	
	List<ShowOther> find(String rentWay);
	
	int insertScore(List<ShowAnjuke> list);
	
	int deleteScore();
}
