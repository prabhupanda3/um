package com.fmt.Umd.DeviceManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.DeviceManagement.Model.Hierarchy;


@Repository
public interface HyrarchyRepository extends JpaRepository<Hierarchy, Integer>{
	public List<Hierarchy> findByHierarchyPidAndActiveFlag(int hierarchyPid,int activeFlag);
    public List<Hierarchy> findAllByHierarchyIdIn(List<Integer> hierarchyIds);
}
