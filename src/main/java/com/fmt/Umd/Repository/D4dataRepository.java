package com.fmt.Umd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.D4data;

@Repository
public interface D4dataRepository extends JpaRepository<D4data, Long>{

}
