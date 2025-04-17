package com.fmt.Umd.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.ColumnHeaderRepository;
import com.fmt.Umd.Repository.D4dataRepository;
import com.fmt.Umd.Repository.LoadServeyRepository;
import com.fmt.Umd.Repository.LsDataStblRepository;
import com.fmt.Umd.model.D4data;
import com.fmt.Umd.model.D4dataColumnHeader;
import com.fmt.Umd.model.LoadServey;
import com.fmt.Umd.model.LsDataStbl;

@Service
public class MDMReciverService {

	@Autowired
	private LoadServeyRepository loadServeyRepository;
	@Autowired
	private ColumnHeaderRepository columnHeaderRepository;
	@Autowired
	private D4dataRepository d4dataRepository;;
	@Autowired
	private LsDataStblRepository lsDataStblRepository;
	
	public List<LoadServey>  lsDataProcess(List<LoadServey> ls) {
		List<LoadServey> savedList=null;
		try {
		 savedList=loadServeyRepository.saveAll(ls);
		
		return savedList;
	}catch(Exception ex) {
		return savedList;
		
	}
		
    }
	public void integrationWithD4data() {
		try {
			System.out.println("============Method triggered=============");
			//Lr,Ly,Lb,Vr,Vy,Vb,kWh(I),kVArh Lag(I),kVarh Lead,kVAh(I),NEW_0.0.96.8.0.255
			List<LoadServey> unprocessedlsList=loadServeyRepository.findByProcessedFalse();
               for(LoadServey upl:unprocessedlsList) {
            	   Map<String,Double> lsdatastbl=new HashMap<String,Double>();
            	   D4dataColumnHeader columnHeaders=columnHeaderRepository.findByMsn(upl.getMeterserialno());
            	   String columnHeader[]=columnHeaders.getLch().split(",");
            	   String dataString=""+"";
            	  for(String params:columnHeader) {
            		  if(params.equals("Lr")){
            			  dataString +=upl.getCurrent_r()+",";
            			  lsdatastbl.put("Lr", Double.parseDouble(upl.getCurrent_r()));
            			  System.out.println("Data Lr :"+upl.getCurrent_r());
            		  }
            		  else if(params.equals("Ly")) {
            			  dataString += upl.getCurrent_y()+",";
            			  lsdatastbl.put("Ly", Double.parseDouble(upl.getCurrent_y()));

            		  }
            		  else if(params.equals("Lb")){
            			  dataString += upl.getCurrent_b()+",";
            			  lsdatastbl.put("Lb", Double.parseDouble(upl.getCurrent_b()));

            		  }
            		  else if(params.equals("Vr")) {
            			  dataString += upl.getVoltage_rn()+",";
            			  lsdatastbl.put("Vr", Double.parseDouble(upl.getVoltage_rn()));

            		  }
            		  else if(params.equals("Vy")) {
            			  dataString += upl.getVoltage_yn()+",";
            			  lsdatastbl.put("Vy", Double.parseDouble(upl.getVoltage_yn()));

            		  }
            		  else if(params.equals("Vb")) {
            			  dataString += upl.getVoltage_bn()+",";
            			  lsdatastbl.put("Vb", Double.parseDouble(upl.getVoltage_bn()));

            		  }
            		  else if(params.equals("kWh(I)")) {
            			  dataString += upl.getActivepowerimport_wh()+",";
            			  lsdatastbl.put("kWh(I)", Double.parseDouble(upl.getActivepowerimport_wh()));

            		  }
            		  else if(params.equals("kVArh Lag(I)")) {
            			  dataString +=upl.getReactiveenergy_varh_lag_import()+",";
            			  lsdatastbl.put("kVArh Lag(I)", Double.parseDouble(upl.getReactiveenergy_varh_lag_import()));

            		  }
            		  else if(params.equals("kVarh Lead")) {
            			  dataString +=upl.getReactiveenergy_varh_lead_import()+",";
            			  lsdatastbl.put("kVarh Lead", Double.parseDouble(upl.getReactiveenergy_varh_lead_import()));

            		  }
            		  else if(params.equals("kVAh(I)")) {
            			  dataString +=upl.getApparentpowerimport_vah();
            			  lsdatastbl.put("kVAh(I)", Double.parseDouble(upl.getApparentpowerimport_vah()));

            		  }
            	  }
            	  D4data d4data=new D4data(); 
            	  d4data.setD4date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(upl.getMeterreading_timestamp())));
            	  d4data.setD4timeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(upl.getMeterreading_timestamp())));   	  
 String[] meterreadingtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(upl.getMeterreading_timestamp())).split(" ");
 String[] timetominite=meterreadingtime[1].split(":");
 int totalminites=Integer.parseInt(timetominite[0])*60+Integer.parseInt(timetominite[1]);
 int timeDelay=totalminites/15;
 System.out.println("Time Delay  :"+timeDelay);
 d4data.setTimeDelay(timeDelay);
 d4data.setDataString(dataString);
 d4data.setMeterSlno(upl.getMeterserialno());
 d4data.setLogTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(new Date().getTime())));
 Integer random=new Random().nextInt(99999 -10000  + 1) + 10000;
 d4data.setCdfid(random.toString());
 D4data d4datas=d4dataRepository.save(d4data);
 System.out.println("D4datas   ============>"+d4datas);
 System.out.println("lsdatastbl============>"+lsdatastbl);

 lsDataStbl(d4datas,lsdatastbl);

 if(d4datas!=null) {
	 LoadServey ls= loadServeyRepository.getBySequence(upl.getSequence_number());
	 ls.setProcessed(true);
	 loadServeyRepository.save(ls);
 }
 System.out.println("Reading time:"+meterreadingtime[1]);	
            	  System.out.println("Data String Lr data:"+lsdatastbl.get("Lr")+upl.getMeterserialno());	

                 }
			System.out.println("=======Method Colsed=========");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void lsDataStbl(D4data d4data,Map<String,Double> gainedValue) {
		try {
			LsDataStbl lsdastbl=new LsDataStbl();
			lsdastbl.setCdfid(d4data.getCdfid());
			lsdastbl.setD4_date(d4data.getD4date());
			lsdastbl.setTime_delay((int)d4data.getTimeDelay());
			lsdastbl.setVb(gainedValue.get("Vb"));
			lsdastbl.setVr(gainedValue.get("Vr"));
			lsdastbl.setVy(gainedValue.get("Vy"));
			lsdastbl.setLb(gainedValue.get("Lb"));
			lsdastbl.setLr(gainedValue.get("Lr"));
			lsdastbl.setLy(gainedValue.get("Ly"));
			//lsdastbl.setKvah_e(gainedValue.get(""));
			//lsdastbl.setKvah_i(gainedValue.get(""));
			lsdastbl.setKvarh_lag(gainedValue.get("kVArh Lag(I)"));
			lsdastbl.setKvarh_lead(gainedValue.get("kVarh Lead"));
			lsdastbl.setKwh_i(gainedValue.get("kWh(I)"));
			lsdastbl.setKvah_i(gainedValue.get("kVAh(I)"));
			double averageVoltage=gainedValue.get("Vb")+gainedValue.get("Vr")+gainedValue.get("Vy");
			lsdastbl.setVoltage_avg(averageVoltage/3);
			double averagecurrent=gainedValue.get("Lb")+gainedValue.get("Lr")+gainedValue.get("Ly");
			lsdastbl.setCurrent_avg(averagecurrent/3);
			//lsdastbl.setPhase_supply("");
			//lsdastbl.setEnergy_utilised("");
			//lsdastbl.setEnergy_saved("");
			//lsdastbl.setD4_TIME_STAMP(new Timestamp(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(d4data.getD4timeStamp()).getTime()));
			lsDataStblRepository.save(lsdastbl);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
