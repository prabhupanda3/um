package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.SubModule;


@Repository
public interface SabModuleRepository extends JpaRepository<SubModule, Integer>{
public List<SubModule> findSubmoduleBysubmoduleName(String sabmoduleName);
}
