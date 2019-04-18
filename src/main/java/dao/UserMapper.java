package dao;

import java.util.HashMap;
import java.util.List;

import pojo.ShowAnjuke;

public interface UserMapper {
	/**
	 * 查询用户记录总数
	 * 
	 * @return
	 */
	int selectCount(String city);

	/**
	 * 分页操作，调用findByPage limit分页方法
	 * 
	 * @param map
	 * @return
	 */
	List<ShowAnjuke> findByPage(HashMap<String, Object> map);
}
