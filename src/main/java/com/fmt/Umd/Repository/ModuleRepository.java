package com.fmt.Umd.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.Module;



@Repository
public interface ModuleRepository extends JpaRepository<Module,Integer>{
    @Query("SELECT m FROM Module m , SubModule sm WHERE sm.endpoint IN (:endpoints) and (sm.activeFlag=true and m.activeFlag=true)")
public Set<Module> findModulesWithSubModules(Set<String> endpoints);
   public Set<Module> findModuleByModuleName(String moduleName);
}
