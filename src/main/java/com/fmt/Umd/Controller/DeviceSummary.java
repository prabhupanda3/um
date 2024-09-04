package com.fmt.Umd.Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.HierarchyDto;
import com.fmt.Umd.Repository.LiveCommunicationRepository;
import com.fmt.Umd.model.LiveCommunication;
import com.fmt.Umd.model.TotalMasterData;
import com.fmt.Umd.service.DeviceSummaryService;
@RestController
@CrossOrigin(value = "http://localhost:4200")

@RequestMapping("/devicesummary")
public class DeviceSummary {
	@Autowired
	private DeviceSummaryService deviceSummaryService;
	@Autowired
	private LiveCommunicationRepository liveCommunicationRepository;
	@PostMapping("/userhirarchy")
	public Map<String,Map<Integer, String>> getHirarchyDetails(@RequestBody HierarchyDto hierarchyDto) {
		
		Map<String,Map<Integer, String>> hirarchyMap=new HashMap<>();
		try {
		String hirarchyLevels[]= {"Circle","Division","Zone","Substation"};
		String realHirarchy=null;
		if(hierarchyDto.getUsername()!=null && hierarchyDto.getHierarchyId()!=0) {
			String hirarchyLevel=hierarchyDto.getHirarchyLevel();
			System.out.println("Hirarchy Level :"+hirarchyLevel);
			for(String hi:hirarchyLevels ) {
				if(Integer.parseInt(hirarchyLevel)<4) {
					realHirarchy=hirarchyLevels[Integer.parseInt(hirarchyLevel)];	
					}
				else {
				Exception	ob= new Exception("Array Index OutOfboud Exception");
				throw ob;
				}
			} 
			 hirarchyMap.put(realHirarchy,deviceSummaryService.getHierarchyByParentid(hierarchyDto.getHierarchyId()));
			 return hirarchyMap;
		}else {
			
			hirarchyMap.put("Region", deviceSummaryService.getUserHirarchy(hierarchyDto.getUsername()));
			 
         return hirarchyMap;
		}
		}catch(Exception ob) {
			System.out.println(ob.getMessage());
		}
		
		return hirarchyMap;
	}
	@PostMapping("/daylivecommunication")
	public ResponseEntity<Map> getDayCommunication(@RequestBody HierarchyDto hierarchyDto) {
		Map<String,Integer> map=new LinkedHashMap<String, Integer>();
		try {
			System.out.println("=========Day Communication============="+hierarchyDto.getHirarchyLevel()+""+hierarchyDto.getHierarchyId());
			List<TotalMasterData>	mastersize=null;
			
				mastersize=deviceSummaryService.getMasterSizeFilter(hierarchyDto.getHirarchyLevel(), String.valueOf(hierarchyDto.getHierarchyId()));
            System.out.println("Master size :"+mastersize.toString());
			
			Set<String> agMeterSet=new HashSet<>();
            Set<String> nonagMeterSet=new HashSet<>();
            Set<String> kv33set=new HashSet<>();
System.out.println(mastersize.size());
			mastersize.stream().forEach((TotalMasterData tm)->{
			if(tm.getLocation_category().equals("AG")) {
				agMeterSet.add(tm.getMeter_sl_no());
			}
			else if(tm.getLocation_category().equals("NON AG")) {
				nonagMeterSet.add(tm.getMeter_sl_no());
			}
			else {
				kv33set.add(tm.getMeter_sl_no());
			}
			
		});
			LocalDate currentDate = LocalDate.now();
	        System.out.println("Local date time=====>"+currentDate);
	        int agCommCount=0;
       	 int nonAgCount=0;
       	 int kv33Count=0;  
	        List<LiveCommunication> liveCommunication=liveCommunicationRepository.findAllByLogtimestampLike(currentDate.toString());
	        for(LiveCommunication lc:liveCommunication) {
	        	if(agMeterSet.contains(lc.getMeterSerialNo())) {
	        		agCommCount++;
	        	}
	        	else if(nonagMeterSet.contains(lc.getMeterSerialNo())) {
	        		nonAgCount++;
	        	}
	        	else {
	        		kv33Count++;
	        	}
	        }
	   
	        map.put("AgCommunicating",agCommCount);
	        map.put("AgTotal", agMeterSet.size());
	        map.put("NonAgCommunicating",nonAgCount);
	        map.put("NonAgTotal", nonagMeterSet.size());
			map.put("kvComm33", kv33Count);
			map.put("kvtotal33", kv33set.size());
			map.put("GrandToalCommunicating", agCommCount+nonAgCount+nonAgCount);
			map.put("GrandTotal", mastersize.size());
			System.out.println(map.toString());
			return ResponseEntity
					.status(HttpStatus.OK)
                    .body(map);
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity
					.status(HttpStatus.OK)
                    .body(map);
		}
	}

}
