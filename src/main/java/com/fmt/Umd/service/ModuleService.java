package com.fmt.Umd.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmt.Umd.Repository.ModuleRepository;
import com.fmt.Umd.model.Module;

@Service
public class ModuleService {
	@Autowired
	private ModuleRepository moduleRepository;
public Set<Module> getModuleListBySetOfEndpoints(Set<String> endpoints){
	Set<Module> moduleset=null;
	try {
	moduleset=moduleRepository.findModulesWithSubModules(endpoints);
	
	
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return moduleset;
	
}
}
