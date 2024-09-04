package com.fmt.Umd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.model.TotalMasterData;

@Repository
public interface TotalMasterDataRepository extends JpaRepository<TotalMasterData, Integer>{
public List<TotalMasterData> findAllByRegionid(double regionId);
public List<TotalMasterData> findAllByCircleid(double circleId);
public List<TotalMasterData> findAllByDivisionid(double divisionid);
public List<TotalMasterData> findAllBySdid(double sdid);
public List<TotalMasterData> findAllBySsid(double ssid);



}
