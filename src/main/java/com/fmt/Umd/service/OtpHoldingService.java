package com.fmt.Umd.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class OtpHoldingService {
 
	public Map<String,Integer> holdOTP(String usename,int otp){
		Map<String,Integer> map=new HashMap<String,Integer>();
		try {
			map.put(usename, otp);
		}catch(Exception ex) { 
			ex.printStackTrace();
		}
		return map;
	}
}
