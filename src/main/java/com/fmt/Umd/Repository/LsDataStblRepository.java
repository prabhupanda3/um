package com.fmt.Umd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.LsDataStbl;

@Repository

public interface LsDataStblRepository extends JpaRepository<LsDataStbl, Integer>{

	

}
