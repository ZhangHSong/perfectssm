package perfectssm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import pojo.AnjukeMainInformation;
import service.AnjukeMainInformationService;  
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
    @Resource  
    private AnjukeMainInformationService anjukeMainInformationService = null;  
  
  
    @Test  
    public void test1() {  
    	AnjukeMainInformation anjukeMainInformation = anjukeMainInformationService.getUserById(1L);  
        logger.info(JSON.toJSONString(anjukeMainInformation));  
    }  
}  
