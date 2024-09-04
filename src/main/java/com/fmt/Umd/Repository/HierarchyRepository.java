package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.Hierarchy;

@Repository
public interface HierarchyRepository extends JpaRepository<Hierarchy, Long>{

	public List<Hierarchy> findByHierarchyPidAndActiveFlag(int hierarchyPid,int activeFlag);

   public List<Hierarchy> findByHierarchyIdIn(List<Integer> hierarchyIds);
	
}
