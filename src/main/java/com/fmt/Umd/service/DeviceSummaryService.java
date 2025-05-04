package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.Umd.DeviceManagement.Model.Hierarchy;
import com.fmt.Umd.DeviceManagement.Repository.HyrarchyRepository;
import com.fmt.Umd.Repository.TotalMasterDataRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.TotalMasterData;
import com.fmt.Umd.user.model.User;

@Service
public class DeviceSummaryService {
 @Autowired
 private HyrarchyRepository hierarchyRepository;
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private TotalMasterDataRepository totalMasterDataRepository;
	public Map<Integer, String> getUserHirarchy(String username) {
		Map<Integer, String> map=new HashMap<>();
		try {
			
       Optional<User>	user=userRepository.findByUsername(username);
		if(user.isPresent()) {
		     User	users=user.get();
	         String	hirarchy=users.getHierarchy();
	         System.out.println("hirarchy :"+hirarchy);
             String[]	hSet=hirarchy.split(",");
             List<Integer> hlist=new ArrayList<>();
   
             for(String s:hSet) {
	            hlist.add( Integer.parseInt(s));
             }
            System.out.println("Hlist  :"+hlist);
            List<Hierarchy>  hierarchyDeails=hierarchyRepository.findAllByHierarchyIdIn(hlist);
            if(!hierarchyDeails.isEmpty()) {
        	for(Hierarchy hierarchy:hierarchyDeails) {
        		System.out.println("HID   :"+hierarchy.getHierarchyId()+"   HNAME :"+hierarchy.getHierarchyName());
        		map.put(hierarchy.getHierarchyId(),hierarchy.getHierarchyName());
        	}

        }
        
	}
		}catch(Exception ex){
			ex.printStackTrace();
			 String str="Dear "+username+"  you dont have any hierarchy access";
			 map.put(1, str);
}
		 return map;
		
		
	
	}
public Map<Integer, String>	getHierarchyByParentid(int hierarchyPid){
	Map<Integer, String> hirarchyMap=new HashMap<Integer, String>();
	try {
		int activeFlag=1;
		List<Hierarchy> hierarchylist=hierarchyRepository.findByHierarchyPidAndActiveFlag(hierarchyPid, activeFlag);
		
		
		for(Hierarchy hierarchy:hierarchylist) {
			hirarchyMap.put(hierarchy.getHierarchyId(),hierarchy.getHierarchyName());			
		}
		
	}catch(Exception ex) {
		ex.printStackTrace();
}
	return hirarchyMap;
	}

public List<TotalMasterData> getMasterSizeFilter(String levelId,String hierarchyId){
	try {
		if(levelId!=null) {
		if(Integer.parseInt(levelId)==0) {
			return totalMasterDataRepository.findAllByRegionid(Double.parseDouble(hierarchyId));
		}
		else if(Integer.parseInt(levelId)==1) {
			return	totalMasterDataRepository.findAllByCircleid(Double.parseDouble(hierarchyId));
		}
		else if(Integer.parseInt(levelId)==2) {
			return	totalMasterDataRepository.findAllByDivisionid(Double.parseDouble(hierarchyId));
		}
		else if(Integer.parseInt(levelId)==3) {
			return	totalMasterDataRepository.findAllBySdid(Double.parseDouble(hierarchyId));
		}
		else if(Integer.parseInt(levelId)==4) {
			return	totalMasterDataRepository.findAllBySsid(Double.parseDouble(hierarchyId));
		}
		else {
			return	totalMasterDataRepository.findAllByRegionid(Double.parseDouble(hierarchyId));
		}
		}else {
			return totalMasterDataRepository.findAll();
		}
		
	}catch(Exception ex) {
		return totalMasterDataRepository.findAllByRegionid(Double.parseDouble(hierarchyId));
	}
}
	
	
	
}
