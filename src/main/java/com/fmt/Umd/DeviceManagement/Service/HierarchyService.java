package com.fmt.Umd.DeviceManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.Umd.DeviceManagement.Model.Hierarchy;
import com.fmt.Umd.DeviceManagement.Repository.HyrarchyRepository;

@Service
public class HierarchyService {
	@Autowired
	private HyrarchyRepository hyrarchyRepository;
	

     public void getHirarchyList(){
	try {
		List<Hierarchy>	hirarchyList=hyrarchyRepository.findByHierarchyPidAndActiveFlag(0, 0);
		hirarchyList.forEach((Hierarchy hierarchy)->{
			
		});
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
       }
}
