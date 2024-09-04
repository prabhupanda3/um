package com.fmt.Umd.Controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.Umd.Dto.FileDto;
import com.fmt.Umd.model.LoadServey;
import com.fmt.Umd.service.MDMReciverService;

@RestController
@RequestMapping("/MeterData")
public class MDMReciveingPoint {
	
	
	
	
	private MDMReciverService mDMReciverService;
	@Autowired
      public	MDMReciveingPoint(MDMReciverService mDMReciverService) {
             this.mDMReciverService=mDMReciverService;
	             }
           
           
	@PostMapping("/LSData")
	public ResponseEntity<String> getLSData(@RequestBody FileDto fileDto,Principal principal) {
		
		try {
			if((fileDto.getFileName()!=null) && (fileDto.getFileName().contains(".json"))) {
				List<LoadServey> ls=fileDto.getData();
			
		if(principal.getName().equals("Pravanjan")) {
			
		ls.stream().forEach((LoadServey lsdata)->lsdata.setSender("VIPLMDAS"));
		
		}else {
			ls.stream().forEach((LoadServey lsdata)->lsdata.setSender("WEBSCADA"));

		}
		ls.stream().forEach((LoadServey lsdata)->lsdata.setFileName(fileDto.getFileName()));
        if(mDMReciverService.lsDataProcess(ls)!=null) {
        	ResponseEntity<String> response=new ResponseEntity<String>("Data Integrated Success Fully", HttpStatus.OK);
       return response;
        }
        else {
        	throw new Exception("Duplicate Data Shared");
        }
		
		
			}
			else {
				throw new Exception("Invalid FileName");
			}
		}catch(Exception ex) {
        	return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);

			
		}
	}
	
	public void d4DataIntegration() {
		try {
			//mDMReciverService.integrationWithD4data();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
