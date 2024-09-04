package com.fmt.Umd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.D4dataColumnHeader;
@Repository
public interface ColumnHeaderRepository extends JpaRepository<D4dataColumnHeader,Long>{
public D4dataColumnHeader findByMsn(String meterSlNo);
}
