package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Anjuke;
import pojo.ShowAnjuke;
import pojo.ShowOther;

public interface UserMapper {
	/**
	 * 查询用户记录总数
	 * 
	 * @return
	 */
	int selectCountOne(@Param(value = "city")String city,@Param(value = "rentWay")String rentWay);

	int selectCountTwo(@Param(value = "city")String city);
	
	/**
	 * 分页操作，调用findByPage limit分页方法
	 * 
	 * @param map
	 * @return
	 */
	List<ShowAnjuke> findByPage(HashMap<String, Object> map);
	
	List<ShowAnjuke> findByPageAll(HashMap<String, Object> map);
	
	List<Anjuke> findAllBasic(@Param(value = "city")String city);
	
	List<Anjuke> findBasic(@Param(value = "city")String city,@Param(value = "rentWay")String rentWay);
	
	List<Anjuke> findAllBasicSite(@Param(value = "city")String city,@Param(value = "site")String site);
	
	List<Anjuke> findBasicSite(@Param(value = "city")String city,@Param(value = "rentWay")String rentWay,@Param(value = "site")String site);
	
	
	List<ShowOther> findAll();
	
	List<ShowOther> find(@Param(value = "rentWay")String rentWay);
	
	int insertScore(List<ShowAnjuke> list);
	
	int deleteScore();
	

}
