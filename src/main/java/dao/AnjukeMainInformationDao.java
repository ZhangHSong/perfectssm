package dao;

import pojo.AnjukeMainInformation;

public interface AnjukeMainInformationDao {
    int deleteByPrimaryKey(Long number);

    int insert(AnjukeMainInformation record);

    int insertSelective(AnjukeMainInformation record);

    AnjukeMainInformation selectByPrimaryKey(Long number);

    int updateByPrimaryKeySelective(AnjukeMainInformation record);

    int updateByPrimaryKeyWithBLOBs(AnjukeMainInformation record);

    int updateByPrimaryKey(AnjukeMainInformation record);
}