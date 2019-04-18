package dao;

import java.util.List;

import pojo.ShowAnjuke;

public interface ShowAnjukeMapper {
	 int add(ShowAnjuke showAnjuke); 
    
     void delete(int id); 
        
     ShowAnjuke get(int id); 
      
     int update(ShowAnjuke showAnjuke);  
        
     List<ShowAnjuke> list(String city);
     
     List<String> listMap(String city);
}
