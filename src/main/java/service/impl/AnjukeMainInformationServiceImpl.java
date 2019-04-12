package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AnjukeMainInformationDao;
import pojo.AnjukeMainInformation;
import service.AnjukeMainInformationService;

@Service("anjukeMainInformationService")
public class AnjukeMainInformationServiceImpl implements AnjukeMainInformationService {
	@Resource
	private AnjukeMainInformationDao anjukeMainInformationDao;

	@Override
	public AnjukeMainInformation getUserById(Long userId) {
		// TODO Auto-generated method stub
		return this.anjukeMainInformationDao.selectByPrimaryKey(userId);
	}
}
