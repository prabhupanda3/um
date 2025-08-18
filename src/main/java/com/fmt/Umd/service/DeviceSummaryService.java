package com.fmt.Umd.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Dashboard.Projection.CommSummaryProjection;
import com.fmt.Umd.Dashboard.Projection.DeviceDiagnosisSummaryProjection;
import com.fmt.Umd.Dashboard.Repository.DaySummaryRepository;
import com.fmt.Umd.Dashboard.Repository.DeviceDiagnosisSummaryRepository;
import com.fmt.Umd.DeviceManagement.Model.Hierarchy;
import com.fmt.Umd.DeviceManagement.Repository.HyrarchyRepository;
import com.fmt.Umd.Exception.HierarchyException;
import com.fmt.Umd.Repository.LiveCommunicationRepository;
import com.fmt.Umd.Repository.TotalMasterDataRepository;
import com.fmt.Umd.Repository.UserRepository;
import com.fmt.Umd.model.LiveCommunication;
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
 @Autowired
private LiveCommunicationRepository liveCommunicationRepository;
 @Autowired
 private DeviceDiagnosisSummaryRepository deviceDiagnosisSummaryRepository;
 @Autowired
 private DaySummaryRepository daySummaryRepository;
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
		String activeFlag="1";
		List<Hierarchy> hierarchylist=hierarchyRepository.findByHierarchyPidAndActiveFlg(hierarchyPid, activeFlag);
		System.out.println("Hierarchy List"+hierarchylist.size());
		
		for(Hierarchy hierarchy:hierarchylist) {
			System.out.println(hierarchy.getHierarchyId()+"   :   "+hierarchy.getHierarchyName());
			hirarchyMap.put(hierarchy.getHierarchyId(),hierarchy.getHierarchyName());			
		}
		
	}catch(Exception ex) {
		ex.printStackTrace();
}
	return hirarchyMap;
	}
public List<TotalMasterData> getMasterSizeFilter(String levelId, double hierarchyIds) {
    try {
        if (levelId == null) {
            throw new HierarchyException("Level ID is null");
        }

        int level = Integer.parseInt(levelId);

        switch (level) {
            case 0:
                return totalMasterDataRepository.findAllByRegionid(hierarchyIds);
            case 1:
                return totalMasterDataRepository.findAllByCircleid(hierarchyIds);
            case 2:
                return totalMasterDataRepository.findAllByDivisionid(hierarchyIds);
            case 3:
                return totalMasterDataRepository.findAllBySdid(hierarchyIds);
            case 4:
                return totalMasterDataRepository.findAllBySsid(hierarchyIds);
            default:
                throw new HierarchyException("Hierarchy level mismatched: " + level);
        }

    } catch (HierarchyException | NumberFormatException e) {
        // Log the error if logging is used
        // Fallback to region level
        return totalMasterDataRepository.findAllByRegionid(hierarchyIds);
    }
}
	
	public  List<LiveCommunication> getLiveStatus(String currentDate) {
		 List<LiveCommunication> liveCommunication=null;
		try {
			String logTimestamp="%"+currentDate+"%";
	       liveCommunication=liveCommunicationRepository.findByD3TimeStampLike(logTimestamp);
           return liveCommunication;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return liveCommunication;
	}
	//Last seven days communication graph
	public List<CommSummaryProjection> getLastSevenDaysCommunicationStatus(String level,String hierarchyName,List<String> commDate) {
		List<CommSummaryProjection> communicationCountPerday=null;
                System.out.println("Hierarchy level :"+level+" HierarchyName : "+hierarchyName+ " Comm data :"+commDate.toString());
		try {
              String hirarchyLevel=level;
              switch (hirarchyLevel) {
			case "0":
				communicationCountPerday=daySummaryRepository.findLastSevenDaysCommunicationBYDiscom(commDate, hierarchyName);
				break;
			case "1":
				communicationCountPerday=daySummaryRepository.findLastSevenDaysCommunicationByCircle(commDate, hierarchyName);
				break;
			case "2":
				communicationCountPerday=daySummaryRepository.findLastSevenDaysCommunicationByDivision(commDate,hierarchyName);
				break;
			case "3":
				communicationCountPerday=daySummaryRepository.findLastSevenDaysCommunicationBySdo(commDate, hierarchyName);
				break;
			default:
				break;
			}
              return communicationCountPerday;
		
		}catch(Exception ex) {
			ex.printStackTrace();
			return communicationCountPerday;
		}
	}
	
	public void getSignalStrength(String levelId, double hierarchyIds,String date) {
		try {
			
			List<TotalMasterData> totalMasterList=getMasterSizeFilter(levelId,hierarchyIds);
			List<String> meterList=new ArrayList<>();
			totalMasterList.stream().forEach((TotalMasterData tm)->meterList.add(tm.getMeter_sl_no()));
			List<DeviceDiagnosisSummaryProjection> ddsp=deviceDiagnosisSummaryRepository.getModemSlNumberAndgsmSignal(meterList,date);
			HashMap<String, Integer> hs=new HashMap<>();
			int goodSignalCount=0;
			ddsp.stream().forEach((DeviceDiagnosisSummaryProjection ddspj)->{
				if(Integer.parseInt(ddspj.getGsmSignal())>=20) {
					//hs.put("Good", goodSignalCount++);
				}
				else if(Integer.parseInt(ddspj.getGsmSignal())>=10 && Integer.parseInt(ddspj.getGsmSignal())<20) {
					
				}
				else {
					
				}
			});
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
}
