package com.fmt.Umd.Dashboard.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.fmt.Umd.model.LiveCommunication;
import com.fmt.Umd.model.TotalMasterData;
import com.fmt.Umd.service.DeviceSummaryService;
@CrossOrigin(value="http://localhost:4200")
@RestController
@RequestMapping("/devicesummary")
public class DeviceSummaryController {
	
	
	@Autowired
	private DeviceSummaryService deviceSummaryService;
	
	@PostMapping("/userhirarchy")
	public Map<String,Map<Integer, String>> getHirarchyDetails(@RequestBody HierarchyDto hierarchyDto,Principal principal) {
		
		Map<String,Map<Integer, String>> hirarchyMap=new HashMap<>();
		try {
		String hirarchyLevels[]= {"Circle","Division","Zone","Substation"};
		String realHirarchy=null;
		if(principal.getName()!=null && hierarchyDto.getHierarchyId()!=0) {
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
			
			hirarchyMap.put("Region", deviceSummaryService.getUserHirarchy(principal.getName()));
			 
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
			
			List<TotalMasterData>	mastersize=null;
		    mastersize=deviceSummaryService.getMasterSizeFilter(hierarchyDto.getHirarchyLevel(), String.valueOf(hierarchyDto.getHierarchyId()));
			System.out.println("Hirarchy level :"+hierarchyDto.getHirarchyLevel());

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
	        System.out.println("Local date time=====>"+currentDate.toString());
	        int agCommCount=0;
       	    int nonAgCount=0;
       	    int kv33Count=0; 
       	    Set<String> agComm=new HashSet<>();
       	    Set<String> nonagComm=new HashSet<>();
       	    Set<String> Comm33Kv=new HashSet<>();

       	    List<LiveCommunication> liveCommunication=	 deviceSummaryService.getLiveStatus(currentDate.toString());
	        System.out.println("Communication :"+liveCommunication.size());
	        
	        for(LiveCommunication lc:liveCommunication) {
	        	if(agMeterSet.contains(lc.getMeterSerialNo().trim())) {
	        		agComm.add(lc.getMeterSerialNo());
	        	}
	        	else if(nonagMeterSet.contains(lc.getMeterSerialNo().trim())) {
	        		nonagComm.add(lc.getMeterSerialNo());
	        		
	        	}
	        	else if(kv33set.contains(lc.getMeterSerialNo())){
	        		Comm33Kv.add(lc.getMeterSerialNo());
	        	}
	        	else {
	        		continue;
	        	}
	        }
	   
	        map.put("AgCommunicating",agComm.size());
	        map.put("AgTotal", agMeterSet.size());
	        map.put("NonAgCommunicating",nonagComm.size());
	        map.put("NonAgTotal", nonagMeterSet.size());
			map.put("kvComm33", Comm33Kv.size());
			map.put("kvtotal33", kv33set.size());
			map.put("GrandToalCommunicating", agComm.size()+nonagComm.size()+Comm33Kv.size());
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

	//Sevendays communication status
	@PostMapping("/lastSevenDaysComm")
	public Map<String,Double>  sevenDaysStatus(@RequestBody HierarchyDto hierarchyDto) {
		Map<String,Double> lastSevenDaysCommPercentage=null;

		try {
			String hierarchyLevel=hierarchyDto.getHirarchyLevel();
			System.out.println("Hierarchy Level  :"+hierarchyLevel);
			//deviceSummaryService.getMasterSizeFilter(hierarchyLevel, String.valueOf(hierarchyDto.getHierarchyId()));
			// Date parsing
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String currentDate = "2022-06-02";
	        LocalDate parsedDate = LocalDate.parse(currentDate, inputFormatter);

	        System.out.println("Current Date : " + parsedDate.format(inputFormatter));

	        // Prepare output formatter
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        // Generate and print last 7 days
	        List<String> lastSevenDays = new ArrayList<>();
            lastSevenDays.add(parsedDate.format(inputFormatter));
	        for (int i = 1; i <= 6; i++) {
	            LocalDate date = parsedDate.minusDays(i);
	            lastSevenDays.add(date.format(outputFormatter));
	        }

	         lastSevenDaysCommPercentage=deviceSummaryService.getLastSevenDaysCommunicationStatus(hierarchyLevel,hierarchyDto.getHierarchyName(),hierarchyDto.getHierarchyId() , lastSevenDays);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lastSevenDaysCommPercentage;
	}

}
