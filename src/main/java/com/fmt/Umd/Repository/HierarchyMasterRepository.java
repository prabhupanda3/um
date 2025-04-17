package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fmt.Umd.model.HierarchyMaster;

public interface HierarchyMasterRepository extends JpaRepository<HierarchyMaster, Integer>{
    @Query("SELECT h.hierarchyTitle FROM HierarchyMaster h")

public List<String> findHierarchyTitle();
}
