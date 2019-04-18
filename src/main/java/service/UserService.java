package service;

import pojo.ShowAnjuke;
import util.PageBean;

public interface UserService {

	int selectCount(String city);

	PageBean<ShowAnjuke> findByPage(int currentPage, String city);
}
